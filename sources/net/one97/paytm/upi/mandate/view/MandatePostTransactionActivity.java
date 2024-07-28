package net.one97.paytm.upi.mandate.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.m;
import kotlin.m.p;
import kotlin.n;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.common.upi.MandateDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiTransactionBankDetailsV2;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandatePayee;
import net.one97.paytm.upi.mandate.data.model.MandatePayer;
import net.one97.paytm.upi.mandate.e.c;
import net.one97.paytm.upi.mandate.f.a;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.s;
import net.one97.paytm.upi.mandate.utils.v;
import net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel;
import net.one97.paytm.upi.mandate.view.model.UpdateInfo;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class MandatePostTransactionActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67445a = new a((byte) 0);
    private Group A;
    private CreateMandateUiModel B;
    private MandateDefaultResponseModel C;
    private TextView D;
    private View E;

    /* renamed from: b  reason: collision with root package name */
    private TextView f67446b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f67447c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f67448d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f67449e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f67450f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f67451g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f67452h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f67453i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private TextView n;
    private LinearLayout o;
    private LinearLayout p;
    private ProgressBar q;
    private TextView r;
    private TextView s;
    private Group t;
    private net.one97.paytm.upi.mandate.f.a u;
    private net.one97.paytm.upi.mandate.confirmation.c v;
    private net.one97.paytm.upi.mandate.view.model.a w;
    private net.one97.paytm.upi.mandate.utils.k x;
    private TextView y;
    private TextView z;

    static final class b<T> implements z<net.one97.paytm.upi.mandate.view.model.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67454a;

        b(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67454a = mandatePostTransactionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.mandate.view.model.b bVar = (net.one97.paytm.upi.mandate.view.model.b) obj;
            if (bVar != null) {
                MandatePostTransactionActivity.a(this.f67454a, bVar);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.upi.mandate.data.a<List<? extends UpiProfileDefaultBank>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67455a;

        c(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67455a = mandatePostTransactionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            UpiProfileDefaultBank upiProfileDefaultBank;
            if (e.f67524b[((net.one97.paytm.upi.mandate.data.a) obj).f67117a.ordinal()] == 1 && (upiProfileDefaultBank = MandatePostTransactionActivity.f(this.f67455a).f67097b) != null) {
                MandatePostTransactionActivity.a(this.f67455a, upiProfileDefaultBank);
            }
        }
    }

    static final class d<T> implements z<r<MandateDefaultResponseModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67456a;

        d(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67456a = mandatePostTransactionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            int i2 = e.f67525c[rVar.f67411a.ordinal()];
            if (i2 == 1) {
                MandatePostTransactionActivity.g(this.f67456a);
            } else if (i2 == 2) {
                net.one97.paytm.upi.mandate.f.a c2 = MandatePostTransactionActivity.c(this.f67456a);
                CreateMandateUiModel b2 = MandatePostTransactionActivity.f(this.f67456a).b();
                T t = rVar.f67412b;
                if (t == null) {
                    kotlin.g.b.k.a();
                }
                c2.a(b2, (MandateDefaultResponseModel) t);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.f.a c(MandatePostTransactionActivity mandatePostTransactionActivity) {
        net.one97.paytm.upi.mandate.f.a aVar = mandatePostTransactionActivity.u;
        if (aVar == null) {
            kotlin.g.b.k.a("postTxnViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ TextView e(MandatePostTransactionActivity mandatePostTransactionActivity) {
        TextView textView = mandatePostTransactionActivity.f67446b;
        if (textView == null) {
            kotlin.g.b.k.a("tvStatusTitle");
        }
        return textView;
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.confirmation.c f(MandatePostTransactionActivity mandatePostTransactionActivity) {
        net.one97.paytm.upi.mandate.confirmation.c cVar = mandatePostTransactionActivity.v;
        if (cVar == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        return cVar;
    }

    public final void attachBaseContext(Context context) {
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
            return;
        }
        net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x03ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r14) {
        /*
            r13 = this;
            super.onCreate(r14)
            int r14 = net.one97.paytm.upi.R.layout.activity_mandate_posttxn
            r13.setContentView((int) r14)
            r14 = r13
            android.content.Context r14 = (android.content.Context) r14
            int r0 = net.one97.paytm.upi.R.color.white
            int r0 = androidx.core.content.b.c(r14, r0)
            r1 = r13
            android.app.Activity r1 = (android.app.Activity) r1
            net.one97.paytm.upi.util.UpiUtils.setStatusBarColor(r0, r1)
            android.content.Intent r0 = r13.getIntent()
            java.lang.String r1 = "create_mandate_data"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            if (r0 == 0) goto L_0x047e
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r0 = (net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel) r0
            r13.B = r0
            android.content.Intent r0 = r13.getIntent()
            java.lang.String r1 = "create_mandate_response_model"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            if (r0 == 0) goto L_0x0476
            net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel r0 = (net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel) r0
            r13.C = r0
            android.content.Intent r0 = r13.getIntent()
            java.lang.String r1 = "mandate_source"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            if (r0 == 0) goto L_0x046e
            net.one97.paytm.upi.mandate.utils.k r0 = (net.one97.paytm.upi.mandate.utils.k) r0
            r13.x = r0
            int r0 = net.one97.paytm.upi.R.id.bottomBarLayout
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.bottomBarLayout)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r13.E = r0
            int r0 = net.one97.paytm.upi.R.id.reEnterUpiPin
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.reEnterUpiPin)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.y = r0
            int r0 = net.one97.paytm.upi.R.id.setMpin
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.setMpin)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.z = r0
            int r0 = net.one97.paytm.upi.R.id.wrongMpinGroup
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.wrongMpinGroup)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            r13.A = r0
            int r0 = net.one97.paytm.upi.R.id.upiPinIncorrectHeading
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.upiPinIncorrectHeading)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.D = r0
            int r0 = net.one97.paytm.upi.R.id.tvScheduleStatusTitle
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvScheduleStatusTitle)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67446b = r0
            int r0 = net.one97.paytm.upi.R.id.tvAmount
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvAmount)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67447c = r0
            int r0 = net.one97.paytm.upi.R.id.tvPayeeName
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvPayeeName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67448d = r0
            int r0 = net.one97.paytm.upi.R.id.tvPayeeVpa
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvPayeeVpa)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67449e = r0
            int r0 = net.one97.paytm.upi.R.id.tvTxnDate
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvTxnDate)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.j = r0
            int r0 = net.one97.paytm.upi.R.id.tvStatusDescription
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvStatusDescription)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67450f = r0
            int r0 = net.one97.paytm.upi.R.id.ivStatusIcon
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.ivStatusIcon)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r13.f67451g = r0
            int r0 = net.one97.paytm.upi.R.id.tvUPIRef
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvUPIRef)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67452h = r0
            int r0 = net.one97.paytm.upi.R.id.tvViewQr
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvViewQr)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.k = r0
            int r0 = net.one97.paytm.upi.R.id.tvImportantLabel
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvImportantLabel)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.f67453i = r0
            int r0 = net.one97.paytm.upi.R.id.tvMakePayment
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvMakePayment)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.l = r0
            int r0 = net.one97.paytm.upi.R.id.tvNote
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.tvNote)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.n = r0
            int r0 = net.one97.paytm.upi.R.id.ivMakePaymentArrow
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.ivMakePaymentArrow)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r13.m = r0
            int r0 = net.one97.paytm.upi.R.id.ll_view_passbook
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.ll_view_passbook)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r13.o = r0
            int r0 = net.one97.paytm.upi.R.id.pbProgress
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.pbProgress)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r13.q = r0
            int r0 = net.one97.paytm.upi.R.id.ll_need_help
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.ll_need_help)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r13.p = r0
            int r0 = net.one97.paytm.upi.R.id.amountInWords
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.amountInWords)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.r = r0
            int r0 = net.one97.paytm.upi.R.id.viewDetailsTextView
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.viewDetailsTextView)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.s = r0
            int r0 = net.one97.paytm.upi.R.id.viewDetailsGroup
            android.view.View r0 = r13.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.viewDetailsGroup)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            r13.t = r0
            android.widget.TextView r0 = r13.j
            if (r0 != 0) goto L_0x01b6
            java.lang.String r1 = "tvTxnDate"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b6:
            java.lang.String r1 = net.one97.paytm.upi.util.UpiUtils.getCurrentDateAndTime()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.LinearLayout r0 = r13.o
            if (r0 != 0) goto L_0x01c8
            java.lang.String r1 = "tvViewPassbook"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01c8:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$e r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$e
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.l
            if (r0 != 0) goto L_0x01db
            java.lang.String r1 = "tvMakePayment"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01db:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$f r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$f
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.ImageView r0 = r13.m
            if (r0 != 0) goto L_0x01ee
            java.lang.String r1 = "ivMakePaymentArrow"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01ee:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$g r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$g
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.k
            if (r0 != 0) goto L_0x0201
            java.lang.String r1 = "tvViewQr"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0201:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$h r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$h
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.LinearLayout r0 = r13.p
            if (r0 != 0) goto L_0x0214
            java.lang.String r1 = "tvNeedHelp"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0214:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$i r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$i
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.upi.R.id.ivBackArrow
            android.view.View r0 = r13.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$j r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$j
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.r
            if (r0 != 0) goto L_0x0239
            java.lang.String r1 = "amountInWords"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0239:
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r1 = r13.B
            java.lang.String r2 = "createMandateData"
            if (r1 != 0) goto L_0x0242
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0242:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r1 = r1.getMandateConfirmationUiModel()
            java.lang.String r1 = r1.getAmountRule()
            java.lang.String r3 = "MAX"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            java.lang.String r4 = "mandateSource"
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x02a3
            net.one97.paytm.upi.mandate.utils.k r1 = r13.x
            if (r1 != 0) goto L_0x025d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x025d:
            net.one97.paytm.upi.mandate.utils.k r7 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r1 == r7) goto L_0x02a3
            int r1 = net.one97.paytm.upi.R.string.upi_mandate_upto
            java.lang.String r1 = r13.getString(r1)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            java.lang.String r1 = " "
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            int r1 = net.one97.paytm.upi.R.string.mt_amount_in_words_placeholder
            java.lang.Object[] r8 = new java.lang.Object[r6]
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r9 = r13.B
            if (r9 != 0) goto L_0x028b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x028b:
            java.lang.String r9 = r9.getAmount()
            java.lang.String r9 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r9)
            r8[r5] = r9
            java.lang.String r1 = r13.getString(r1, r8)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x02be
        L_0x02a3:
            int r1 = net.one97.paytm.upi.R.string.mt_amount_in_words_placeholder
            java.lang.Object[] r7 = new java.lang.Object[r6]
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r8 = r13.B
            if (r8 != 0) goto L_0x02ae
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x02ae:
            java.lang.String r8 = r8.getAmount()
            java.lang.String r8 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r8)
            r7[r5] = r8
            java.lang.String r1 = r13.getString(r1, r7)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x02be:
            r0.setText(r1)
            android.widget.TextView r0 = r13.s
            if (r0 != 0) goto L_0x02ca
            java.lang.String r1 = "viewDetail"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02ca:
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$k r1 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$k
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            java.lang.String r7 = "progressBar"
            if (r0 >= r1) goto L_0x0303
            android.widget.ProgressBar r0 = r13.q
            if (r0 != 0) goto L_0x02e3
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x02e3:
            android.graphics.drawable.Drawable r0 = r0.getIndeterminateDrawable()
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.f(r0)
            int r1 = net.one97.paytm.upi.R.color.pending_color
            int r1 = androidx.core.content.b.c(r14, r1)
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (int) r1)
            android.widget.ProgressBar r1 = r13.q
            if (r1 != 0) goto L_0x02fb
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x02fb:
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.g(r0)
            r1.setIndeterminateDrawable(r0)
            goto L_0x0319
        L_0x0303:
            android.widget.ProgressBar r0 = r13.q
            if (r0 != 0) goto L_0x030a
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x030a:
            android.graphics.drawable.Drawable r0 = r0.getIndeterminateDrawable()
            int r1 = net.one97.paytm.upi.R.color.pending_color
            int r1 = androidx.core.content.b.c(r14, r1)
            android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.SRC_IN
            r0.setColorFilter(r1, r7)
        L_0x0319:
            r0 = r13
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            r1 = 0
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.upi.mandate.f.a> r8 = net.one97.paytm.upi.mandate.f.a.class
            androidx.lifecycle.ai r7 = r7.a(r8)
            java.lang.String r8 = "ViewModelProviders.of(ac…, factory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            net.one97.paytm.upi.mandate.f.a r7 = (net.one97.paytm.upi.mandate.f.a) r7
            r13.u = r7
            net.one97.paytm.upi.mandate.utils.o r7 = new net.one97.paytm.upi.mandate.utils.o
            r7.<init>()
            androidx.lifecycle.al$b r7 = (androidx.lifecycle.al.b) r7
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r7)
            java.lang.Class<net.one97.paytm.upi.mandate.confirmation.c> r9 = net.one97.paytm.upi.mandate.confirmation.c.class
            androidx.lifecycle.ai r7 = r7.a(r9)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            net.one97.paytm.upi.mandate.confirmation.c r7 = (net.one97.paytm.upi.mandate.confirmation.c) r7
            r13.v = r7
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.upi.mandate.view.model.a> r9 = net.one97.paytm.upi.mandate.view.model.a.class
            androidx.lifecycle.ai r7 = r7.a(r9)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            net.one97.paytm.upi.mandate.view.model.a r7 = (net.one97.paytm.upi.mandate.view.model.a) r7
            r13.w = r7
            net.one97.paytm.upi.mandate.confirmation.c r7 = r13.v
            java.lang.String r8 = "mandateConfirmationViewModel"
            if (r7 != 0) goto L_0x0362
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0362:
            net.one97.paytm.upi.mandate.utils.k r9 = r13.x
            if (r9 != 0) goto L_0x0369
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0369:
            r7.a((net.one97.paytm.upi.mandate.utils.k) r9)
            net.one97.paytm.upi.mandate.f.a r7 = r13.u
            java.lang.String r9 = "postTxnViewModel"
            if (r7 != 0) goto L_0x0375
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0375:
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r10 = r13.B
            if (r10 != 0) goto L_0x037c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x037c:
            net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel r11 = r13.C
            if (r11 != 0) goto L_0x0385
            java.lang.String r12 = "createMandateStatus"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0385:
            r7.a(r10, r11)
            net.one97.paytm.upi.mandate.f.a r7 = r13.u
            if (r7 != 0) goto L_0x038f
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x038f:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.view.model.b> r7 = r7.f67199b
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            r9 = r13
            androidx.lifecycle.q r9 = (androidx.lifecycle.q) r9
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$b r10 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$b
            r10.<init>(r13)
            androidx.lifecycle.z r10 = (androidx.lifecycle.z) r10
            r7.observe(r9, r10)
            net.one97.paytm.upi.mandate.confirmation.c r7 = r13.v
            if (r7 != 0) goto L_0x03a7
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x03a7:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r7 = r7.f67096a
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$c r10 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$c
            r10.<init>(r13)
            androidx.lifecycle.z r10 = (androidx.lifecycle.z) r10
            r7.observe(r9, r10)
            net.one97.paytm.upi.mandate.confirmation.c r7 = r13.v
            if (r7 != 0) goto L_0x03bc
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x03bc:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.utils.r<net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel>> r7 = r7.f67098c
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$d r8 = new net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity$d
            r8.<init>(r13)
            androidx.lifecycle.z r8 = (androidx.lifecycle.z) r8
            r7.observe(r9, r8)
            int r7 = net.one97.paytm.upi.R.id.uptoPlaceHolder
            android.view.View r7 = r13.findViewById(r7)
            java.lang.String r8 = "findViewById<TextView>(R.id.uptoPlaceHolder)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r8 = r13.B
            if (r8 != 0) goto L_0x03dc
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x03dc:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r8.getMandateConfirmationUiModel()
            if (r2 != 0) goto L_0x03e5
            kotlin.g.b.k.a()
        L_0x03e5:
            java.lang.String r2 = r2.getAmountRule()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x03fb
            net.one97.paytm.upi.mandate.utils.k r2 = r13.x
            if (r2 != 0) goto L_0x03f6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03f6:
            net.one97.paytm.upi.mandate.utils.k r3 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r2 == r3) goto L_0x03fb
            r5 = 1
        L_0x03fb:
            net.one97.paytm.upi.f.a((android.view.View) r7, (boolean) r5)
            android.widget.TextView r2 = r13.f67453i
            if (r2 != 0) goto L_0x0407
            java.lang.String r3 = "tvImportantLabel"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0407:
            int r3 = net.one97.paytm.upi.R.drawable.upi_ic_important
            net.one97.paytm.upi.f.a((android.widget.TextView) r2, (int) r3)
            net.one97.paytm.upi.common.UpiGTMLoader r2 = net.one97.paytm.upi.common.UpiGTMLoader.getInstance()
            java.lang.String r3 = "UpiGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = r2.getBottomBarUrl()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.getAuthDefaultParams(r14)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = com.paytm.utility.b.t(r14, r2)
            r3.append(r14)
            java.lang.String r14 = "&child_site_id="
            r3.append(r14)
            java.lang.String r14 = com.paytm.utility.a.b()
            r3.append(r14)
            java.lang.String r14 = "&site_id="
            r3.append(r14)
            java.lang.String r14 = com.paytm.utility.a.a()
            r3.append(r14)
            java.lang.String r14 = r3.toString()
            net.one97.paytm.upi.i r2 = net.one97.paytm.upi.i.a()
            java.lang.String r3 = "PaytmUpiSdk.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.upi.h r2 = r2.c()
            android.view.View r3 = r13.E
            if (r3 != 0) goto L_0x046a
            java.lang.String r4 = "bottomBarView"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x046a:
            r2.a(r3, r1, r14, r0)
            return
        L_0x046e:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.mandate.utils.MandateSource"
            r14.<init>(r0)
            throw r14
        L_0x0476:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel"
            r14.<init>(r0)
            throw r14
        L_0x047e:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity.onCreate(android.os.Bundle):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67457a;

        e(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67457a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            MandatePostTransactionActivity.a(this.f67457a);
            this.f67457a.finish();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67458a;

        f(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67458a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            MandatePostTransactionActivity.b(this.f67458a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67459a;

        g(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67459a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            MandatePostTransactionActivity.b(this.f67459a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67460a;

        h(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67460a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.upi.mandate.f.a c2 = MandatePostTransactionActivity.c(this.f67460a);
            kotlin.g.b.k.c("action_view_qr", "action");
            if ("action_view_qr".hashCode() == -1461483278) {
                CreateMandateUiModel createMandateUiModel = c2.f67201d;
                if (createMandateUiModel == null) {
                    kotlin.g.b.k.a("_createMandateData");
                }
                UpiUtils.convertDateFromTo("dd/MM/yyyy", "dd MMM yyyy", createMandateUiModel.getStartDate());
                CreateMandateUiModel createMandateUiModel2 = c2.f67201d;
                if (createMandateUiModel2 == null) {
                    kotlin.g.b.k.a("_createMandateData");
                }
                UpiUtils.convertDateFromTo("dd/MM/yyyy", "dd MMM yyyy", createMandateUiModel2.getEndDate());
                String str = c2.f67202e;
                if (str != null) {
                    s<a.b> sVar = c2.f67200c;
                    CreateMandateUiModel createMandateUiModel3 = c2.f67201d;
                    if (createMandateUiModel3 == null) {
                        kotlin.g.b.k.a("_createMandateData");
                    }
                    String payeeAccountName = createMandateUiModel3.getPayeeAccountName();
                    if (payeeAccountName == null) {
                        kotlin.g.b.k.a();
                    }
                    CreateMandateUiModel createMandateUiModel4 = c2.f67201d;
                    if (createMandateUiModel4 == null) {
                        kotlin.g.b.k.a("_createMandateData");
                    }
                    String amount = createMandateUiModel4.getAmount();
                    if (amount == null) {
                        kotlin.g.b.k.a();
                    }
                    CreateMandateUiModel createMandateUiModel5 = c2.f67201d;
                    if (createMandateUiModel5 == null) {
                        kotlin.g.b.k.a("_createMandateData");
                    }
                    String startDate = createMandateUiModel5.getStartDate();
                    CreateMandateUiModel createMandateUiModel6 = c2.f67201d;
                    if (createMandateUiModel6 == null) {
                        kotlin.g.b.k.a("_createMandateData");
                    }
                    String endDate = createMandateUiModel6.getEndDate();
                    CreateMandateUiModel createMandateUiModel7 = c2.f67201d;
                    if (createMandateUiModel7 == null) {
                        kotlin.g.b.k.a("_createMandateData");
                    }
                    sVar.setValue(new a.b.C1360a("mandate_qr_activity", payeeAccountName, amount, startDate, endDate, createMandateUiModel7.getComments(), str));
                }
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67461a;

        i(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67461a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            MandatePostTransactionActivity.d(this.f67461a);
            net.one97.paytm.upi.mandate.f.a c2 = MandatePostTransactionActivity.c(this.f67461a);
            kotlin.g.b.k.c(MandatePostTransactionActivity.e(this.f67461a).getText().toString(), "tvScheduleStatusTitle");
            net.one97.paytm.upi.mandate.view.model.b c3 = c2.c();
            String str = c2.b().getMandateConfirmationUiModel().getExtraIntentParams() == null ? "COLLECT" : "INTENT";
            String str2 = c3.f67605i;
            String str3 = c3.f67598b;
            String str4 = c3.f67600d;
            String valueOf = String.valueOf(new Date().getTime());
            String str5 = c3.k;
            String str6 = c3.j;
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            String e2 = a2.e();
            net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
            UpiTransactionBankDetailsV2 upiTransactionBankDetailsV2 = new UpiTransactionBankDetailsV2(e2, "", a3.d(), c3.f67604h, c2.b().getPayerIfsc(), c3.f67603g, UpiUtils.getMobile(c2.f67203f), "", c2.b().getPayerVpa());
            net.one97.paytm.upi.i a4 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a4, "PaytmUpiSdk.getInstance()");
            UpiTransactionBankDetailsV2 upiTransactionBankDetailsV22 = new UpiTransactionBankDetailsV2(a4.e(), "", c2.b().getMandateConfirmationUiModel().getPayeeName(), "", "", "", "", "", c2.b().getPayeeAccountVpa());
            String a5 = c2.a();
            Date parse = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(c2.b().getStartDate());
            kotlin.g.b.k.a((Object) parse, "SimpleDateFormat(FORMAT_…reationModel().startDate)");
            Long valueOf2 = Long.valueOf(parse.getTime());
            Date parse2 = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(c2.b().getEndDate());
            kotlin.g.b.k.a((Object) parse2, "SimpleDateFormat(FORMAT_…eCreationModel().endDate)");
            UpiTransactionModelV2 upiTransactionModelV2 = new UpiTransactionModelV2(str2, str3, str4, valueOf, str5, "DEBIT", str, str6, upiTransactionBankDetailsV2, upiTransactionBankDetailsV22, "Automatic Payment", "", "P2M", "MANDATE", new MandateDetails(a5, valueOf2, Long.valueOf(parse2.getTime()), "", "RECURRING"));
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText("UPI");
            cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
            net.one97.paytm.upi.i a6 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a6, "PaytmUpiSdk.getInstance()");
            a6.c().a((Activity) this.f67461a, (Object) upiTransactionModelV2, cJRReplacementReason);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67462a;

        j(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67462a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            this.f67462a.finish();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandatePostTransactionActivity f67463a;

        k(MandatePostTransactionActivity mandatePostTransactionActivity) {
            this.f67463a = mandatePostTransactionActivity;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            c.a aVar = net.one97.paytm.upi.mandate.e.c.f67166a;
            net.one97.paytm.upi.mandate.f.a c2 = MandatePostTransactionActivity.c(this.f67463a);
            CreateMandateUiModel createMandateUiModel = c2.f67201d;
            if (createMandateUiModel == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            if (p.a(createMandateUiModel.getMaxDebitAmount())) {
                CreateMandateUiModel createMandateUiModel2 = c2.f67201d;
                if (createMandateUiModel2 == null) {
                    kotlin.g.b.k.a("_createMandateData");
                }
                str = createMandateUiModel2.getAmount();
            } else {
                CreateMandateUiModel createMandateUiModel3 = c2.f67201d;
                if (createMandateUiModel3 == null) {
                    kotlin.g.b.k.a("_createMandateData");
                }
                str = createMandateUiModel3.getMaxDebitAmount();
            }
            String str3 = str;
            String a2 = c2.a();
            CreateMandateUiModel createMandateUiModel4 = c2.f67201d;
            if (createMandateUiModel4 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            MandateConfirmationUiModel mandateConfirmationUiModel = createMandateUiModel4.getMandateConfirmationUiModel();
            String amountRule = mandateConfirmationUiModel != null ? mandateConfirmationUiModel.getAmountRule() : null;
            CreateMandateUiModel createMandateUiModel5 = c2.f67201d;
            if (createMandateUiModel5 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            String payerBankAcc = createMandateUiModel5.getPayerBankAcc();
            CreateMandateUiModel createMandateUiModel6 = c2.f67201d;
            if (createMandateUiModel6 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            String payerIfsc = createMandateUiModel6.getPayerIfsc();
            CreateMandateUiModel createMandateUiModel7 = c2.f67201d;
            if (createMandateUiModel7 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            String payerBankName = createMandateUiModel7.getPayerBankName();
            CreateMandateUiModel createMandateUiModel8 = c2.f67201d;
            if (createMandateUiModel8 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            MandatePayer mandatePayer = new MandatePayer((String) null, (String) null, payerBankAcc, payerIfsc, payerBankName, createMandateUiModel8.getPayeeAccountVpa(), (String) null);
            CreateMandateUiModel createMandateUiModel9 = c2.f67201d;
            if (createMandateUiModel9 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            String payeeAccountName = createMandateUiModel9.getPayeeAccountName();
            CreateMandateUiModel createMandateUiModel10 = c2.f67201d;
            if (createMandateUiModel10 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            MandatePayee mandatePayee = new MandatePayee((String) null, payeeAccountName, (String) null, (String) null, (String) null, createMandateUiModel10.getPayeeAccountVpa(), (String) null, (String) null);
            net.one97.paytm.upi.mandate.view.model.b value = c2.f67199b.getValue();
            if (value == null || (str2 = value.j) == null) {
                str2 = "";
            }
            String str4 = str2;
            CreateMandateUiModel createMandateUiModel11 = c2.f67201d;
            if (createMandateUiModel11 == null) {
                kotlin.g.b.k.a("_createMandateData");
            }
            MandateItem mandateItem = new MandateItem((String) null, a2, (String) null, "", str3, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, amountRule, mandatePayer, mandatePayee, (String) null, str4, (String) null, (String) null, "", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "", createMandateUiModel11.getMandateConfirmationUiModel().getPurpose());
            androidx.fragment.app.j supportFragmentManager = this.f67463a.getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            c.a.a(mandateItem, supportFragmentManager);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r3 = this;
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r0 = r3.B
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "createMandateData"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            net.one97.paytm.upi.mandate.view.model.UpdateInfo r0 = r0.getUpdateInfo()
            if (r0 == 0) goto L_0x0014
            net.one97.paytm.upi.mandate.utils.v r0 = r0.getUpdate()
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x0018
            goto L_0x002c
        L_0x0018:
            int[] r1 = net.one97.paytm.upi.mandate.view.e.f67528f
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0056
            r1 = 2
            if (r0 == r1) goto L_0x004a
            r1 = 3
            if (r0 == r1) goto L_0x003e
            r1 = 4
            if (r0 != r1) goto L_0x0038
        L_0x002c:
            int r0 = net.one97.paytm.upi.R.string.mandate_important_note
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "getString(R.string.mandate_important_note)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x0061
        L_0x0038:
            kotlin.m r0 = new kotlin.m
            r0.<init>()
            throw r0
        L_0x003e:
            int r0 = net.one97.paytm.upi.R.string.mandate_cancel_imp_message_post_txn
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "getString(R.string.manda…cel_imp_message_post_txn)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x0061
        L_0x004a:
            int r0 = net.one97.paytm.upi.R.string.mandate_resume_imp_message
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "getString(R.string.mandate_resume_imp_message)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            goto L_0x0061
        L_0x0056:
            int r0 = net.one97.paytm.upi.R.string.mandate_pause_imp_message
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "getString(R.string.mandate_pause_imp_message)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x0061:
            android.widget.TextView r1 = r3.f67450f
            if (r1 != 0) goto L_0x006a
            java.lang.String r2 = "tvStatusImpDesc"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x006a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity.a():void");
    }

    private final void b() {
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) this);
        kotlin.g.b.k.a((Object) a2, "LocalBroadcastManager.getInstance(this)");
        a2.a(new Intent("action_refresh_received_mandates"));
        a2.a(new Intent("action_refresh_pending_mandates"));
        a2.a(new Intent("action_refresh_scheduled_mandates"));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, MandateDefaultResponseModel mandateDefaultResponseModel, CreateMandateUiModel createMandateUiModel, net.one97.paytm.upi.mandate.utils.k kVar) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(mandateDefaultResponseModel, "mandateDefaultResponseModel");
            kotlin.g.b.k.c(createMandateUiModel, "createMandateUIData");
            kotlin.g.b.k.c(kVar, "source");
            Intent intent = new Intent(context, MandatePostTransactionActivity.class);
            intent.putExtra("create_mandate_response_model", mandateDefaultResponseModel);
            intent.putExtra("create_mandate_data", createMandateUiModel);
            intent.putExtra("mandate_source", kVar);
            if (kVar == net.one97.paytm.upi.mandate.utils.k.INTENT) {
                intent.setFlags(268468224);
            }
            context.startActivity(intent);
        }
    }

    private final void a(net.one97.paytm.upi.mandate.view.model.b bVar) {
        String str;
        String str2 = kotlin.g.b.k.a((Object) bVar.f67598b, (Object) net.one97.paytm.upi.mandate.utils.c.FAILURE.getType()) ? Events.Action.SCREEN_OPEN_WITH_ERROR : "screen_open";
        net.one97.paytm.upi.mandate.utils.k kVar = this.x;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar == net.one97.paytm.upi.mandate.utils.k.INTENT) {
            Context context = this;
            String str3 = bVar.f67598b;
            String str4 = bVar.f67599c;
            CreateMandateUiModel createMandateUiModel = this.B;
            if (createMandateUiModel == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa = createMandateUiModel.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel2 = this.B;
            if (createMandateUiModel2 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_INTENT, str2, str3, str4, "", payeeAccountVpa, createMandateUiModel2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar2 = this.x;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar2 == net.one97.paytm.upi.mandate.utils.k.PAYER_UPDATE) {
            CreateMandateUiModel createMandateUiModel3 = this.B;
            if (createMandateUiModel3 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            UpdateInfo updateInfo = createMandateUiModel3.getUpdateInfo();
            v update = updateInfo != null ? updateInfo.getUpdate() : null;
            if (update == null) {
                str = "";
            } else {
                int i2 = e.f67527e[update.ordinal()];
                if (i2 == 1) {
                    str = GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_PAUSE_POST_TXN;
                } else if (i2 == 2) {
                    str = GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_RESUME_POST_TXN;
                } else if (i2 == 3) {
                    str = GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_REVOKE_POST_TXN;
                } else if (i2 == 4) {
                    str = GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_UPDATE_POST_TXN;
                } else {
                    throw new m();
                }
            }
            String str5 = str;
            Context context2 = this;
            String str6 = bVar.f67598b;
            String str7 = bVar.f67599c;
            CreateMandateUiModel createMandateUiModel4 = this.B;
            if (createMandateUiModel4 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa2 = createMandateUiModel4.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel5 = this.B;
            if (createMandateUiModel5 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, str2, str6, str7, "", payeeAccountVpa2, createMandateUiModel5.getAmount(), str5, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar3 = this.x;
        if (kVar3 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar3 == net.one97.paytm.upi.mandate.utils.k.COLLECT) {
            Context context3 = this;
            String str8 = bVar.f67598b;
            String str9 = bVar.f67599c;
            CreateMandateUiModel createMandateUiModel6 = this.B;
            if (createMandateUiModel6 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa3 = createMandateUiModel6.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel7 = this.B;
            if (createMandateUiModel7 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, str2, str8, str9, "", payeeAccountVpa3, createMandateUiModel7.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar4 = this.x;
        if (kVar4 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar4 == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
            Context context4 = this;
            String str10 = bVar.f67598b;
            String str11 = bVar.f67599c;
            CreateMandateUiModel createMandateUiModel8 = this.B;
            if (createMandateUiModel8 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa4 = createMandateUiModel8.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel9 = this.B;
            if (createMandateUiModel9 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context4, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, str2, str10, str11, "", payeeAccountVpa4, createMandateUiModel9.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "");
            return;
        }
        net.one97.paytm.upi.mandate.utils.k kVar5 = this.x;
        if (kVar5 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar5 == net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH) {
            Context context5 = this;
            String str12 = bVar.f67598b;
            String str13 = bVar.f67599c;
            CreateMandateUiModel createMandateUiModel10 = this.B;
            if (createMandateUiModel10 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa5 = createMandateUiModel10.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel11 = this.B;
            if (createMandateUiModel11 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context5, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, str2, str12, str13, "", payeeAccountVpa5, createMandateUiModel11.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_POST_TXN, "");
        }
    }

    public static final /* synthetic */ void a(MandatePostTransactionActivity mandatePostTransactionActivity) {
        Intent intent = new Intent(mandatePostTransactionActivity, UpiPassbookActivity.class);
        intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
        mandatePostTransactionActivity.startActivity(intent);
    }

    public static final /* synthetic */ void b(MandatePostTransactionActivity mandatePostTransactionActivity) {
        mandatePostTransactionActivity.startActivity(new Intent(mandatePostTransactionActivity, MandateSelectVpaActivity.class));
        mandatePostTransactionActivity.finish();
    }

    public static final /* synthetic */ void d(MandatePostTransactionActivity mandatePostTransactionActivity) {
        MandatePostTransactionActivity mandatePostTransactionActivity2 = mandatePostTransactionActivity;
        net.one97.paytm.upi.mandate.utils.k kVar = mandatePostTransactionActivity2.x;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        int i2 = e.f67523a[kVar.ordinal()];
        String str = null;
        if (i2 == 1) {
            Context context = mandatePostTransactionActivity2;
            net.one97.paytm.upi.mandate.f.a aVar = mandatePostTransactionActivity2.u;
            if (aVar == null) {
                kotlin.g.b.k.a("postTxnViewModel");
            }
            net.one97.paytm.upi.mandate.view.model.b bVar = (net.one97.paytm.upi.mandate.view.model.b) aVar.f67199b.getValue();
            if (bVar != null) {
                str = bVar.f67598b;
            }
            String str2 = str;
            CreateMandateUiModel createMandateUiModel = mandatePostTransactionActivity2.B;
            if (createMandateUiModel == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa = createMandateUiModel.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel2 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel2 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, Events.Action.NEED_HELP_CLICKED, str2, "", "", payeeAccountVpa, createMandateUiModel2.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "UPI");
        } else if (i2 == 2) {
            Context context2 = mandatePostTransactionActivity2;
            net.one97.paytm.upi.mandate.f.a aVar2 = mandatePostTransactionActivity2.u;
            if (aVar2 == null) {
                kotlin.g.b.k.a("postTxnViewModel");
            }
            net.one97.paytm.upi.mandate.view.model.b bVar2 = (net.one97.paytm.upi.mandate.view.model.b) aVar2.f67199b.getValue();
            if (bVar2 != null) {
                str = bVar2.f67598b;
            }
            CreateMandateUiModel createMandateUiModel3 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel3 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa2 = createMandateUiModel3.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel4 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel4 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_INTENT, Events.Action.NEED_HELP_CLICKED, str, "", "", payeeAccountVpa2, createMandateUiModel4.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "UPI");
        } else if (i2 == 3) {
            Context context3 = mandatePostTransactionActivity2;
            net.one97.paytm.upi.mandate.f.a aVar3 = mandatePostTransactionActivity2.u;
            if (aVar3 == null) {
                kotlin.g.b.k.a("postTxnViewModel");
            }
            net.one97.paytm.upi.mandate.view.model.b bVar3 = (net.one97.paytm.upi.mandate.view.model.b) aVar3.f67199b.getValue();
            if (bVar3 != null) {
                str = bVar3.f67598b;
            }
            String str3 = str;
            CreateMandateUiModel createMandateUiModel5 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel5 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa3 = createMandateUiModel5.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel6 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel6 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION, Events.Action.NEED_HELP_CLICKED, str3, "", "", payeeAccountVpa3, createMandateUiModel6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_POST_TXN, "UPI");
        } else if (i2 != 4 && i2 == 5) {
            Context context4 = mandatePostTransactionActivity2;
            net.one97.paytm.upi.mandate.f.a aVar4 = mandatePostTransactionActivity2.u;
            if (aVar4 == null) {
                kotlin.g.b.k.a("postTxnViewModel");
            }
            net.one97.paytm.upi.mandate.view.model.b bVar4 = (net.one97.paytm.upi.mandate.view.model.b) aVar4.f67199b.getValue();
            if (bVar4 != null) {
                str = bVar4.f67598b;
            }
            String str4 = str;
            CreateMandateUiModel createMandateUiModel7 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel7 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            String payeeAccountVpa4 = createMandateUiModel7.getPayeeAccountVpa();
            CreateMandateUiModel createMandateUiModel8 = mandatePostTransactionActivity2.B;
            if (createMandateUiModel8 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context4, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, Events.Action.NEED_HELP_CLICKED, str4, "", "", payeeAccountVpa4, createMandateUiModel8.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_POST_TXN, "UPI");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0382, code lost:
        if (r2 == net.one97.paytm.upi.mandate.utils.k.INTENT) goto L_0x0384;
     */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity r18, net.one97.paytm.upi.mandate.view.model.b r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = r1.m
            net.one97.paytm.upi.mandate.utils.e r3 = net.one97.paytm.upi.mandate.utils.e.P2M
            java.lang.String r3 = r3.name()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            r3 = 0
            r4 = 0
            java.lang.String r5 = "mandateSource"
            r6 = 1
            if (r2 == 0) goto L_0x0358
            java.lang.String r2 = r1.f67598b
            net.one97.paytm.upi.mandate.utils.c r7 = net.one97.paytm.upi.mandate.utils.c.PENDING
            java.lang.String r7 = r7.getType()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            java.lang.String r8 = "tvStatusTitle"
            java.lang.String r9 = "tvImportantLabel"
            java.lang.String r10 = "viewDetailGroup"
            java.lang.String r11 = "progressBar"
            java.lang.String r12 = "ivStatusIcon"
            r13 = 4
            r14 = 3
            r15 = 2
            java.lang.String r16 = "createMandateData"
            java.lang.String r17 = "tvStatusImpDesc"
            if (r7 == 0) goto L_0x0129
            androidx.constraintlayout.widget.Group r2 = r0.t
            if (r2 != 0) goto L_0x003d
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x003d:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            android.widget.TextView r2 = r0.f67450f
            if (r2 != 0) goto L_0x0049
            kotlin.g.b.k.a((java.lang.String) r17)
        L_0x0049:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            android.widget.TextView r2 = r0.f67453i
            if (r2 != 0) goto L_0x0055
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0055:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r2 = r0.B
            if (r2 != 0) goto L_0x0061
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0061:
            net.one97.paytm.upi.mandate.view.model.UpdateInfo r2 = r2.getUpdateInfo()
            if (r2 == 0) goto L_0x006c
            net.one97.paytm.upi.mandate.utils.v r2 = r2.getUpdate()
            goto L_0x006d
        L_0x006c:
            r2 = r3
        L_0x006d:
            android.widget.TextView r7 = r0.f67446b
            if (r7 != 0) goto L_0x0074
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0074:
            if (r2 != 0) goto L_0x00a3
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x007d:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE
            if (r2 != r8) goto L_0x0088
            int r2 = net.one97.paytm.upi.R.string.upi_update_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
            goto L_0x00a0
        L_0x0088:
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x008f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x008f:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r2 != r8) goto L_0x009a
            int r2 = net.one97.paytm.upi.R.string.mandate_upi_payment_processing
            java.lang.String r2 = r0.getString(r2)
            goto L_0x00a0
        L_0x009a:
            int r2 = net.one97.paytm.upi.R.string.upi_create_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
        L_0x00a0:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x00dc
        L_0x00a3:
            int[] r8 = net.one97.paytm.upi.mandate.view.e.f67530h
            int r2 = r2.ordinal()
            r2 = r8[r2]
            if (r2 == r6) goto L_0x00d4
            if (r2 == r15) goto L_0x00cb
            if (r2 == r14) goto L_0x00c2
            if (r2 != r13) goto L_0x00bc
            int r2 = net.one97.paytm.upi.R.string.upi_cancel_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x00dc
        L_0x00bc:
            kotlin.m r0 = new kotlin.m
            r0.<init>()
            throw r0
        L_0x00c2:
            int r2 = net.one97.paytm.upi.R.string.upi_resume_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x00dc
        L_0x00cb:
            int r2 = net.one97.paytm.upi.R.string.upi_pause_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x00dc
        L_0x00d4:
            int r2 = net.one97.paytm.upi.R.string.upi_update_mandate_processing_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x00dc:
            r7.setText(r2)
            boolean r2 = r1.f67597a
            if (r2 == 0) goto L_0x00f4
            android.widget.ProgressBar r2 = r0.q
            if (r2 != 0) goto L_0x00ea
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x00ea:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            r18.a()
            goto L_0x0358
        L_0x00f4:
            r18.b()
            android.widget.ImageView r2 = r0.f67451g
            if (r2 != 0) goto L_0x00fe
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x00fe:
            int r7 = net.one97.paytm.upi.R.drawable.ic_pending_copy
            r2.setImageResource(r7)
            android.widget.ProgressBar r2 = r0.q
            if (r2 != 0) goto L_0x010a
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x010a:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            android.widget.TextView r2 = r0.f67450f
            if (r2 != 0) goto L_0x0116
            kotlin.g.b.k.a((java.lang.String) r17)
        L_0x0116:
            int r7 = net.one97.paytm.upi.R.string.upi_create_mandate_p2m_pending_desc
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r9 = r1.f67603g
            r8[r4] = r9
            java.lang.String r7 = r0.getString(r7, r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            goto L_0x0355
        L_0x0129:
            net.one97.paytm.upi.mandate.utils.c r7 = net.one97.paytm.upi.mandate.utils.c.FAILURE
            java.lang.String r7 = r7.getType()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0235
            androidx.constraintlayout.widget.Group r2 = r0.t
            if (r2 != 0) goto L_0x013c
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x013c:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r2 = r0.B
            if (r2 != 0) goto L_0x0148
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0148:
            net.one97.paytm.upi.mandate.view.model.UpdateInfo r2 = r2.getUpdateInfo()
            if (r2 == 0) goto L_0x0153
            net.one97.paytm.upi.mandate.utils.v r2 = r2.getUpdate()
            goto L_0x0154
        L_0x0153:
            r2 = r3
        L_0x0154:
            android.widget.TextView r7 = r0.f67446b
            if (r7 != 0) goto L_0x015b
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x015b:
            if (r2 != 0) goto L_0x018a
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0164
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0164:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE
            if (r2 != r8) goto L_0x016f
            int r2 = net.one97.paytm.upi.R.string.upi_update_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
            goto L_0x0187
        L_0x016f:
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0176
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0176:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r2 != r8) goto L_0x0181
            int r2 = net.one97.paytm.upi.R.string.mandate_upi_payment_failed
            java.lang.String r2 = r0.getString(r2)
            goto L_0x0187
        L_0x0181:
            int r2 = net.one97.paytm.upi.R.string.upi_create_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
        L_0x0187:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x01c3
        L_0x018a:
            int[] r8 = net.one97.paytm.upi.mandate.view.e.f67531i
            int r2 = r2.ordinal()
            r2 = r8[r2]
            if (r2 == r6) goto L_0x01bb
            if (r2 == r15) goto L_0x01b2
            if (r2 == r14) goto L_0x01a9
            if (r2 != r13) goto L_0x01a3
            int r2 = net.one97.paytm.upi.R.string.upi_cancel_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x01c3
        L_0x01a3:
            kotlin.m r0 = new kotlin.m
            r0.<init>()
            throw r0
        L_0x01a9:
            int r2 = net.one97.paytm.upi.R.string.upi_resume_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x01c3
        L_0x01b2:
            int r2 = net.one97.paytm.upi.R.string.upi_pause_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x01c3
        L_0x01bb:
            int r2 = net.one97.paytm.upi.R.string.upi_update_mandate_failure_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x01c3:
            r7.setText(r2)
            android.widget.ImageView r2 = r0.f67451g
            if (r2 != 0) goto L_0x01cd
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x01cd:
            int r7 = net.one97.paytm.upi.R.drawable.upi_txn_failed
            r2.setImageResource(r7)
            android.widget.ProgressBar r2 = r0.q
            if (r2 != 0) goto L_0x01d9
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x01d9:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            r18.b()
            android.widget.TextView r2 = r0.f67453i
            if (r2 != 0) goto L_0x01e8
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x01e8:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            android.widget.TextView r2 = r0.f67450f
            if (r2 != 0) goto L_0x01f4
            kotlin.g.b.k.a((java.lang.String) r17)
        L_0x01f4:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            android.widget.TextView r2 = r0.D
            if (r2 != 0) goto L_0x0202
            java.lang.String r7 = "errorTextView"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0202:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            boolean r2 = r1.l
            if (r2 == 0) goto L_0x0220
            android.widget.TextView r2 = r0.D
            if (r2 != 0) goto L_0x0214
            java.lang.String r7 = "errorTextView"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0214:
            int r7 = net.one97.paytm.upi.R.string.mandate_the_upi_pin_entered_was_incorrect
            java.lang.String r7 = r0.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            goto L_0x0230
        L_0x0220:
            android.widget.TextView r2 = r0.D
            if (r2 != 0) goto L_0x0229
            java.lang.String r7 = "errorTextView"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0229:
            java.lang.String r7 = r1.f67599c
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
        L_0x0230:
            r18.a((net.one97.paytm.upi.mandate.view.model.b) r19)
            goto L_0x0358
        L_0x0235:
            net.one97.paytm.upi.mandate.utils.c r7 = net.one97.paytm.upi.mandate.utils.c.SUCCESS
            java.lang.String r7 = r7.getType()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x0358
            androidx.constraintlayout.widget.Group r2 = r0.t
            if (r2 != 0) goto L_0x0248
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0248:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r2 = r0.B
            if (r2 != 0) goto L_0x0254
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x0254:
            net.one97.paytm.upi.mandate.view.model.UpdateInfo r2 = r2.getUpdateInfo()
            if (r2 == 0) goto L_0x025f
            net.one97.paytm.upi.mandate.utils.v r2 = r2.getUpdate()
            goto L_0x0260
        L_0x025f:
            r2 = r3
        L_0x0260:
            android.widget.TextView r7 = r0.f67446b
            if (r7 != 0) goto L_0x0267
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0267:
            if (r2 != 0) goto L_0x0296
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0270
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0270:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE
            if (r2 != r8) goto L_0x027b
            int r2 = net.one97.paytm.upi.R.string.mandate_update_payment_scheduled_for
            java.lang.String r2 = r0.getString(r2)
            goto L_0x0293
        L_0x027b:
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0282
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0282:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.COLLECT_AUTH
            if (r2 != r8) goto L_0x028d
            int r2 = net.one97.paytm.upi.R.string.mandate_upi_payment_success
            java.lang.String r2 = r0.getString(r2)
            goto L_0x0293
        L_0x028d:
            int r2 = net.one97.paytm.upi.R.string.mandate_payment_scheduled_for
            java.lang.String r2 = r0.getString(r2)
        L_0x0293:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x02cf
        L_0x0296:
            int[] r8 = net.one97.paytm.upi.mandate.view.e.j
            int r2 = r2.ordinal()
            r2 = r8[r2]
            if (r2 == r6) goto L_0x02c7
            if (r2 == r15) goto L_0x02be
            if (r2 == r14) goto L_0x02b5
            if (r2 != r13) goto L_0x02af
            int r2 = net.one97.paytm.upi.R.string.mandate_cancel_schedule_payment
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x02cf
        L_0x02af:
            kotlin.m r0 = new kotlin.m
            r0.<init>()
            throw r0
        L_0x02b5:
            int r2 = net.one97.paytm.upi.R.string.mandate_resume_schedule_payment
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x02cf
        L_0x02be:
            int r2 = net.one97.paytm.upi.R.string.mandate_pause_schedule_payment
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x02cf
        L_0x02c7:
            int r2 = net.one97.paytm.upi.R.string.mandate_update_payment_scheduled_for
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x02cf:
            r7.setText(r2)
            android.widget.ImageView r2 = r0.f67451g
            if (r2 != 0) goto L_0x02d9
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x02d9:
            int r7 = net.one97.paytm.upi.R.drawable.ic_payment_success
            r2.setImageResource(r7)
            android.widget.TextView r2 = r0.k
            if (r2 != 0) goto L_0x02e7
            java.lang.String r7 = "tvViewQr"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x02e7:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            android.widget.ProgressBar r2 = r0.q
            if (r2 != 0) goto L_0x02f3
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x02f3:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
            r18.b()
            android.widget.TextView r2 = r0.f67453i
            if (r2 != 0) goto L_0x0302
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0302:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            android.widget.TextView r2 = r0.f67450f
            if (r2 != 0) goto L_0x030e
            kotlin.g.b.k.a((java.lang.String) r17)
        L_0x030e:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            r18.a()
            net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel r2 = r0.B
            if (r2 != 0) goto L_0x031d
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x031d:
            net.one97.paytm.upi.mandate.view.model.UpdateInfo r2 = r2.getUpdateInfo()
            if (r2 == 0) goto L_0x0355
            net.one97.paytm.upi.mandate.utils.v r2 = r2.getUpdate()
            if (r2 != 0) goto L_0x032a
            goto L_0x0355
        L_0x032a:
            int[] r7 = net.one97.paytm.upi.mandate.view.e.f67529g
            int r2 = r2.ordinal()
            r2 = r7[r2]
            if (r2 == r6) goto L_0x0349
            if (r2 == r15) goto L_0x0346
            if (r2 == r14) goto L_0x0343
            if (r2 != r13) goto L_0x033d
            int r2 = net.one97.paytm.upi.R.drawable.ic_mandate_update_payment
            goto L_0x034b
        L_0x033d:
            kotlin.m r0 = new kotlin.m
            r0.<init>()
            throw r0
        L_0x0343:
            int r2 = net.one97.paytm.upi.R.drawable.ic_mandate_cancel_payment
            goto L_0x034b
        L_0x0346:
            int r2 = net.one97.paytm.upi.R.drawable.ic_mandate_resume_payment
            goto L_0x034b
        L_0x0349:
            int r2 = net.one97.paytm.upi.R.drawable.ic_mandate_pause_payment
        L_0x034b:
            android.widget.ImageView r7 = r0.f67451g
            if (r7 != 0) goto L_0x0352
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0352:
            r7.setImageResource(r2)
        L_0x0355:
            r18.a((net.one97.paytm.upi.mandate.view.model.b) r19)
        L_0x0358:
            java.lang.String r2 = r1.k
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r7 = "tvNote"
            if (r2 != 0) goto L_0x03b2
            java.lang.String r2 = r1.k
            java.lang.String r8 = "NA"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r6)
            if (r2 != 0) goto L_0x03b2
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0375
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0375:
            net.one97.paytm.upi.mandate.utils.k r8 = net.one97.paytm.upi.mandate.utils.k.COLLECT
            if (r2 == r8) goto L_0x0384
            net.one97.paytm.upi.mandate.utils.k r2 = r0.x
            if (r2 != 0) goto L_0x0380
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0380:
            net.one97.paytm.upi.mandate.utils.k r5 = net.one97.paytm.upi.mandate.utils.k.INTENT
            if (r2 != r5) goto L_0x03b2
        L_0x0384:
            android.widget.TextView r2 = r0.n
            if (r2 != 0) goto L_0x038b
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x038b:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            android.widget.TextView r2 = r0.n
            if (r2 != 0) goto L_0x0397
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0397:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "\" "
            r5.<init>(r7)
            java.lang.String r7 = r1.k
            r5.append(r7)
            java.lang.String r7 = " \""
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            goto L_0x03be
        L_0x03b2:
            android.widget.TextView r2 = r0.n
            if (r2 != 0) goto L_0x03b9
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03b9:
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.a((android.view.View) r2)
        L_0x03be:
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.upi.R.string.rs_str
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r5 = "getString(R.string.rs_str)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r7 = r1.f67600d
            java.lang.String r7 = net.one97.paytm.upi.util.UpiAppUtils.priceToString((java.lang.String) r7)
            r5[r4] = r7
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.String r2 = java.lang.String.format(r2, r5)
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.widget.TextView r5 = r0.f67447c
            if (r5 != 0) goto L_0x03eb
            java.lang.String r7 = "tvAmount"
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03eb:
            net.one97.paytm.upi.util.UpiAppUtils.updateAmount(r2, r5)
            android.widget.TextView r2 = r0.f67448d
            if (r2 != 0) goto L_0x03f7
            java.lang.String r5 = "tvPayeeName"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x03f7:
            int r5 = net.one97.paytm.upi.R.string.upi_direction_to
            java.lang.String r5 = r0.getString(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = r1.f67602f
            if (r5 == 0) goto L_0x040d
            java.lang.String r3 = net.one97.paytm.upi.f.a((java.lang.String) r5)
        L_0x040d:
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r0.f67449e
            if (r2 != 0) goto L_0x0422
            java.lang.String r3 = "tvPayeeVpa"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0422:
            int r3 = net.one97.paytm.upi.R.string.upi_address_value
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r7 = r1.f67601e
            r5[r4] = r7
            java.lang.String r3 = r0.getString(r3, r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            java.lang.String r2 = r1.j
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0457
            android.widget.TextView r2 = r0.f67452h
            if (r2 != 0) goto L_0x0446
            java.lang.String r3 = "tvUpiRef"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0446:
            int r3 = net.one97.paytm.upi.R.string.upi_reference_num
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r1 = r1.j
            r5[r4] = r1
            java.lang.String r0 = r0.getString(r3, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x0457:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity.a(net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity, net.one97.paytm.upi.mandate.view.model.b):void");
    }

    public static final /* synthetic */ void a(MandatePostTransactionActivity mandatePostTransactionActivity, UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.mandate.utils.k kVar = mandatePostTransactionActivity.x;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        int i2 = e.f67526d[kVar.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            net.one97.paytm.upi.mandate.confirmation.c cVar = mandatePostTransactionActivity.v;
            if (cVar == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            CreateMandateUiModel createMandateUiModel = mandatePostTransactionActivity.B;
            if (createMandateUiModel == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            MandateConfirmationUiModel mandateConfirmationUiModel = createMandateUiModel.getMandateConfirmationUiModel();
            if (mandateConfirmationUiModel == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.upi.mandate.utils.k kVar2 = mandatePostTransactionActivity.x;
            if (kVar2 == null) {
                kotlin.g.b.k.a("mandateSource");
            }
            cVar.a(mandateConfirmationUiModel, kVar2);
        } else if (i2 == 4) {
            net.one97.paytm.upi.mandate.d.a aVar = net.one97.paytm.upi.mandate.d.a.f67112a;
            CreateMandateUiModel createMandateUiModel2 = mandatePostTransactionActivity.B;
            if (createMandateUiModel2 == null) {
                kotlin.g.b.k.a("createMandateData");
            }
            MandateConfirmationUiModel mandateConfirmationUiModel2 = createMandateUiModel2.getMandateConfirmationUiModel();
            if (mandateConfirmationUiModel2 == null) {
                kotlin.g.b.k.a();
            }
            MandateItem a2 = net.one97.paytm.upi.mandate.d.a.a(mandateConfirmationUiModel2, upiProfileDefaultBank);
            net.one97.paytm.upi.mandate.d.a aVar2 = net.one97.paytm.upi.mandate.d.a.f67112a;
            UpiPendingRequestModel b2 = net.one97.paytm.upi.mandate.d.a.b(a2);
            net.one97.paytm.upi.mandate.view.model.a aVar3 = mandatePostTransactionActivity.w;
            if (aVar3 == null) {
                kotlin.g.b.k.a("pendingMandatePagerItemViewModel");
            }
            aVar3.a(a2);
            net.one97.paytm.upi.mandate.view.model.a aVar4 = mandatePostTransactionActivity.w;
            if (aVar4 == null) {
                kotlin.g.b.k.a("pendingMandatePagerItemViewModel");
            }
            aVar4.a(b2, upiProfileDefaultBank);
        } else if (i2 == 5) {
            throw new n((String) null, 1, (kotlin.g.b.g) null);
        }
    }

    public static final /* synthetic */ void g(MandatePostTransactionActivity mandatePostTransactionActivity) {
        CharSequence charSequence;
        ImageView imageView = mandatePostTransactionActivity.f67451g;
        if (imageView == null) {
            kotlin.g.b.k.a("ivStatusIcon");
        }
        imageView.setImageDrawable((Drawable) null);
        Group group = mandatePostTransactionActivity.t;
        if (group == null) {
            kotlin.g.b.k.a("viewDetailGroup");
        }
        net.one97.paytm.upi.f.a((View) group);
        TextView textView = mandatePostTransactionActivity.f67450f;
        if (textView == null) {
            kotlin.g.b.k.a("tvStatusImpDesc");
        }
        net.one97.paytm.upi.f.b((View) textView);
        TextView textView2 = mandatePostTransactionActivity.f67453i;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvImportantLabel");
        }
        net.one97.paytm.upi.f.b((View) textView2);
        TextView textView3 = mandatePostTransactionActivity.f67446b;
        if (textView3 == null) {
            kotlin.g.b.k.a("tvStatusTitle");
        }
        net.one97.paytm.upi.mandate.utils.k kVar = mandatePostTransactionActivity.x;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar == net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE) {
            charSequence = mandatePostTransactionActivity.getString(R.string.upi_update_mandate_processing_msg);
        } else {
            charSequence = mandatePostTransactionActivity.getString(R.string.upi_create_mandate_processing_msg);
        }
        textView3.setText(charSequence);
        ProgressBar progressBar = mandatePostTransactionActivity.q;
        if (progressBar == null) {
            kotlin.g.b.k.a("progressBar");
        }
        net.one97.paytm.upi.f.b((View) progressBar);
        TextView textView4 = mandatePostTransactionActivity.f67450f;
        if (textView4 == null) {
            kotlin.g.b.k.a("tvStatusImpDesc");
        }
        textView4.setText(mandatePostTransactionActivity.getString(R.string.mandate_important_note));
    }
}
