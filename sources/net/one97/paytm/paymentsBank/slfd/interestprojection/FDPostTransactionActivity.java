package net.one97.paytm.paymentsBank.slfd.interestprojection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.fragment.k;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.createfd.view.SlfdLandingPageActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.c.b;
import net.one97.paytm.paymentsBank.slfd.interestprojection.c.d;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel;
import net.one97.paytm.paymentsBank.utils.CircularProgressBarBank;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public class FDPostTransactionActivity extends PaytmActivity implements View.OnClickListener {
    private d A;
    private boolean B;
    private b C;
    private String D;
    private View E;
    private List<Integer> F = new ArrayList<Integer>() {
        {
            add(1);
            add(3);
            add(5);
            add(8);
            add(15);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f19127a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19128b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f19129c;

    /* renamed from: d  reason: collision with root package name */
    private CircularProgressBarBank f19130d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19131e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f19132f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f19133g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f19134h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f19135i;
    private TextView j;
    private RelativeLayout k;
    private RelativeLayout l;
    private View m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private boolean u;
    private LinearLayout v;
    private net.one97.paytm.paymentsBank.slfd.interestprojection.a.b w;
    private double x = 0.0d;
    private String y;
    private boolean z;

    public void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_confirmation_screen);
        this.y = getIntent().getStringExtra("order_id");
        getIntent().getDoubleExtra("slfd_amount", 0.0d);
        getIntent().getStringExtra("account_num");
        Intent intent = getIntent();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (intent.hasExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18192g)) {
            Intent intent2 = getIntent();
            b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            this.D = intent2.getStringExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18192g);
        }
        this.u = getIntent().getBooleanExtra("is_from_impulse", false);
        this.f19127a = (RelativeLayout) findViewById(R.id.rl_loader_wrapper);
        this.f19127a.setVisibility(0);
        this.f19128b = (TextView) findViewById(R.id.tv_confirmation_heading);
        this.f19129c = (ImageView) findViewById(R.id.iv_fd_status);
        this.f19130d = (CircularProgressBarBank) findViewById(R.id.pb_pending);
        this.t = (TextView) findViewById(R.id.tv_update_deposit);
        this.f19131e = (TextView) findViewById(R.id.tv_amount);
        this.f19132f = (TextView) findViewById(R.id.tv_date);
        ((RelativeLayout) findViewById(R.id.ll_24_7_container)).setOnClickListener(this);
        this.f19133g = (RecyclerView) findViewById(R.id.rv_fd_detail);
        this.f19133g.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19133g.setNestedScrollingEnabled(false);
        this.f19134h = (TextView) findViewById(R.id.tv_view_details);
        this.f19134h.setOnClickListener(this);
        this.f19135i = (TextView) findViewById(R.id.tv_updated_account_balance);
        this.f19135i.setVisibility(8);
        findViewById(R.id.tv_money_transfer);
        this.l = (RelativeLayout) findViewById(R.id.rl_money_transfer_container);
        this.m = findViewById(R.id.view_sep_above_mt);
        this.l.setOnClickListener(this);
        this.k = (RelativeLayout) findViewById(R.id.ll_update_deposit_container);
        this.E = findViewById(R.id.view_sep_2);
        this.j = (TextView) findViewById(R.id.tv_deposit_amount);
        this.k.setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.rl_share_wrapper)).setOnClickListener(this);
        this.n = (TextView) findViewById(R.id.tv_requested_amount);
        this.o = (LinearLayout) findViewById(R.id.ll_tax_deducted_wrapper);
        this.p = (TextView) findViewById(R.id.tv_tax_deducted);
        this.q = (TextView) findViewById(R.id.tv_request_to_break_fd);
        this.r = (TextView) findViewById(R.id.tv_bank_name);
        this.s = (TextView) findViewById(R.id.tv_to);
        this.v = (LinearLayout) findViewById(R.id.ll_fd_detail_wrapper);
        if (!TextUtils.isEmpty(this.D)) {
            String str = this.D;
            b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (str.equalsIgnoreCase(net.one97.paytm.paymentsBank.createfd.utils.b.n)) {
                this.k.setVisibility(8);
                this.E.setVisibility(8);
                a(true);
            }
        }
        e();
        findViewById(R.id.iv_back_arrow).setVisibility(0);
        findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FDPostTransactionActivity.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void e() {
        if (this.A == null) {
            this.A = d.STARTED;
        }
        if (!this.A.equals(d.FINISHED)) {
            if (this.A.equals(d.RUNNING) && this.F.size() == 0) {
                this.A = d.FINISHED;
            }
            net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(this);
            a2.f19202a = this;
            a2.a(this.y, j.a().equalsIgnoreCase("ICA") ? "ica" : "isa", (g.b) new g.b() {
                public final void onResponse(Object obj) {
                    FDPostTransactionActivity.this.a(obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    FDPostTransactionActivity.this.b(i2, iJRPaytmDataModel, networkCustomError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:41|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r9.f19132f.setVisibility(8);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0134 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.String r0 = "hh:mm a, dd MMM yyyy"
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel r10 = (net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel) r10     // Catch:{ Exception -> 0x0217 }
            if (r10 == 0) goto L_0x001d
            java.lang.String r1 = "failure"
            java.lang.String r2 = r10.getStatus()     // Catch:{ Exception -> 0x0217 }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0217 }
            if (r1 == 0) goto L_0x001d
            java.lang.String r10 = r10.getMessage()     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.bankCommon.mapping.a.a((android.content.Context) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x0217 }
            r9.finish()     // Catch:{ Exception -> 0x0217 }
            return
        L_0x001d:
            if (r10 == 0) goto L_0x0217
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$a r1 = r10.getRedemptionResponse()     // Catch:{ Exception -> 0x0217 }
            if (r1 == 0) goto L_0x0217
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$a r10 = r10.getRedemptionResponse()     // Catch:{ Exception -> 0x0217 }
            java.util.List<net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b> r1 = r10.f19215h     // Catch:{ Exception -> 0x0217 }
            r2 = 1
            if (r1 == 0) goto L_0x004e
            java.util.List<net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b> r1 = r10.f19215h     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0217 }
            if (r1 <= 0) goto L_0x004e
            r9.B = r2     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.a.b r1 = new net.one97.paytm.paymentsBank.slfd.interestprojection.a.b     // Catch:{ Exception -> 0x0217 }
            java.util.List<net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b> r3 = r10.f19215h     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r4 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0217 }
            r1.<init>(r9, r3, r4)     // Catch:{ Exception -> 0x0217 }
            r9.w = r1     // Catch:{ Exception -> 0x0217 }
            androidx.recyclerview.widget.RecyclerView r1 = r9.f19133g     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.a.b r3 = r9.w     // Catch:{ Exception -> 0x0217 }
            r1.setAdapter(r3)     // Catch:{ Exception -> 0x0217 }
        L_0x004e:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r1 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_PENDING     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r3 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r1 == r3) goto L_0x00b4
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r1 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r3 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r1 != r3) goto L_0x006b
            goto L_0x00b4
        L_0x006b:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS     // Catch:{ Exception -> 0x0217 }
            int r0 = r0.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r1 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r0 != r1) goto L_0x0083
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{ Exception -> 0x0217 }
            r9.A = r0     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS     // Catch:{ Exception -> 0x0217 }
            r9.a((net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.a) r10, (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b) r0)     // Catch:{ Exception -> 0x0217 }
            return
        L_0x0083:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_FAILED     // Catch:{ Exception -> 0x0217 }
            int r0 = r0.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r1 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r0 != r1) goto L_0x009b
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{ Exception -> 0x0217 }
            r9.A = r0     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_FAILED     // Catch:{ Exception -> 0x0217 }
            r9.a((net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.a) r10, (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b) r0)     // Catch:{ Exception -> 0x0217 }
            return
        L_0x009b:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_FAILED     // Catch:{ Exception -> 0x0217 }
            int r0 = r0.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r1 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r0 != r1) goto L_0x0217
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{ Exception -> 0x0217 }
            r9.A = r0     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_FAILED     // Catch:{ Exception -> 0x0217 }
            r9.a((net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.a) r10, (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b) r0)     // Catch:{ Exception -> 0x0217 }
            goto L_0x0217
        L_0x00b4:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r1 = r9.A     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r3 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.STARTED     // Catch:{ Exception -> 0x0217 }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0217 }
            r3 = 0
            r4 = 8
            if (r1 != 0) goto L_0x00cb
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r1 = r9.A     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r5 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.RUNNING     // Catch:{ Exception -> 0x0217 }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x0217 }
            if (r1 == 0) goto L_0x0139
        L_0x00cb:
            android.widget.RelativeLayout r1 = r9.f19127a     // Catch:{ Exception -> 0x0217 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r1 = r9.f19131e     // Catch:{ Exception -> 0x0217 }
            int r5 = net.one97.paytm.paymentsBank.R.string.rs_str     // Catch:{ Exception -> 0x0217 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0217 }
            double r7 = r10.f19208a     // Catch:{ Exception -> 0x0217 }
            java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0217 }
            java.lang.String r7 = net.one97.paytm.bankCommon.mapping.a.c(r7)     // Catch:{ Exception -> 0x0217 }
            r6[r3] = r7     // Catch:{ Exception -> 0x0217 }
            java.lang.String r5 = r9.getString(r5, r6)     // Catch:{ Exception -> 0x0217 }
            r1.setText(r5)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r1 = r9.f19128b     // Catch:{ Exception -> 0x0217 }
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fd_processing_transfer     // Catch:{ Exception -> 0x0217 }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x0217 }
            r1.setText(r5)     // Catch:{ Exception -> 0x0217 }
            android.widget.ImageView r1 = r9.f19129c     // Catch:{ Exception -> 0x0217 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.utils.CircularProgressBarBank r1 = r9.f19130d     // Catch:{ Exception -> 0x0217 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r1 = r9.f19135i     // Catch:{ Exception -> 0x0217 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            android.widget.RelativeLayout r1 = r9.k     // Catch:{ Exception -> 0x0217 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            r9.a((boolean) r2)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r1 = r9.f19132f     // Catch:{ Exception -> 0x0217 }
            java.util.List<net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b> r2 = r10.f19215h     // Catch:{ Exception -> 0x0217 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b r2 = (net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.b) r2     // Catch:{ Exception -> 0x0217 }
            long r5 = r2.f19220e     // Catch:{ Exception -> 0x0217 }
            java.lang.String r0 = net.one97.paytm.paymentsBank.slfd.b.a.a.a(r0, r0, r5)     // Catch:{ Exception -> 0x0217 }
            r1.setText(r0)     // Catch:{ Exception -> 0x0217 }
            java.util.List<net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b> r0 = r10.f19215h     // Catch:{ Exception -> 0x0134 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0134 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel$b r0 = (net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.b) r0     // Catch:{ Exception -> 0x0134 }
            long r0 = r0.f19220e     // Catch:{ Exception -> 0x0134 }
            r5 = 0
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0139
            android.widget.TextView r0 = r9.f19132f     // Catch:{ Exception -> 0x0134 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0134 }
            goto L_0x0139
        L_0x0134:
            android.widget.TextView r0 = r9.f19132f     // Catch:{ Exception -> 0x0217 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
        L_0x0139:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = r9.A     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r1 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{ Exception -> 0x0217 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0217 }
            if (r0 == 0) goto L_0x0182
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_PENDING     // Catch:{ Exception -> 0x0217 }
            int r0 = r0.getCode()     // Catch:{ Exception -> 0x0217 }
            java.lang.Integer r1 = r10.f19213f     // Catch:{ Exception -> 0x0217 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0217 }
            if (r0 != r1) goto L_0x017d
            android.widget.ImageView r10 = r9.f19129c     // Catch:{ Exception -> 0x0217 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r10 = r9.f19128b     // Catch:{ Exception -> 0x0217 }
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fd_pending_transfer     // Catch:{ Exception -> 0x0217 }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x0217 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0217 }
            android.widget.ImageView r10 = r9.f19129c     // Catch:{ Exception -> 0x0217 }
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ Exception -> 0x0217 }
            int r1 = net.one97.paytm.paymentsBank.R.drawable.pb_fd_ic_pending_tick     // Catch:{ Exception -> 0x0217 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ Exception -> 0x0217 }
            r10.setImageDrawable(r0)     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.a.b r10 = r9.w     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{ Exception -> 0x0217 }
            r10.a(r0)     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.utils.CircularProgressBarBank r10 = r9.f19130d     // Catch:{ Exception -> 0x0217 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            goto L_0x0182
        L_0x017d:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.b r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING     // Catch:{ Exception -> 0x0217 }
            r9.a((net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel.a) r10, (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b) r0)     // Catch:{ Exception -> 0x0217 }
        L_0x0182:
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0217 }
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_sld_new_fd_passbook     // Catch:{ Exception -> 0x0217 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0217 }
            android.widget.TextView r10 = r9.j     // Catch:{ Exception -> 0x0217 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = r9.A     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.STARTED     // Catch:{ Exception -> 0x0217 }
            boolean r10 = r10.equals(r0)     // Catch:{ Exception -> 0x0217 }
            if (r10 != 0) goto L_0x01a2
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = r9.A     // Catch:{ Exception -> 0x0217 }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.RUNNING     // Catch:{ Exception -> 0x0217 }
            boolean r10 = r10.equals(r0)     // Catch:{ Exception -> 0x0217 }
            if (r10 == 0) goto L_0x0217
        L_0x01a2:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = r9.A     // Catch:{  }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.STARTED     // Catch:{  }
            boolean r10 = r10.equals(r0)     // Catch:{  }
            if (r10 == 0) goto L_0x01b0
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.RUNNING     // Catch:{  }
            r9.A = r10     // Catch:{  }
        L_0x01b0:
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = r9.A     // Catch:{  }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{  }
            boolean r10 = r10.equals(r0)     // Catch:{  }
            if (r10 == 0) goto L_0x01bb
            return
        L_0x01bb:
            java.util.List<java.lang.Integer> r10 = r9.F     // Catch:{  }
            int r10 = r10.size()     // Catch:{  }
            if (r10 != 0) goto L_0x01f3
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r10 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{  }
            r9.A = r10     // Catch:{  }
            android.widget.ImageView r10 = r9.f19129c     // Catch:{  }
            r10.setVisibility(r3)     // Catch:{  }
            android.widget.TextView r10 = r9.f19128b     // Catch:{  }
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fd_pending_transfer     // Catch:{  }
            java.lang.String r0 = r9.getString(r0)     // Catch:{  }
            r10.setText(r0)     // Catch:{  }
            android.widget.ImageView r10 = r9.f19129c     // Catch:{  }
            android.content.res.Resources r0 = r9.getResources()     // Catch:{  }
            int r1 = net.one97.paytm.paymentsBank.R.drawable.pb_fd_ic_pending_tick     // Catch:{  }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{  }
            r10.setImageDrawable(r0)     // Catch:{  }
            net.one97.paytm.paymentsBank.slfd.interestprojection.a.b r10 = r9.w     // Catch:{  }
            net.one97.paytm.paymentsBank.slfd.interestprojection.c.d r0 = net.one97.paytm.paymentsBank.slfd.interestprojection.c.d.FINISHED     // Catch:{  }
            r10.a(r0)     // Catch:{  }
            net.one97.paytm.paymentsBank.utils.CircularProgressBarBank r10 = r9.f19130d     // Catch:{  }
            r10.setVisibility(r4)     // Catch:{  }
            return
        L_0x01f3:
            java.util.List<java.lang.Integer> r10 = r9.F     // Catch:{  }
            int r10 = r10.size()     // Catch:{  }
            if (r10 <= 0) goto L_0x0217
            android.os.Handler r10 = new android.os.Handler     // Catch:{  }
            r10.<init>()     // Catch:{  }
            net.one97.paytm.paymentsBank.slfd.interestprojection.-$$Lambda$FDPostTransactionActivity$aaR8EpNqVOMqdPNLZWSjKlXmNVY r0 = new net.one97.paytm.paymentsBank.slfd.interestprojection.-$$Lambda$FDPostTransactionActivity$aaR8EpNqVOMqdPNLZWSjKlXmNVY     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.util.List<java.lang.Integer> r1 = r9.F     // Catch:{  }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{  }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{  }
            int r1 = r1.intValue()     // Catch:{  }
            int r1 = r1 * 1000
            long r1 = (long) r1     // Catch:{  }
            r10.postDelayed(r0, r1)     // Catch:{  }
        L_0x0217:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.interestprojection.FDPostTransactionActivity.a(java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.f19127a.setVisibility(8);
            f.a((Activity) this, (Exception) networkCustomError, (String) null);
        } catch (Exception unused) {
        }
    }

    private void a(boolean z2) {
        if (z2) {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.l.setVisibility(0);
    }

    private void a(FDPostTransactionModel.a aVar) {
        this.f19127a.setVisibility(8);
        this.f19131e.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19208a))}));
        this.f19128b.setText(getString(R.string.pb_fd_pending_transfer));
        this.f19129c.setVisibility(0);
        this.f19129c.setImageDrawable(getResources().getDrawable(R.drawable.pb_fd_ic_pending_tick));
        this.f19130d.setVisibility(8);
        this.w.a(d.FINISHED);
        this.f19132f.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("hh:mm a, dd MMM yyyy", "hh:mm a, dd MMM yyyy", aVar.f19215h.get(0).f19220e));
        try {
            if (aVar.f19215h.get(0).f19220e == 0) {
                this.f19132f.setVisibility(8);
            }
        } catch (Exception unused) {
            this.f19132f.setVisibility(8);
        }
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.t.setText(R.string.pb_sld_new_fd_passbook);
        this.j.setVisibility(8);
    }

    private void b(FDPostTransactionModel.a aVar) {
        this.f19127a.setVisibility(8);
        this.f19131e.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19212e))}));
        if (aVar.f19211d == 0.0d) {
            this.f19128b.setText(getString(R.string.pb_fd_transferred_successfully));
        } else {
            this.f19128b.setText(getString(R.string.pb_fd_transferred_successfully_with_interest));
        }
        this.f19129c.setVisibility(0);
        this.f19129c.setImageDrawable(getResources().getDrawable(R.drawable.pb_fd_success));
        this.f19130d.setVisibility(8);
        this.f19132f.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("hh:mm a, dd MMM yyyy", "hh:mm a, dd MMM yyyy", aVar.f19215h.get(0).f19220e));
        try {
            if (aVar.f19215h.get(0).f19220e == 0) {
                this.f19132f.setVisibility(8);
            }
        } catch (Exception unused) {
            this.f19132f.setVisibility(8);
        }
        this.n.setVisibility(0);
        this.n.setText(getString(R.string.pb_fd_requested_amount_interest_earned, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19209b)), net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19211d))}));
        if (aVar.f19210c > 0.0d) {
            this.o.setVisibility(0);
            this.p.setText(getString(R.string.pb_fd_tax_has_been_deducted, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19210c))}));
        }
        this.t.setText(R.string.pb_fd_updated_deposit_amount);
    }

    private void c(FDPostTransactionModel.a aVar) {
        this.f19127a.setVisibility(8);
        this.f19131e.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19212e))}));
        this.f19128b.setText(getString(R.string.pb_fd_transferred_partially_with_interest));
        this.f19129c.setVisibility(0);
        this.f19129c.setImageDrawable(getResources().getDrawable(R.drawable.pb_fd_success));
        this.f19130d.setVisibility(8);
        this.f19132f.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("hh:mm a, dd MMM yyyy", "hh:mm a, dd MMM yyyy", aVar.f19215h.get(0).f19220e));
        try {
            if (aVar.f19215h.get(0).f19220e == 0) {
                this.f19132f.setVisibility(8);
            }
        } catch (Exception unused) {
            this.f19132f.setVisibility(8);
        }
        this.n.setVisibility(0);
        this.n.setText(getString(R.string.pb_fd_redeemed_amount_interest_earned, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19209b)), net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19211d))}));
        if (aVar.f19210c > 0.0d) {
            this.o.setVisibility(0);
            this.p.setText(getString(R.string.pb_fd_tax_has_been_deducted, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19210c))}));
        }
        this.t.setText(R.string.pb_fd_updated_deposit_amount);
    }

    private void d(FDPostTransactionModel.a aVar) {
        this.f19127a.setVisibility(8);
        this.f19131e.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(aVar.f19208a))}));
        this.f19128b.setText(getString(R.string.pb_fd_transfer_failed));
        this.f19129c.setVisibility(0);
        this.f19129c.setImageDrawable(getResources().getDrawable(R.drawable.pb_fd_ic_failure_tick));
        this.f19130d.setVisibility(8);
        this.f19135i.setVisibility(8);
        this.f19132f.setText(net.one97.paytm.paymentsBank.slfd.b.a.a.a("hh:mm a, dd MMM yyyy", "hh:mm a, dd MMM yyyy", aVar.f19215h.get(0).f19220e));
        try {
            if (aVar.f19215h.get(0).f19220e == 0) {
                this.f19132f.setVisibility(8);
            }
        } catch (Exception unused) {
            this.f19132f.setVisibility(8);
        }
        this.q.setVisibility(0);
        this.q.setText(aVar.f19214g);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.f19134h.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        } else if (view.getId() == R.id.ll_24_7_container) {
            o.a().checkDeepLinking(this, "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=4&templateId=6");
            finish();
        } else if (view.getId() == R.id.tv_view_details) {
            if (this.z) {
                this.v.setVisibility(8);
                this.f19134h.setText(getString(R.string.view_details));
                this.f19134h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.pb_rectangle), (Drawable) null);
                this.z = false;
                return;
            }
            this.v.setVisibility(0);
            this.f19134h.setText(getString(R.string.pb_fd_hide_details));
            this.f19134h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.pb_fd_up_blue_arrow), (Drawable) null);
            this.z = true;
        } else if (view.getId() == R.id.rl_share_wrapper) {
            d();
        } else if (view.getId() == R.id.ll_update_deposit_container) {
            if (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING.equals(this.C) || net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_PENDING.equals(this.C)) {
                b();
            } else if (this.x > 0.0d) {
                Intent intent = new Intent(this, SlfdLandingPageActivity.class);
                intent.putExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            } else {
                b();
            }
        } else if (view.getId() == R.id.rl_money_transfer_container) {
            Intent intent2 = new Intent(this, o.a().getMoneyTransferActivityV3Class());
            intent2.putExtra(UpiConstants.FROM, 100);
            startActivity(intent2);
            finish();
        }
    }

    private void b() {
        if (com.paytm.utility.b.c((Context) this)) {
            com.paytm.utility.b.k(this, getString(R.string.pb_please_wait));
            new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this).a((g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    FDPostTransactionActivity.this.a((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    FDPostTransactionActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, "A", "");
            return;
        }
        c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRPaytmDataModel iJRPaytmDataModel) {
        com.paytm.utility.b.p();
        if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
            SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
            if (slfdTransactionModel != null && ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(slfdTransactionModel.getStatus())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), slfdTransactionModel.getMessage());
            } else if (slfdTransactionModel != null && slfdTransactionModel.getTransactionList() != null && slfdTransactionModel.getTransactionList().size() > 0) {
                if (net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING.equals(this.C) || net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_PENDING.equals(this.C)) {
                    Intent intent = new Intent(this, FDPassbookActivity.class);
                    intent.putExtra("extra_slfd_transaction_model", slfdTransactionModel);
                    intent.setFlags(67108864);
                    startActivity(intent);
                    finish();
                } else if (j.b()) {
                    Intent intent2 = new Intent(this, SlfdLandingPageActivity.class);
                    intent2.putExtra("SLFD_IMPULSE_DO_ALLOW_BOOKING", false);
                    intent2.addFlags(67108864);
                    startActivity(intent2);
                    finish();
                } else {
                    Intent intent3 = new Intent(this, FixedDepositHistoryPassbookActivity.class);
                    intent3.putExtra("extra_slfd_transaction_model", slfdTransactionModel);
                    intent3.addFlags(67108864);
                    startActivity(intent3);
                    finish();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.p();
        f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    private void c() {
        if (!isFinishing()) {
            k.a().show(getSupportFragmentManager().a(), "dialog");
        }
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.pb_post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", "");
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), a(findViewById(R.id.nsv_main_content)), getString(R.string.pb_title), (String) null)));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.pb_post_payment_share_title));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.pb_no_app_found), 1).show();
                }
            } catch (Exception unused) {
            }
        } else {
            s.b((Activity) this);
            Toast.makeText(this, getString(R.string.pb_permission_not_granted), 0).show();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56 && s.a(iArr)) {
            d();
        }
    }

    private static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void a(FDPostTransactionModel.a aVar, net.one97.paytm.paymentsBank.slfd.interestprojection.c.b bVar) {
        if (this.u) {
            a(bVar, aVar);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.f c2 = net.one97.paytm.paymentsBank.b.a.c((Context) this, "", (g.b<IJRPaytmDataModel>) new g.b(bVar, aVar) {
            private final /* synthetic */ net.one97.paytm.paymentsBank.slfd.interestprojection.c.b f$1;
            private final /* synthetic */ FDPostTransactionModel.a f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResponse(Object obj) {
                FDPostTransactionActivity.this.a(this.f$1, this.f$2, (IJRPaytmDataModel) obj);
            }
        }, (g.a) new g.a(bVar, aVar) {
            private final /* synthetic */ net.one97.paytm.paymentsBank.slfd.interestprojection.c.b f$1;
            private final /* synthetic */ FDPostTransactionModel.a f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                FDPostTransactionActivity.this.a(this.f$1, this.f$2, i2, iJRPaytmDataModel, networkCustomError);
            }
        }, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        c2.f16270b = "API_REQUEST_TAG_BANK_SUMMARY";
        getApplicationContext();
        new c();
        c.a(c2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b bVar, FDPostTransactionModel.a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        PBCJRAccountSummary pBCJRAccountSummary;
        if ((iJRPaytmDataModel instanceof PBCJRAccountSummary) && (pBCJRAccountSummary = (PBCJRAccountSummary) iJRPaytmDataModel) != null && pBCJRAccountSummary.getStatus() != null && pBCJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
            if (!this.u) {
                this.f19135i.setVisibility(0);
                this.f19135i.setText(getString(R.string.pb_fd_updated_account_balance, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(pBCJRAccountSummary.getEffectiveBalance()))}));
            }
            if (!TextUtils.isEmpty(this.D)) {
                String str = this.D;
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                if (str.equalsIgnoreCase(net.one97.paytm.paymentsBank.createfd.utils.b.n)) {
                    this.k.setVisibility(8);
                    this.E.setVisibility(8);
                    a(true);
                    this.j.setVisibility(0);
                    this.j.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(pBCJRAccountSummary.getSlfdBalance()))}));
                    this.x = pBCJRAccountSummary.getSlfdBalance();
                    a(bVar, aVar);
                    this.C = bVar;
                }
            }
            this.E.setVisibility(0);
            this.k.setVisibility(0);
            a(false);
            this.j.setVisibility(0);
            this.j.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(pBCJRAccountSummary.getSlfdBalance()))}));
            this.x = pBCJRAccountSummary.getSlfdBalance();
            a(bVar, aVar);
            this.C = bVar;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b bVar, FDPostTransactionModel.a aVar, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(bVar, aVar);
    }

    private void a(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b bVar, FDPostTransactionModel.a aVar) {
        if (bVar.equals(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_PENDING)) {
            a(aVar);
        } else if (bVar.equals(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS)) {
            b(aVar);
        } else if (bVar.equals(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_SUCCESS_FAILED)) {
            c(aVar);
        } else if (bVar.equals(net.one97.paytm.paymentsBank.slfd.interestprojection.c.b.STATUS_FAILED)) {
            d(aVar);
        }
    }
}
