package net.one97.paytm.paymentsBank.chequebook.leaflist.view;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.leaflist.a;
import net.one97.paytm.paymentsBank.chequebook.utils.c;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;

public final class CBListDetailsViewActivity extends PaytmActivity implements a.e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f17628a = {y.a((v) new w(y.b(CBListDetailsViewActivity.class), "cqListAdapter", "getCqListAdapter()Lnet/one97/paytm/paymentsBank/chequebook/leaflist/CBClearedOtherChqDetailsAdapter;"))};

    /* renamed from: c  reason: collision with root package name */
    public static final a f17629c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    final int f17630b = 123;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.g f17631d = kotlin.h.a(new c(this));

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.chequebook.leaflist.d f17632e;

    /* renamed from: f  reason: collision with root package name */
    private String f17633f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f17634g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f17635h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f17636i = -1;
    private final z<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> j = new e(this);
    private final z<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> k = new b(this);
    private final z<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> l = new h(this);
    private HashMap m;

    /* access modifiers changed from: private */
    public final net.one97.paytm.paymentsBank.chequebook.leaflist.a a() {
        return (net.one97.paytm.paymentsBank.chequebook.leaflist.a) this.f17631d.getValue();
    }

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17637a;

        b(CBListDetailsViewActivity cBListDetailsViewActivity) {
            this.f17637a = cBListDetailsViewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError.ErrorType errorType;
            ConstraintLayout constraintLayout;
            TextView textView;
            net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
            if (bVar != null) {
                int i2 = a.f17645b[bVar.f17486a.ordinal()];
                if (i2 == 1) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f17637a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout2, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.a(constraintLayout2);
                    NetworkCustomError networkCustomError = bVar.f17488c;
                    if (!(networkCustomError == null || (errorType = networkCustomError.getErrorType()) == null || !errorType.equals(NetworkCustomError.ErrorType.NoConnectionError) || (constraintLayout = (ConstraintLayout) this.f17637a.a(R.id.cl_error_lyt)) == null || (textView = (TextView) constraintLayout.findViewById(R.id.tv_message)) == null)) {
                        textView.setText(this.f17637a.getString(R.string.no_internet));
                    }
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17637a.a(R.id.wallet_loader));
                    RecyclerView recyclerView = (RecyclerView) this.f17637a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView);
                    j.a((Activity) this.f17637a, (Exception) bVar.f17488c, this.f17637a.getClass().getName(), (Bundle) null);
                } else if (i2 == 2) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f17637a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout3, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(constraintLayout3);
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f17637a.a(R.id.wallet_loader));
                    RecyclerView recyclerView2 = (RecyclerView) this.f17637a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView2, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView2);
                } else if (i2 == 3) {
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f17637a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout4, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(constraintLayout4);
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17637a.a(R.id.wallet_loader));
                    RecyclerView recyclerView3 = (RecyclerView) this.f17637a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView3, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.a(recyclerView3);
                    net.one97.paytm.paymentsBank.chequebook.leaflist.a d2 = this.f17637a.a();
                    ResultType resulttype = bVar.f17487b;
                    if (resulttype == null) {
                        k.a();
                    }
                    d2.a((List) resulttype);
                } else {
                    throw new m();
                }
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17639a;

        e(CBListDetailsViewActivity cBListDetailsViewActivity) {
            this.f17639a = cBListDetailsViewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError.ErrorType errorType;
            ConstraintLayout constraintLayout;
            TextView textView;
            net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
            if (bVar != null) {
                int i2 = a.f17644a[bVar.f17486a.ordinal()];
                if (i2 == 1) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f17639a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout2, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.a(constraintLayout2);
                    NetworkCustomError networkCustomError = bVar.f17488c;
                    if (!(networkCustomError == null || (errorType = networkCustomError.getErrorType()) == null || !errorType.equals(NetworkCustomError.ErrorType.NoConnectionError) || (constraintLayout = (ConstraintLayout) this.f17639a.a(R.id.cl_error_lyt)) == null || (textView = (TextView) constraintLayout.findViewById(R.id.tv_message)) == null)) {
                        textView.setText(this.f17639a.getString(R.string.no_internet));
                    }
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17639a.a(R.id.wallet_loader));
                    RecyclerView recyclerView = (RecyclerView) this.f17639a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView);
                    j.a((Activity) this.f17639a, (Exception) bVar.f17488c, this.f17639a.getClass().getName(), (Bundle) null);
                } else if (i2 == 2) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f17639a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout3, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(constraintLayout3);
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f17639a.a(R.id.wallet_loader));
                    RecyclerView recyclerView2 = (RecyclerView) this.f17639a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView2, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView2);
                } else if (i2 == 3) {
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) this.f17639a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout4, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(constraintLayout4);
                    net.one97.paytm.paymentsBank.h.a a2 = o.a();
                    k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                    if (net.one97.paytm.paymentsBank.chequebook.utils.h.a(a2.getApplicationContext()).f17978a != null) {
                        net.one97.paytm.paymentsBank.h.a a3 = o.a();
                        k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
                        List<String> list = net.one97.paytm.paymentsBank.chequebook.utils.h.a(a3.getApplicationContext()).f17978a;
                        k.a((Object) list, "PPBCBCacheManager.getCBC…onContext).clearedChqList");
                        if (!list.isEmpty()) {
                            net.one97.paytm.paymentsBank.chequebook.leaflist.d a4 = CBListDetailsViewActivity.a(this.f17639a);
                            k.c("inward", "chqType");
                            a4.f17610a.setValue("inward");
                            return;
                        }
                    }
                    ConstraintLayout constraintLayout5 = (ConstraintLayout) this.f17639a.a(R.id.cl_error_lyt);
                    k.a((Object) constraintLayout5, "cl_error_lyt");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.b(constraintLayout5);
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17639a.a(R.id.wallet_loader));
                    RecyclerView recyclerView3 = (RecyclerView) this.f17639a.a(R.id.rv_cheque_book);
                    k.a((Object) recyclerView3, "rv_cheque_book");
                    net.one97.paytm.paymentsBank.chequebook.utils.b.a(recyclerView3);
                    net.one97.paytm.paymentsBank.chequebook.leaflist.a d2 = this.f17639a.a();
                    ResultType resulttype = bVar.f17487b;
                    if (resulttype == null) {
                        k.a();
                    }
                    d2.a((List) resulttype);
                } else {
                    throw new m();
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17643a;

        h(CBListDetailsViewActivity cBListDetailsViewActivity) {
            this.f17643a = cBListDetailsViewActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.paymentsBank.chequebook.c cVar;
            net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
            String str = null;
            if (bVar != null) {
                cVar = bVar.f17486a;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int i2 = a.f17646c[cVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17643a.a(R.id.wallet_loader));
                    CbStopPaymentResponse cbStopPaymentResponse = (CbStopPaymentResponse) bVar.f17487b;
                    if (!TextUtils.isEmpty(cbStopPaymentResponse != null ? cbStopPaymentResponse.getMessage() : null)) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) this.f17643a.a(R.id.parent_lyt_list_chq);
                        CbStopPaymentResponse cbStopPaymentResponse2 = (CbStopPaymentResponse) bVar.f17487b;
                        if (cbStopPaymentResponse2 != null) {
                            str = cbStopPaymentResponse2.getMessage();
                        }
                        if (str == null) {
                            k.a();
                        }
                        Snackbar.a((View) constraintLayout, (CharSequence) str, -1).c();
                    }
                    if (this.f17643a.f17635h != -1) {
                        net.one97.paytm.paymentsBank.chequebook.leaflist.a d2 = this.f17643a.a();
                        int e2 = this.f17643a.f17635h;
                        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                        d2.notifyItemChanged(e2, net.one97.paytm.paymentsBank.chequebook.utils.e.J());
                    }
                } else if (i2 == 2) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17643a.a(R.id.wallet_loader));
                    Snackbar.a((View) (ConstraintLayout) this.f17643a.a(R.id.parent_lyt_list_chq), (CharSequence) this.f17643a.getString(R.string.some_went_wrong), -1).c();
                } else if (i2 == 3) {
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f17643a.a(R.id.wallet_loader));
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.leaflist.d a(CBListDetailsViewActivity cBListDetailsViewActivity) {
        net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar = cBListDetailsViewActivity.f17632e;
        if (dVar == null) {
            k.a("viewModel");
        }
        return dVar;
    }

    public static final /* synthetic */ String b(CBListDetailsViewActivity cBListDetailsViewActivity) {
        String str = cBListDetailsViewActivity.f17633f;
        if (str == null) {
            k.a("cbNumber");
        }
        return str;
    }

    public final void a(int i2, String str, View view, int i3) {
        k.c(str, "chqNumber");
        k.c(view, "itemView");
        this.f17636i = i2;
        this.f17635h = i3;
        t tVar = new t(view.getContext(), view, 5, 16843520);
        tVar.a((t.b) new g(this, str));
        tVar.a(R.menu.stop_payment_menu);
        tVar.c();
    }

    public static final class g implements t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17642b;

        g(CBListDetailsViewActivity cBListDetailsViewActivity, String str) {
            this.f17641a = cBListDetailsViewActivity;
            this.f17642b = str;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            k.c(menuItem, "item");
            if (menuItem.getItemId() == R.id.stop_payment_tv) {
                BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
                CBListDetailsViewActivity cBListDetailsViewActivity = this.f17641a;
                String string = cBListDetailsViewActivity.getString(R.string.cb_leaf_stop_payment, new Object[]{this.f17642b});
                k.a((Object) string, "getString(R.string.cb_le…stop_payment , chqNumber)");
                String string2 = this.f17641a.getString(R.string.cb_stop_pay_desc_leaf);
                k.a((Object) string2, "getString(R.string.cb_stop_pay_desc_leaf)");
                BankPasscodeActivity.a.a((Activity) cBListDetailsViewActivity, string, string2, this.f17641a.f17630b);
            }
            return true;
        }
    }

    static final class c extends l implements kotlin.g.a.a<net.one97.paytm.paymentsBank.chequebook.leaflist.a> {
        final /* synthetic */ CBListDetailsViewActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CBListDetailsViewActivity cBListDetailsViewActivity) {
            super(0);
            this.this$0 = cBListDetailsViewActivity;
        }

        public final net.one97.paytm.paymentsBank.chequebook.leaflist.a invoke() {
            return new net.one97.paytm.paymentsBank.chequebook.leaflist.a(this.this$0);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_cb_list_details_view);
        Intent intent = getIntent();
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        String stringExtra = intent.getStringExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.k());
        k.a((Object) stringExtra, "intent.getStringExtra(CB_NUMBER)");
        this.f17633f = stringExtra;
        Intent intent2 = getIntent();
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        this.f17634g = intent2.getBooleanExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.B(), false);
        Class cls = net.one97.paytm.paymentsBank.chequebook.leaflist.d.class;
        k.c(this, "receiver$0");
        k.c(cls, "viewModelClass");
        c.a aVar = net.one97.paytm.paymentsBank.chequebook.utils.c.f17946a;
        Application application = getApplication();
        k.a((Object) application, "application");
        ai a2 = am.a((FragmentActivity) this, (al.b) c.a.a(application)).a(cls);
        k.a((Object) a2, "ViewModelProviders.of(th…ion)).get(viewModelClass)");
        this.f17632e = (net.one97.paytm.paymentsBank.chequebook.leaflist.d) a2;
        net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar = this.f17632e;
        if (dVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        dVar.f17611b.observe(qVar, this.j);
        net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar2 = this.f17632e;
        if (dVar2 == null) {
            k.a("viewModel");
        }
        dVar2.f17612c.observe(qVar, this.k);
        net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar3 = this.f17632e;
        if (dVar3 == null) {
            k.a("viewModel");
        }
        dVar3.f17615f.observe(qVar, this.l);
        net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar4 = this.f17632e;
        if (dVar4 == null) {
            k.a("viewModel");
        }
        String str = this.f17633f;
        if (str == null) {
            k.a("cbNumber");
        }
        dVar4.a(str, this.f17634g);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_error_lyt);
        k.a((Object) constraintLayout, "cl_error_lyt");
        ((TextView) constraintLayout.findViewById(R.id.tv_retry)).setOnClickListener(new f(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_cheque_book);
        recyclerView.setAdapter(a());
        k.a((Object) recyclerView, "this");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ((ImageView) a(R.id.btn_back)).setOnClickListener(new d(this));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17638a;

        d(CBListDetailsViewActivity cBListDetailsViewActivity) {
            this.f17638a = cBListDetailsViewActivity;
        }

        public final void onClick(View view) {
            this.f17638a.onBackPressed();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBListDetailsViewActivity f17640a;

        f(CBListDetailsViewActivity cBListDetailsViewActivity) {
            this.f17640a = cBListDetailsViewActivity;
        }

        public final void onClick(View view) {
            CBListDetailsViewActivity.a(this.f17640a).a(CBListDetailsViewActivity.b(this.f17640a), this.f17640a.f17634g);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f17630b && i3 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("passcode") : null;
            if (!TextUtils.isEmpty(stringExtra) && this.f17636i != -1) {
                net.one97.paytm.paymentsBank.chequebook.leaflist.d dVar = this.f17632e;
                if (dVar == null) {
                    k.a("viewModel");
                }
                if (stringExtra == null) {
                    k.a();
                }
                int i4 = this.f17636i;
                k.c(stringExtra, StringSet.token);
                dVar.f17614e = stringExtra;
                dVar.f17613d.setValue(Integer.valueOf(i4));
            }
        }
    }
}
