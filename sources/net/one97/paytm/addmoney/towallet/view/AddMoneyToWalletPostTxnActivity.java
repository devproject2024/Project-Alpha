package net.one97.paytm.addmoney.towallet.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class AddMoneyToWalletPostTxnActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.addmoney.towallet.c.c f48856a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.addmoney.a.a f48857b;

    /* renamed from: c  reason: collision with root package name */
    public AddMoneyToWalletPostTxnDetailFragment f48858c;

    /* renamed from: d  reason: collision with root package name */
    boolean f48859d;

    /* renamed from: e  reason: collision with root package name */
    boolean f48860e;

    /* renamed from: f  reason: collision with root package name */
    SFWidget f48861f;

    /* renamed from: g  reason: collision with root package name */
    String f48862g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f48863h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f48864i;
    private z<Integer> j = new b(this);
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48866a;

        b(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48866a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            int i2 = R.id.backArrowImv;
            if (num != null && num.intValue() == i2) {
                this.f48866a.onBackPressed();
                return;
            }
            int i3 = R.id.rl_view_passbook;
            if (num != null && num.intValue() == i3) {
                AddMoneyToWalletPostTxnActivity.b(this.f48866a);
                return;
            }
            int i4 = R.id.rl_add_wallet;
            if (num != null && num.intValue() == i4) {
                net.one97.paytm.helper.a.f50546a.a().a((Context) this.f48866a, "paytmmp://cash_wallet?featuretype=scanner", (Bundle) null);
                return;
            }
            int i5 = R.id.rl_help;
            if (num != null && num.intValue() == i5) {
                this.f48866a.d();
                return;
            }
            int i6 = R.id.shareImv;
            if (num != null && num.intValue() == i6) {
                AddMoneyToWalletPostTxnActivity.d(this.f48866a);
                return;
            }
            int i7 = R.id.rl_sendmoney;
            if (num != null && num.intValue() == i7) {
                AddMoneyToWalletPostTxnActivity.e(this.f48866a);
            } else {
                Toast.makeText(this.f48866a, "Clicked", 0).show();
            }
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48872a;

        g(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48872a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "isCC");
            if (!bool.booleanValue()) {
                return;
            }
            if (this.f48872a.a().f48844d.getValue() == net.one97.paytm.addmoney.towallet.c.d.SUCCESS_DETAIL || this.f48872a.a().f48844d.getValue() == net.one97.paytm.addmoney.towallet.c.d.SUCCESS_INITIAL) {
                RelativeLayout relativeLayout = this.f48872a.b().n;
                k.a((Object) relativeLayout, "binder.rlSendmoney");
                relativeLayout.setVisibility(0);
            }
        }
    }

    public final net.one97.paytm.addmoney.towallet.c.c a() {
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        return cVar;
    }

    public final net.one97.paytm.addmoney.a.a b() {
        net.one97.paytm.addmoney.a.a aVar = this.f48857b;
        if (aVar == null) {
            k.a("binder");
        }
        return aVar;
    }

    public final AddMoneyToWalletPostTxnDetailFragment c() {
        AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment = this.f48858c;
        if (addMoneyToWalletPostTxnDetailFragment == null) {
            k.a("postTxnDetailFragment");
        }
        return addMoneyToWalletPostTxnDetailFragment;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Activity activity = this;
        ViewDataBinding a2 = androidx.databinding.f.a(activity, R.layout.activity_add_money_post_transaction);
        k.a((Object) a2, "DataBindingUtil.setConte…d_money_post_transaction)");
        this.f48857b = (net.one97.paytm.addmoney.a.a) a2;
        ai a3 = am.a((FragmentActivity) this).a(net.one97.paytm.addmoney.towallet.c.c.class);
        k.a((Object) a3, "ViewModelProviders.of(th…TxnViewModel::class.java)");
        this.f48856a = (net.one97.paytm.addmoney.towallet.c.c) a3;
        Intent intent = getIntent();
        if (intent != null) {
            this.f48860e = intent.getBooleanExtra("isCallbackRequired", false);
        }
        Intent intent2 = getIntent();
        if (intent2 != null && intent2.hasExtra("source")) {
            Intent intent3 = getIntent();
            if (intent3 == null || (str = intent3.getStringExtra("source")) == null) {
                str = "";
            }
            this.f48862g = str;
        }
        this.f48859d = p.a("orderDetail", getIntent().getStringExtra("key_source"), true);
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        cVar.f48841a = this.f48859d;
        this.f48864i = getIntent().getBooleanExtra("do_check_order_status_by_polling", false);
        this.f48863h = getIntent().getStringExtra("order_id");
        if (TextUtils.isEmpty(this.f48863h)) {
            finish();
            return;
        }
        net.one97.paytm.addmoney.a.a aVar = this.f48857b;
        if (aVar == null) {
            k.a("binder");
        }
        net.one97.paytm.addmoney.towallet.c.c cVar2 = this.f48856a;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        aVar.a(cVar2);
        Fragment c2 = getSupportFragmentManager().c(R.id.addMoneyToWalletDetailFragment);
        if (c2 != null) {
            this.f48858c = (AddMoneyToWalletPostTxnDetailFragment) c2;
            a(net.one97.paytm.addmoney.towallet.c.d.INITIAL);
            net.one97.paytm.addmoney.towallet.c.c cVar3 = this.f48856a;
            if (cVar3 == null) {
                k.a("viewModel");
            }
            q qVar = this;
            cVar3.f48844d.observe(qVar, new c(this));
            if (!this.f48860e) {
                net.one97.paytm.newaddmoney.utils.e.a(activity, net.one97.paytm.helper.a.f50546a.a().a("addmoney_home_url", "https://storefront.paytm.com/v2/h/post-txn-page-new"), new i(this), "add_money_post_transaction_screen");
                ((NestedScrollView) a(R.id.scrollView)).setOnScrollChangeListener(new a(this));
            }
            net.one97.paytm.addmoney.towallet.c.c cVar4 = this.f48856a;
            if (cVar4 == null) {
                k.a("viewModel");
            }
            cVar4.f48847g.observe(qVar, new d(this));
            net.one97.paytm.addmoney.towallet.c.c cVar5 = this.f48856a;
            if (cVar5 == null) {
                k.a("viewModel");
            }
            cVar5.f48848h.observe(qVar, new e(this));
            net.one97.paytm.addmoney.towallet.c.c cVar6 = this.f48856a;
            if (cVar6 == null) {
                k.a("viewModel");
            }
            cVar6.f48849i.observe(qVar, new f(this));
            net.one97.paytm.addmoney.towallet.c.c cVar7 = this.f48856a;
            if (cVar7 == null) {
                k.a("viewModel");
            }
            cVar7.f48845e.observe(qVar, new g(this));
            net.one97.paytm.addmoney.towallet.c.c cVar8 = this.f48856a;
            if (cVar8 == null) {
                k.a("viewModel");
            }
            cVar8.f48846f.observe(qVar, this.j);
            net.one97.paytm.addmoney.towallet.c.c cVar9 = this.f48856a;
            if (cVar9 == null) {
                k.a("viewModel");
            }
            cVar9.a(this.f48863h, this.f48864i);
            net.one97.paytm.helper.c a4 = net.one97.paytm.helper.a.f50546a.a();
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            a4.a(supportFragmentManager, R.id.deals_fragment_container);
            net.one97.paytm.addmoney.utils.d.a(this, "/summary/add-money");
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnDetailFragment");
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.helper.a.f50546a.a().a(context));
    }

    public static final class c implements z<net.one97.paytm.addmoney.towallet.c.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48867a;

        c(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48867a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.addmoney.towallet.c.d dVar = (net.one97.paytm.addmoney.towallet.c.d) obj;
            this.f48867a.b().a(dVar);
            AddMoneyToWalletPostTxnDetailFragment c2 = this.f48867a.c();
            String str = this.f48867a.f48862g;
            if (str != null) {
                c2.f48879c = str;
            }
            AddMoneyToWalletPostTxnDetailFragment c3 = this.f48867a.c();
            if (dVar == null) {
                k.a();
            }
            k.c(dVar, "state");
            net.one97.paytm.addmoney.a.i iVar = c3.f48877a;
            if (iVar == null) {
                k.a("binder");
            }
            iVar.a(dVar);
            net.one97.paytm.addmoney.towallet.c.a aVar = c3.f48878b;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.f48830a = dVar;
            int i2 = c.f48893a[dVar.ordinal()];
            if (i2 == 1 || i2 == 2) {
                net.one97.paytm.addmoney.utils.d.a((Context) c3.getActivity(), "add_money", "add_money_success", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d(net.one97.paytm.newaddmoney.utils.e.a(c3.getActivity()), "Wallet", "", c3.f48879c), "");
                net.one97.paytm.addmoney.a.i iVar2 = c3.f48877a;
                if (iVar2 == null) {
                    k.a("binder");
                }
                iVar2.ae.setBackgroundColor(Color.parseColor("#21c17a"));
                net.one97.paytm.addmoney.a.i iVar3 = c3.f48877a;
                if (iVar3 == null) {
                    k.a("binder");
                }
                iVar3.Q.setText(c3.getString(R.string.money_added_successful));
            } else if (i2 == 3 || i2 == 4) {
                net.one97.paytm.addmoney.utils.d.a((Context) c3.getActivity(), "add_money", "add_money_pending", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d(net.one97.paytm.newaddmoney.utils.e.a(c3.getActivity()), "Wallet", "", c3.f48879c), "");
                net.one97.paytm.addmoney.a.i iVar4 = c3.f48877a;
                if (iVar4 == null) {
                    k.a("binder");
                }
                iVar4.ae.setBackgroundColor(Color.parseColor("#ffa000"));
                net.one97.paytm.addmoney.a.i iVar5 = c3.f48877a;
                if (iVar5 == null) {
                    k.a("binder");
                }
                iVar5.Q.setText(c3.getString(R.string.money_added_to_wallet_pending));
            } else if (i2 == 5) {
                net.one97.paytm.addmoney.utils.d.a((Context) c3.getActivity(), "add_money", "add_money_failed", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d(net.one97.paytm.newaddmoney.utils.e.a(c3.getActivity()), "Wallet", "", c3.f48879c), "");
                net.one97.paytm.addmoney.a.i iVar6 = c3.f48877a;
                if (iVar6 == null) {
                    k.a("binder");
                }
                iVar6.ae.setBackgroundColor(Color.parseColor("#fd5c5c"));
                net.one97.paytm.addmoney.a.i iVar7 = c3.f48877a;
                if (iVar7 == null) {
                    k.a("binder");
                }
                iVar7.Q.setText(c3.getString(R.string.add_money_to_wallet_failed));
            }
            if (dVar == net.one97.paytm.addmoney.towallet.c.d.LOADING) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f48867a.a(R.id.wallet_loader));
                return;
            }
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f48867a.a(R.id.wallet_loader));
            if (this.f48867a.f48860e) {
                AddMoneyToWalletPostTxnActivity.a(this.f48867a);
            }
        }
    }

    public static final class d implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48868a;

        d(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48868a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.paytm.network.a aVar = (com.paytm.network.a) obj;
            if (aVar != null) {
                this.f48868a.a(aVar, (DialogInterface.OnClickListener) new a(this));
            }
        }

        public static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f48869a;

            a(d dVar) {
                this.f48869a = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (!this.f48869a.f48868a.isFinishing()) {
                    this.f48869a.f48868a.finish();
                }
            }
        }
    }

    public static final class e implements z<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48870a;

        e(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48870a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                AddMoneyToWalletPostTxnActivity.a(this.f48870a, (CJROrderSummary) iJRPaytmDataModel);
            }
        }
    }

    public static final class f implements z<o<? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48871a;

        f(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48871a = addMoneyToWalletPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            if (oVar != null) {
                AddMoneyUtils.a(this.f48871a, (NetworkCustomError) oVar.getSecond(), "javaClass", Boolean.FALSE);
            }
        }
    }

    public static final class i implements net.one97.paytm.helper.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48874a;

        i(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48874a = addMoneyToWalletPostTxnActivity;
        }

        public final void onWidgetLoaded(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                if (!this.f48874a.f48859d) {
                    AddMoneyToWalletPostTxnActivity.a(this.f48874a, (LinkedHashMap) sanitizedResponseModel.getSfWidgets(), sanitizedResponseModel.getGaListener());
                }
                AddMoneyToWalletPostTxnActivity.a(this.f48874a, (List) sanitizedResponseModel.getRvWidgets(), sanitizedResponseModel.getGaListener());
            }
        }
    }

    static final class a implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48865a;

        a(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48865a = addMoneyToWalletPostTxnActivity;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            if (i3 > i5) {
                View a2 = this.f48865a.a(R.id.lyt_bottom_tab_bar);
                k.a((Object) a2, "lyt_bottom_tab_bar");
                a2.setVisibility(8);
            }
            if (i3 < i5) {
                View a3 = this.f48865a.a(R.id.lyt_bottom_tab_bar);
                k.a((Object) a3, "lyt_bottom_tab_bar");
                a3.setVisibility(0);
            }
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48873a;

        h(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
            this.f48873a = addMoneyToWalletPostTxnActivity;
        }

        public final void onClick(View view) {
            this.f48873a.e();
        }
    }

    public final void d() {
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        if (cVar.j != null) {
            net.one97.paytm.addmoney.towallet.c.c cVar2 = this.f48856a;
            if (cVar2 == null) {
                k.a("viewModel");
            }
            CJROrderSummary cJROrderSummary = cVar2.j;
            if (!(cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().size() <= 0)) {
                CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
                cJROrderedCart.setOrderId(cJROrderSummary.getId());
                Bundle bundle = new Bundle();
                bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                net.one97.paytm.helper.a.f50546a.a().a((FragmentActivity) this, bundle);
            }
            net.one97.paytm.addmoney.utils.d.a((Context) this, "add_money", "add_money_24x7", "add_money_post_transaction_screen", (ArrayList<String>) kotlin.a.k.d("", "", "", this.f48862g), "");
        }
    }

    public final void onBackPressed() {
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        if (cVar.f48843c != null) {
            net.one97.paytm.addmoney.towallet.c.c cVar2 = this.f48856a;
            if (cVar2 == null) {
                k.a("viewModel");
            }
            if (cVar2.f48843c == net.one97.paytm.addmoney.towallet.c.d.SUCCESS_DETAIL && !this.f48859d) {
                net.one97.paytm.addmoney.towallet.c.c cVar3 = this.f48856a;
                if (cVar3 == null) {
                    k.a("viewModel");
                }
                cVar3.a(net.one97.paytm.addmoney.towallet.c.d.SUCCESS_INITIAL);
                return;
            }
        }
        if (this.f48860e) {
            e();
        } else {
            finish();
        }
    }

    public final void a(net.one97.paytm.addmoney.towallet.c.d dVar) {
        k.c(dVar, "state");
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        cVar.a(dVar);
    }

    public final void a(com.paytm.network.a aVar, DialogInterface.OnClickListener onClickListener) {
        k.c(aVar, "request");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new j(this, aVar));
        if (onClickListener != null) {
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.cancel, onClickListener);
        }
        builder.show();
    }

    static final class j implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnActivity f48875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f48876b;

        j(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity, com.paytm.network.a aVar) {
            this.f48875a = addMoneyToWalletPostTxnActivity;
            this.f48876b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f48875a)) {
                this.f48875a.a().a(this.f48876b);
            } else {
                this.f48875a.a(this.f48876b, (DialogInterface.OnClickListener) null);
            }
        }
    }

    public final void e() {
        net.one97.paytm.addmoney.towallet.c.d dVar;
        Intent intent = new Intent();
        net.one97.paytm.addmoney.towallet.c.c cVar = this.f48856a;
        if (cVar == null) {
            k.a("viewModel");
        }
        if (cVar != null) {
            dVar = cVar.f48843c;
        } else {
            dVar = null;
        }
        intent.putExtra("addmoney_status", b(dVar));
        intent.putExtra("wallet_balance", getString(R.string.add_paytm_balance_new) + " ₹ " + net.one97.paytm.addmoney.utils.j.b(getApplicationContext()));
        setResult(-1, intent);
        finish();
    }

    private static String b(net.one97.paytm.addmoney.towallet.c.d dVar) {
        if (dVar == null) {
            return "PENDING";
        }
        int i2 = b.f48892a[dVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return "SUCCESS";
        }
        return i2 != 3 ? "PENDING" : "FAILURE";
    }

    public static final /* synthetic */ void a(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
        String stringExtra;
        if (addMoneyToWalletPostTxnActivity.a(R.id.stub) != null) {
            View a2 = addMoneyToWalletPostTxnActivity.a(R.id.stub);
            k.a((Object) a2, "stub");
            a2.setBackground(androidx.core.content.b.a((Context) addMoneyToWalletPostTxnActivity, R.drawable.elevation_effect_background));
            View a3 = addMoneyToWalletPostTxnActivity.a(R.id.stub);
            Button button = a3 != null ? (Button) a3.findViewById(R.id.btn_done) : null;
            if (button != null) {
                button.setVisibility(0);
            }
            Intent intent = addMoneyToWalletPostTxnActivity.getIntent();
            if (!(intent == null || (stringExtra = intent.getStringExtra("done_button_text")) == null || button == null)) {
                button.setText(stringExtra);
            }
            if (button != null) {
                button.setOnClickListener(new h(addMoneyToWalletPostTxnActivity));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0319  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity r17, net.one97.paytm.common.entity.shopping.CJROrderSummary r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "conv_fee"
            net.one97.paytm.addmoney.towallet.c.c r3 = r0.f48856a
            java.lang.String r4 = "viewModel"
            if (r3 != 0) goto L_0x0010
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0010:
            java.lang.String r5 = "response"
            kotlin.g.b.k.c(r1, r5)
            java.lang.String r6 = net.one97.paytm.addmoney.towallet.c.c.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r18)
            java.lang.String r7 = "CC"
            r8 = 2144(0x860, float:3.004E-42)
            if (r6 != 0) goto L_0x0020
            goto L_0x0034
        L_0x0020:
            int r9 = r6.hashCode()
            if (r9 == r8) goto L_0x0027
            goto L_0x0034
        L_0x0027:
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0034
            androidx.lifecycle.y<java.lang.Boolean> r3 = r3.f48845e
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r3.setValue(r6)
        L_0x0034:
            net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnDetailFragment r3 = r0.f48858c
            if (r3 != 0) goto L_0x003d
            java.lang.String r0 = "postTxnDetailFragment"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x003d:
            kotlin.g.b.k.c(r1, r5)
            net.one97.paytm.addmoney.towallet.c.a r6 = r3.f48878b
            if (r6 != 0) goto L_0x0047
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0047:
            android.content.Context r9 = r3.getContext()
            if (r9 != 0) goto L_0x0050
            kotlin.g.b.k.a()
        L_0x0050:
            java.lang.String r0 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r9, r0)
            kotlin.g.b.k.c(r1, r5)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r6.f48831b
            r10 = 0
            r12 = 1
            r13 = 0
            if (r5 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r6.f48831b
            r14 = 0
            if (r5 == 0) goto L_0x006f
            java.util.ArrayList r5 = r5.getOrderedCartList()
            goto L_0x0070
        L_0x006f:
            r5 = r14
        L_0x0070:
            if (r5 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r6.f48831b
            if (r5 == 0) goto L_0x0089
            java.util.ArrayList r5 = r5.getOrderedCartList()
            if (r5 == 0) goto L_0x0089
            java.lang.Object r5 = r5.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x0089
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r5 = r5.getFullFillmentOject()
            goto L_0x008a
        L_0x0089:
            r5 = r14
        L_0x008a:
            if (r5 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r6.f48831b
            if (r5 == 0) goto L_0x00ac
            java.util.ArrayList r5 = r5.getOrderedCartList()
            if (r5 == 0) goto L_0x00ac
            java.lang.Object r5 = r5.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x00ac
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r5 = r5.getFullFillmentOject()
            if (r5 == 0) goto L_0x00ac
            double r14 = r5.getBalance()
            java.lang.Double r14 = java.lang.Double.valueOf(r14)
        L_0x00ac:
            if (r14 != 0) goto L_0x00b1
            kotlin.g.b.k.a()
        L_0x00b1:
            r17 = r9
            double r8 = r14.doubleValue()
            int r8 = java.lang.Double.compare(r8, r10)
            if (r8 < 0) goto L_0x00cb
            r6.u = r12
            androidx.lifecycle.y<java.lang.String> r8 = r6.n
            java.lang.String r9 = java.lang.String.valueOf(r14)
            r8.setValue(r9)
            goto L_0x00cb
        L_0x00c9:
            r17 = r9
        L_0x00cb:
            boolean r8 = r6.u
            if (r8 != 0) goto L_0x00f2
            android.app.Application r8 = r6.getApplication()
            java.lang.String r9 = "getApplication()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            android.content.Context r8 = (android.content.Context) r8
            kotlin.g.b.k.c(r8, r0)
            net.one97.paytm.addmoney.towallet.b.a.a r0 = net.one97.paytm.addmoney.towallet.b.a.a.f48829a
            android.app.Application r0 = r6.getApplication()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.addmoney.towallet.c.a$a r9 = new net.one97.paytm.addmoney.towallet.c.a$a
            r9.<init>(r6, r8)
            net.one97.paytm.wallet.newdesign.addmoney.c.c r9 = (net.one97.paytm.wallet.newdesign.addmoney.c.c) r9
            net.one97.paytm.addmoney.towallet.b.a.a.a(r0, r9)
        L_0x00f2:
            r6.f48831b = r1
            double r8 = r18.getGrandTotal()
            r6.w = r8
            java.util.ArrayList r0 = r18.getOrderedCartList()
            if (r0 == 0) goto L_0x0172
            java.util.ArrayList r0 = r18.getOrderedCartList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0172
            java.util.ArrayList r0 = r18.getOrderedCartList()
            java.lang.Object r0 = r0.get(r13)
            java.lang.String r8 = "response.orderedCartList[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            double r14 = r0.getTotalPrice()
            r6.v = r14
            java.util.ArrayList r0 = r18.getOrderedCartList()
            java.lang.Object r0 = r0.get(r13)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.util.Map r0 = r0.getRechargeConfiguration()
            if (r0 == 0) goto L_0x0176
            boolean r8 = r0.containsKey(r2)     // Catch:{ Exception -> 0x016d }
            if (r8 == 0) goto L_0x014a
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x016d }
            if (r0 != 0) goto L_0x0141
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x016d }
        L_0x0141:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x016d }
            double r8 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x016d }
            r6.x = r8     // Catch:{ Exception -> 0x016d }
            goto L_0x0165
        L_0x014a:
            java.lang.String r2 = "rcf"
            boolean r2 = r0.containsKey(r2)     // Catch:{ Exception -> 0x016d }
            if (r2 == 0) goto L_0x0165
            java.lang.String r2 = "rcf"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x016d }
            if (r0 != 0) goto L_0x015d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x016d }
        L_0x015d:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x016d }
            double r8 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x016d }
            r6.x = r8     // Catch:{ Exception -> 0x016d }
        L_0x0165:
            double r8 = r6.v     // Catch:{ Exception -> 0x016d }
            double r14 = r6.x     // Catch:{ Exception -> 0x016d }
            double r8 = r8 + r14
            r6.w = r8     // Catch:{ Exception -> 0x016d }
            goto L_0x0176
        L_0x016d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0176
        L_0x0172:
            double r8 = r6.w
            r6.v = r8
        L_0x0176:
            double r8 = r6.x
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x018f
            androidx.databinding.i<java.lang.Boolean> r0 = r6.s
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.set(r2)
            double r8 = r6.x
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = r8 * r10
            double r10 = r6.v
            double r8 = r8 / r10
            r6.y = r8
            goto L_0x0196
        L_0x018f:
            androidx.databinding.i<java.lang.Boolean> r0 = r6.s
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.set(r2)
        L_0x0196:
            androidx.databinding.i<java.lang.String> r0 = r6.f48832c
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.addmoney.R.string.wallet_rs
            r8 = r17
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r9 = "context.getString(R.string.wallet_rs)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            java.lang.Object[] r10 = new java.lang.Object[r12]
            double r14 = r6.v
            java.lang.Double r11 = java.lang.Double.valueOf(r14)
            r10[r13] = r11
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r12)
            java.lang.String r2 = java.lang.String.format(r2, r10)
            java.lang.String r10 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r10)
            r0.set(r2)
            androidx.databinding.i<java.lang.String> r0 = r6.f48833d
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.addmoney.R.string.wallet_rs
            java.lang.String r2 = r8.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            java.lang.Object[] r11 = new java.lang.Object[r12]
            java.text.DecimalFormat r14 = new java.text.DecimalFormat
            java.lang.String r15 = "#########.##"
            r14.<init>(r15)
            r16 = r4
            double r4 = r6.w
            java.lang.String r4 = r14.format(r4)
            r11[r13] = r4
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r11, r12)
            java.lang.String r2 = java.lang.String.format(r2, r4)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r10)
            r0.set(r2)
            androidx.databinding.i<java.lang.String> r0 = r6.f48834e
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = net.one97.paytm.addmoney.R.string.wallet_rs
            java.lang.String r2 = r8.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            java.lang.Object[] r4 = new java.lang.Object[r12]
            java.text.DecimalFormat r5 = new java.text.DecimalFormat
            r5.<init>(r15)
            double r14 = r6.x
            java.lang.String r5 = r5.format(r14)
            r4[r13] = r5
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r12)
            java.lang.String r2 = java.lang.String.format(r2, r4)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r10)
            r0.set(r2)
            net.one97.paytm.helper.a$a r0 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r0 = r0.a()
            java.lang.String r2 = "charges_without_percent"
            java.lang.String r0 = r0.f((java.lang.String) r2)
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0234
            int r0 = net.one97.paytm.addmoney.R.string.charges_without_percent
            java.lang.String r0 = r8.getString(r0)
        L_0x0234:
            androidx.databinding.i<java.lang.String> r2 = r6.f48835f
            r2.set(r0)
            androidx.databinding.i<java.lang.String> r0 = r6.l
            java.lang.String r2 = r18.getPaymentText()
            r0.set(r2)
            androidx.databinding.i<java.lang.String> r0 = r6.f48836g
            int r2 = net.one97.paytm.addmoney.R.string.rupees_only
            java.lang.Object[] r4 = new java.lang.Object[r12]
            double r9 = r6.v
            java.lang.String r5 = java.lang.String.valueOf(r9)
            java.lang.String r5 = net.one97.paytm.addmoney.utils.l.a((java.lang.String) r5)
            r4[r13] = r5
            java.lang.String r2 = r8.getString(r2, r4)
            r0.set(r2)
            androidx.databinding.i<java.lang.String> r0 = r6.f48837h
            java.lang.String r2 = r18.getCreatedAt()
            java.lang.String r4 = "hh:mm a, dd MMM yyyy"
            java.lang.String r2 = net.one97.paytm.addmoney.utils.AddMoneyUtils.a((java.lang.String) r2, (java.lang.String) r4)
            r0.set(r2)
            java.util.ArrayList r0 = r18.getPaymentInfo()
            if (r0 == 0) goto L_0x0373
            java.util.ArrayList r0 = r18.getPaymentInfo()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0373
            java.util.ArrayList r0 = r18.getPaymentInfo()
            java.lang.Object r0 = r0.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r0
            androidx.databinding.i<java.lang.String> r2 = r6.f48838i
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = net.one97.paytm.addmoney.R.string.order_id
            java.lang.String r5 = r8.getString(r5)
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            java.lang.String r5 = "paymentInfo"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r5 = r0.getOrderId()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.set(r4)
            java.lang.String r2 = r0.getBankTransactionId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02db
            androidx.databinding.i<java.lang.String> r2 = r6.j
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = net.one97.paytm.addmoney.R.string.bank_transaction_id_
            java.lang.String r5 = r8.getString(r5)
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            java.lang.String r5 = r0.getBankTransactionId()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.set(r4)
        L_0x02db:
            java.lang.String r2 = r0.getPaymentBank()
            java.lang.String r4 = "ppbl"
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r12)
            if (r4 == 0) goto L_0x02ed
            int r2 = net.one97.paytm.addmoney.R.string.paytm_payment_bank
            java.lang.String r2 = r8.getString(r2)
        L_0x02ed:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0308
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = " - "
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            goto L_0x030a
        L_0x0308:
            java.lang.String r2 = ""
        L_0x030a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r0 = r0.getPaymentMethod()
            if (r0 != 0) goto L_0x0319
            goto L_0x0365
        L_0x0319:
            int r2 = r0.hashCode()
            r5 = 2144(0x860, float:3.004E-42)
            if (r2 == r5) goto L_0x0358
            r5 = 2175(0x87f, float:3.048E-42)
            if (r2 == r5) goto L_0x0349
            r5 = 2484(0x9b4, float:3.481E-42)
            if (r2 == r5) goto L_0x033a
            r5 = 84238(0x1490e, float:1.18043E-40)
            if (r2 == r5) goto L_0x032f
            goto L_0x0365
        L_0x032f:
            java.lang.String r2 = "UPI"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0365
            java.lang.String r0 = "UPI"
            goto L_0x0367
        L_0x033a:
            java.lang.String r2 = "NB"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0365
            int r0 = net.one97.paytm.addmoney.R.string.net_banking
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0367
        L_0x0349:
            java.lang.String r2 = "DC"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0365
            int r0 = net.one97.paytm.addmoney.R.string.debit_card
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0367
        L_0x0358:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0365
            int r0 = net.one97.paytm.addmoney.R.string.credit_card
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0367
        L_0x0365:
            java.lang.String r0 = ""
        L_0x0367:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            androidx.databinding.i<java.lang.String> r2 = r6.q
            r2.set(r0)
        L_0x0373:
            java.util.ArrayList r0 = r18.getOrderedCartList()
            if (r0 == 0) goto L_0x03bf
            java.util.ArrayList r0 = r18.getOrderedCartList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03bf
            java.util.ArrayList r0 = r18.getOrderedCartList()
            java.lang.Object r0 = r0.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r1 = "orderDetail"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r0.getPromoCode()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03a6
            androidx.databinding.i<java.lang.Boolean> r0 = r6.r
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.set(r1)
            goto L_0x03bf
        L_0x03a6:
            androidx.databinding.i<java.lang.Boolean> r1 = r6.r
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.set(r2)
            androidx.databinding.i<java.lang.String> r1 = r6.o
            java.lang.String r2 = r0.getPromoCode()
            r1.set(r2)
            androidx.databinding.i<java.lang.String> r1 = r6.p
            java.lang.String r0 = r0.getPromoText()
            r1.set(r0)
        L_0x03bf:
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x03d1
            androidx.databinding.i<java.lang.String> r0 = r6.t
            int r1 = net.one97.paytm.addmoney.R.string.net_paid
            java.lang.String r1 = r8.getString(r1)
            r0.set(r1)
            goto L_0x03dc
        L_0x03d1:
            androidx.databinding.i<java.lang.String> r0 = r6.t
            int r1 = net.one97.paytm.addmoney.R.string.uam_p2b_net_payable
            java.lang.String r1 = r8.getString(r1)
            r0.set(r1)
        L_0x03dc:
            net.one97.paytm.addmoney.towallet.c.a r0 = r3.f48878b
            if (r0 != 0) goto L_0x03e3
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x03e3:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.f48831b
            if (r0 == 0) goto L_0x044d
            java.util.ArrayList r1 = r0.getPaymentInfo()
            if (r1 == 0) goto L_0x044d
            int r1 = r1.size()
            if (r1 == 0) goto L_0x044d
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 == 0) goto L_0x044d
            boolean r1 = r3.isAdded()
            if (r1 == 0) goto L_0x044d
            net.one97.paytm.helper.a$a r1 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r4 = r1.a()
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 == 0) goto L_0x0445
            net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity r1 = (net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity) r1
            com.paytmmall.clpartifact.widgets.blueprints.SFWidget r5 = r1.f48861f
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 != 0) goto L_0x0418
            kotlin.g.b.k.a()
        L_0x0418:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r6 = r1
            android.content.Context r6 = (android.content.Context) r6
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 != 0) goto L_0x0429
            kotlin.g.b.k.a()
        L_0x0429:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            androidx.fragment.app.j r7 = r1.getSupportFragmentManager()
            java.lang.String r1 = "activity!!.supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            java.lang.String r8 = r0.getId()
            net.one97.paytm.utils.b.a r10 = net.one97.paytm.utils.b.a.WALLET_ADD_MONEY
            java.lang.String r9 = "16"
            java.lang.String r11 = ""
            r4.a((com.paytmmall.clpartifact.widgets.blueprints.SFWidget) r5, (android.content.Context) r6, (androidx.fragment.app.j) r7, (java.lang.String) r8, (java.lang.String) r9, (net.one97.paytm.utils.b.a) r10, (java.lang.String) r11)
            goto L_0x044d
        L_0x0445:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity"
            r0.<init>(r1)
            throw r0
        L_0x044d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity.a(net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity, net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }

    public static final /* synthetic */ void a(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity, LinkedHashMap linkedHashMap, StoreFrontGAHandler storeFrontGAHandler) {
        IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
        addMoneyToWalletPostTxnActivity.f48861f = iWidgetProvider != null ? iWidgetProvider.getWidget(addMoneyToWalletPostTxnActivity, storeFrontGAHandler) : null;
        if (addMoneyToWalletPostTxnActivity.f48861f instanceof IStaticWidget) {
            FrameLayout frameLayout = (FrameLayout) addMoneyToWalletPostTxnActivity.findViewById(R.id.lyt_bottom_tab_bar);
            SFWidget sFWidget = addMoneyToWalletPostTxnActivity.f48861f;
            if (sFWidget != null) {
                frameLayout.addView(((IStaticWidget) sFWidget).getView());
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
        }
    }

    public static final /* synthetic */ void a(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity, List list, StoreFrontGAHandler storeFrontGAHandler) {
        net.one97.paytm.newaddmoney.view.e eVar = net.one97.paytm.newaddmoney.view.e.f55944a;
        androidx.fragment.app.j supportFragmentManager = addMoneyToWalletPostTxnActivity.getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "getSupportFragmentManager()");
        FrameLayout frameLayout = (FrameLayout) addMoneyToWalletPostTxnActivity.a(R.id.fl_adv);
        k.a((Object) frameLayout, "fl_adv");
        net.one97.paytm.newaddmoney.view.e.a(supportFragmentManager, frameLayout, list, "add_money_post_transaction_screen", storeFrontGAHandler);
    }

    public static final /* synthetic */ void b(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
        Context context = addMoneyToWalletPostTxnActivity;
        net.one97.paytm.addmoney.utils.d.a(context, "add_money", "add_money_view_passbook", "add_money_post_transaction_screen", (ArrayList<String>) kotlin.a.k.d("", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, "", addMoneyToWalletPostTxnActivity.f48862g), "");
        net.one97.paytm.helper.a.f50546a.a().a(context, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet", (Bundle) null);
    }

    public static final /* synthetic */ void d(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
        net.one97.paytm.addmoney.utils.d.a((Context) addMoneyToWalletPostTxnActivity, "add_money", "add_money_share_clicked", "add_money_post_transaction_screen", (ArrayList<String>) kotlin.a.k.d("", "share_app", "", addMoneyToWalletPostTxnActivity.f48862g), "");
        if (!s.a() || addMoneyToWalletPostTxnActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", addMoneyToWalletPostTxnActivity.getString(R.string.post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", addMoneyToWalletPostTxnActivity.getString(R.string.post_payment_add_money));
                LinearLayout linearLayout = (LinearLayout) addMoneyToWalletPostTxnActivity.a(R.id.scrollViewContainer);
                k.a((Object) linearLayout, "scrollViewContainer");
                View view = linearLayout;
                k.c(view, "view");
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                k.a((Object) createBitmap, "bitmap");
                intent.putExtra("android.intent.extra.STREAM", AddMoneyUtils.a((Context) addMoneyToWalletPostTxnActivity, createBitmap));
                Intent createChooser = Intent.createChooser(intent, addMoneyToWalletPostTxnActivity.getString(R.string.post_payment_share_title));
                if (createChooser.resolveActivity(addMoneyToWalletPostTxnActivity.getPackageManager()) != null) {
                    addMoneyToWalletPostTxnActivity.startActivity(createChooser);
                } else {
                    Toast.makeText(addMoneyToWalletPostTxnActivity, addMoneyToWalletPostTxnActivity.getString(R.string.no_app_found), 1).show();
                }
            } catch (IOException e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    e3.printStackTrace();
                }
            }
        } else {
            s.b((Activity) addMoneyToWalletPostTxnActivity);
        }
    }

    public static final /* synthetic */ void e(AddMoneyToWalletPostTxnActivity addMoneyToWalletPostTxnActivity) {
        String str = addMoneyToWalletPostTxnActivity.f48859d ? "My Orders" : "PostTransaction";
        Context context = addMoneyToWalletPostTxnActivity;
        net.one97.paytm.addmoney.utils.d.a(context, str, "Send_money_to_bank_clicked", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d("", str, "", addMoneyToWalletPostTxnActivity.f48862g), "");
        net.one97.paytm.helper.a.f50546a.a().a(context, "paytmmp://cash_wallet?featuretype=wallet_to_ppb", (Bundle) null);
    }
}
