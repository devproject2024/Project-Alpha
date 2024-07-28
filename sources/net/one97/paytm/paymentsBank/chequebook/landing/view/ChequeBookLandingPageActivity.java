package net.one97.paytm.paymentsBank.chequebook.landing.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.t;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.j;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.depositedCheque.view.CBDepositedChequesActivity;
import net.one97.paytm.paymentsBank.chequebook.landing.a.a;
import net.one97.paytm.paymentsBank.chequebook.leaflist.view.CBListDetailsViewActivity;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivity;
import net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV3;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.view.CBTLandingView;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.i;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;

public final class ChequeBookLandingPageActivity extends ChequeBookBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    final int f17550a = 123;

    /* renamed from: b  reason: collision with root package name */
    public a.C0270a f17551b;

    /* renamed from: c  reason: collision with root package name */
    boolean f17552c;

    /* renamed from: d  reason: collision with root package name */
    boolean f17553d;

    /* renamed from: e  reason: collision with root package name */
    private a f17554e;

    /* renamed from: f  reason: collision with root package name */
    private int f17555f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f17556g = "";

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f17557h;

    /* renamed from: i  reason: collision with root package name */
    private int f17558i;
    private String j;
    private boolean k;
    private int l;
    private boolean m;
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
    }

    public final void d() {
        if (this.f17555f != -1) {
            a aVar = this.f17554e;
            if (aVar == null) {
                k.a("adapter");
            }
            aVar.notifyItemChanged(this.f17555f, 2);
        }
    }

    public final void a(int i2, String str, View view) {
        k.c(str, "cbNumber");
        k.c(view, "v");
        this.f17555f = i2;
        this.f17556g = str;
        t tVar = new t(view.getContext(), view, 5, 16843520);
        tVar.a((t.b) new f(this, str));
        tVar.a(R.menu.stop_payment_menu);
        tVar.c();
    }

    public static final class f implements t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17564a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17565b;

        f(ChequeBookLandingPageActivity chequeBookLandingPageActivity, String str) {
            this.f17564a = chequeBookLandingPageActivity;
            this.f17565b = str;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            k.c(menuItem, "item");
            if (menuItem.getItemId() == R.id.stop_payment_tv) {
                BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
                ChequeBookLandingPageActivity chequeBookLandingPageActivity = this.f17564a;
                String string = chequeBookLandingPageActivity.getString(R.string.cb_stop_pay_passcode);
                k.a((Object) string, "getString(R.string.cb_stop_pay_passcode)");
                String string2 = this.f17564a.getString(R.string.cb_stop_pay_desc, new Object[]{this.f17565b});
                k.a((Object) string2, "getString(R.string.cb_stop_pay_desc,chqNumber)");
                BankPasscodeActivity.a.a((Activity) chequeBookLandingPageActivity, string, string2, this.f17564a.f17550a);
            }
            return true;
        }
    }

    public final void a(String str, boolean z) {
        k.c(str, "cbNumber");
        CBListDetailsViewActivity.a aVar = CBListDetailsViewActivity.f17629c;
        Activity activity = this;
        k.c(activity, "activity");
        k.c(str, "cbNumber");
        Intent intent = new Intent(activity, CBListDetailsViewActivity.class);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.k(), str);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.B(), z);
        activity.startActivity(intent);
    }

    public final void b(int i2) {
        this.f17552c = false;
        a aVar = this.f17554e;
        if (aVar == null) {
            k.a("adapter");
        }
        aVar.notifyItemRemoved(i2);
    }

    public final void c(int i2) {
        a aVar = this.f17554e;
        if (aVar == null) {
            k.a("adapter");
        }
        aVar.notifyItemInserted(i2);
    }

    public final void b(boolean z) {
        this.f17553d = z;
    }

    private a.C0270a e() {
        a.C0270a aVar = this.f17551b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int a() {
        return R.layout.pb_landing_page_activity;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.j = intent != null ? intent.getStringExtra("CHEQUEBOOK_SIGNATURE_STATUS") : null;
        this.k = getIntent().getBooleanExtra("showDepositedView", false);
        this.l = getIntent().getIntExtra("pendingOrders", 0);
        this.m = getIntent().getBooleanExtra("cb_list_flow", false);
        net.one97.paytm.paymentsBank.chequebook.utils.d dVar = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        a.C0270a aVar = new net.one97.paytm.paymentsBank.chequebook.landing.b.a(net.one97.paytm.paymentsBank.chequebook.utils.d.a(applicationContext), this, baseContext);
        k.c(aVar, "<set-?>");
        this.f17551b = aVar;
        View findViewById = findViewById(R.id.rv_pb_cb);
        k.a((Object) findViewById, "findViewById<RecyclerView>(R.id.rv_pb_cb)");
        this.f17557h = (RecyclerView) findViewById;
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = this.f17557h;
        if (recyclerView == null) {
            k.a("rvListChequeBook");
        }
        recyclerView.addItemDecoration(new j(context));
        RecyclerView recyclerView2 = this.f17557h;
        if (recyclerView2 == null) {
            k.a("rvListChequeBook");
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.f17557h;
        if (recyclerView3 == null) {
            k.a("rvListChequeBook");
        }
        recyclerView3.addOnScrollListener(new a(this, linearLayoutManager));
        this.f17554e = new a(e());
        e().a();
        a aVar2 = this.f17554e;
        if (aVar2 == null) {
            k.a("adapter");
        }
        aVar2.notifyDataSetChanged();
        ((RelativeLayout) a(R.id.lyt_upload_signature)).setOnClickListener(new e(this));
        ((RelativeLayout) a(R.id.lyt_view_deposited_cheque)).setOnClickListener(new b(this));
        ((RelativeLayout) a(R.id.lyt_request_cb)).setOnClickListener(new c(this));
        ((RelativeLayout) a(R.id.cb_track_your_order_lyt)).setOnClickListener(new d(this));
        if (this.k) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.lyt_view_deposited_cheque);
            k.a((Object) relativeLayout, "lyt_view_deposited_cheque");
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout);
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.lyt_view_deposited_cheque);
            k.a((Object) relativeLayout2, "lyt_view_deposited_cheque");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout2);
        }
        if (this.l > 0) {
            RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.lyt_request_cb);
            k.a((Object) relativeLayout3, "lyt_request_cb");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout3);
            RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.cb_track_your_order_lyt);
            k.a((Object) relativeLayout4, "cb_track_your_order_lyt");
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout4);
        } else {
            RelativeLayout relativeLayout5 = (RelativeLayout) a(R.id.lyt_request_cb);
            k.a((Object) relativeLayout5, "lyt_request_cb");
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout5);
            RelativeLayout relativeLayout6 = (RelativeLayout) a(R.id.cb_track_your_order_lyt);
            k.a((Object) relativeLayout6, "cb_track_your_order_lyt");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout6);
        }
        RelativeLayout relativeLayout7 = (RelativeLayout) a(R.id.lyt_upload_signature);
        k.a((Object) relativeLayout7, "lyt_upload_signature");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout7);
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17563a;

        e(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
            this.f17563a = chequeBookLandingPageActivity;
        }

        public final void onClick(View view) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            ChequeBookLandingPageActivity chequeBookLandingPageActivity = this.f17563a;
            String string = chequeBookLandingPageActivity.getString(R.string.pb_cb_enter_passcode_view_sign);
            k.a((Object) string, "getString(R.string.pb_cb_enter_passcode_view_sign)");
            BankPasscodeActivity.a.a(chequeBookLandingPageActivity, string);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17560a;

        b(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
            this.f17560a = chequeBookLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f17560a.startActivity(new Intent(this.f17560a, CBDepositedChequesActivity.class));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17561a;

        c(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
            this.f17561a = chequeBookLandingPageActivity;
        }

        public final void onClick(View view) {
            ChequeBookLandingPageActivity.c(this.f17561a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17562a;

        d(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
            this.f17562a = chequeBookLandingPageActivity;
        }

        public final void onClick(View view) {
            this.f17562a.startActivity(new Intent(this.f17562a, CBTLandingView.class));
        }
    }

    public final void c() {
        RecyclerView recyclerView = this.f17557h;
        if (recyclerView == null) {
            k.a("rvListChequeBook");
        }
        a aVar = this.f17554e;
        if (aVar == null) {
            k.a("adapter");
        }
        recyclerView.setAdapter(aVar);
    }

    public final void a(int i2, int i3) {
        if (i2 != -1 && i3 != 0) {
            a aVar = this.f17554e;
            if (aVar == null) {
                k.a("adapter");
            }
            aVar.notifyItemRangeInserted(i2, i3);
        }
    }

    public final void a(boolean z) {
        if (z) {
            FrameLayout frameLayout = (FrameLayout) a(R.id.fl_progress_bar);
            k.a((Object) frameLayout, "fl_progress_bar");
            frameLayout.setVisibility(0);
            ProgressBar progressBar = (ProgressBar) a(R.id.pb_cb_pb);
            k.a((Object) progressBar, "pb_cb_pb");
            progressBar.setVisibility(0);
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) a(R.id.fl_progress_bar);
        k.a((Object) frameLayout2, "fl_progress_bar");
        frameLayout2.setVisibility(8);
        ProgressBar progressBar2 = (ProgressBar) a(R.id.pb_cb_pb);
        k.a((Object) progressBar2, "pb_cb_pb");
        progressBar2.setVisibility(8);
    }

    public final void b() {
        Intent intent = new Intent(this, SignatureLandingActivity.class);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.c(), false);
        startActivity(intent);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121) {
            if (i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                k.a((Object) intent.getStringExtra("passcode"), "txnToken");
                startActivity(new Intent(this, SignatureReUploadActivityV3.class));
            }
        } else if (i2 == this.f17550a && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            String stringExtra = intent.getStringExtra("passcode");
            if (!TextUtils.isEmpty(this.f17556g)) {
                a.C0270a e2 = e();
                String str = this.f17556g;
                k.a((Object) stringExtra, "txnToken");
                e2.a(str, stringExtra);
            }
        }
    }

    public final class a extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChequeBookLandingPageActivity f17559a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChequeBookLandingPageActivity chequeBookLandingPageActivity, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            k.c(linearLayoutManager, "layoutManager");
            this.f17559a = chequeBookLandingPageActivity;
        }

        public final boolean a() {
            return this.f17559a.f17552c;
        }

        public final void b() {
            ChequeBookLandingPageActivity.a(this.f17559a);
        }

        public final boolean c() {
            return this.f17559a.f17553d;
        }
    }

    public static final /* synthetic */ void a(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
        chequeBookLandingPageActivity.f17552c = true;
        chequeBookLandingPageActivity.f17558i++;
        chequeBookLandingPageActivity.e().d();
        chequeBookLandingPageActivity.e().a(String.valueOf(chequeBookLandingPageActivity.f17558i));
    }

    public static final /* synthetic */ void c(ChequeBookLandingPageActivity chequeBookLandingPageActivity) {
        Intent intent = new Intent(chequeBookLandingPageActivity, RequestCBActivity.class);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.c(), false);
        chequeBookLandingPageActivity.startActivity(intent);
        chequeBookLandingPageActivity.finish();
    }
}
