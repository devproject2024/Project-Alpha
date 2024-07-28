package net.one97.paytm.recharge.creditcard.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import easypay.manager.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeBaseActivityV8;
import net.one97.paytm.recharge.common.c.c;
import net.one97.paytm.recharge.common.c.d;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.s;
import net.one97.paytm.recharge.common.fragment.e;
import net.one97.paytm.recharge.common.h.d;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bc;
import net.one97.paytm.recharge.common.utils.i;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.creditcard.c.a;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class AJRCreditCardEnterAmountActivity extends AJRRechargeBaseActivityV8 implements TextWatcher, View.OnClickListener, c.b, c.C1181c, ai, s, e.a, i.b {
    /* access modifiers changed from: private */
    public static final int P = 2001;

    /* renamed from: b  reason: collision with root package name */
    public static final b f62377b = new b((byte) 0);
    private TextView A;
    /* access modifiers changed from: private */
    public ImageView B;
    private ImageView C;
    /* access modifiers changed from: private */
    public CJRProductsItem D;
    private boolean E;
    private CJRRechargeCart F;
    private boolean G;
    private boolean H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public int J;
    private net.one97.paytm.recharge.ordersummary.h.d K;
    private final String L = "credit_card";
    private CJRInputFieldsItem M;
    private CJRCategoryData N;
    /* access modifiers changed from: private */
    public boolean O;
    private HashMap Q;

    /* renamed from: a  reason: collision with root package name */
    z<CJRRechargeCart> f62378a;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f62379c;

    /* renamed from: d  reason: collision with root package name */
    private CollapsingToolbarLayout f62380d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.recharge.creditcard.c.a f62381e;

    /* renamed from: f  reason: collision with root package name */
    private CJRCreditCardTokenizationModel f62382f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRCreditCardModelV8 f62383g;

    /* renamed from: h  reason: collision with root package name */
    private CJRAggsItem f62384h;

    /* renamed from: i  reason: collision with root package name */
    private CJRItem f62385i;
    private String j;
    private String k;
    private boolean l;
    private String m = "";
    /* access modifiers changed from: private */
    public CustomAmountTextInputEditTextV8 n;
    private TextView o;
    private View p;
    private TextView q;
    private TextView r;
    private View s;
    /* access modifiers changed from: private */
    public CJRProceedWidgetV8 t;
    private c.d u = new c.d();
    private String v = "";
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.c.c w;
    /* access modifiers changed from: private */
    public CJROfferCode x;
    /* access modifiers changed from: private */
    public CJROffers y;
    private net.one97.paytm.recharge.common.c.d z;

    public final View a(int i2) {
        if (this.Q == null) {
            this.Q = new HashMap();
        }
        View view = (View) this.Q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.Q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "promoCode");
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "error");
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        c(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(3, aJRCreditCardEnterAmountActivity);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivity.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivity) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends NetworkCustomError>, x> {
        final /* synthetic */ AJRCreditCardEnterAmountActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(1);
            this.this$0 = aJRCreditCardEnterAmountActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<? extends NetworkCustomError>) (Data) obj);
            return x.f47997a;
        }

        public final void invoke(final Data<? extends NetworkCustomError> data) {
            net.one97.paytm.recharge.common.c.c d2;
            if ((data != null ? (NetworkCustomError) data.getData() : null) != null && (d2 = this.this$0.w) != null && d2.isVisible() && this.this$0.x != null) {
                CJROfferCode e2 = this.this$0.x;
                if (e2 == null) {
                    kotlin.g.b.k.a();
                }
                if (!TextUtils.isEmpty(e2.getCode())) {
                    net.one97.paytm.recharge.common.c.c d3 = this.this$0.w;
                    if (d3 != null) {
                        d3.dismiss();
                    }
                    Object systemService = this.this$0.getSystemService("input_method");
                    if (systemService != null) {
                        ((InputMethodManager) systemService).toggleSoftInput(1, 0);
                        if (((NetworkCustomError) data.getData()).getStatusCode() == 401 || ((NetworkCustomError) data.getData()).getStatusCode() == 410 || ((NetworkCustomError) data.getData()).getStatusCode() == 403) {
                            new Handler().postDelayed(new Runnable(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ d f62387a;

                                {
                                    this.f62387a = r1;
                                }

                                public final void run() {
                                    Intent intent = this.f62387a.this$0.getIntent();
                                    kotlin.g.b.k.a((Object) intent, "intent");
                                    CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(this.f62387a.this$0, (String) null, intent.getExtras(), (NetworkCustomError) data.getData(), false, true);
                                }
                            }, 500);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            }
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.b<CJROffers, x> {
        final /* synthetic */ AJRCreditCardEnterAmountActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(1);
            this.this$0 = aJRCreditCardEnterAmountActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJROffers) obj);
            return x.f47997a;
        }

        public final void invoke(CJROffers cJROffers) {
            this.this$0.y = cJROffers;
        }
    }

    static final /* synthetic */ class k extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        k(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(3, aJRCreditCardEnterAmountActivity);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivity.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivity) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class l extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        l(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(1, aJRCreditCardEnterAmountActivity);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivity.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((AJRCreditCardEnterAmountActivity) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class m extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        m(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super(3, aJRCreditCardEnterAmountActivity);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(AJRCreditCardEnterAmountActivity.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((AJRCreditCardEnterAmountActivity) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class q<T> implements z<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62397a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f62398b;

        q(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity, x.e eVar) {
            this.f62397a = aJRCreditCardEnterAmountActivity;
            this.f62398b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) obj;
            if ((cJRRechargeCart != null ? cJRRechargeCart.getCart() : null) != null) {
                AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62397a;
                CJROfferCode e2 = aJRCreditCardEnterAmountActivity.x;
                if (e2 == null) {
                    kotlin.g.b.k.a();
                }
                AJRCreditCardEnterAmountActivity.a(aJRCreditCardEnterAmountActivity, cJRRechargeCart, e2);
                androidx.lifecycle.y yVar = (androidx.lifecycle.y) this.f62398b.element;
                if (yVar != null) {
                    z<CJRRechargeCart> zVar = this.f62397a.f62378a;
                    if (zVar == null) {
                        kotlin.g.b.k.a();
                    }
                    yVar.removeObserver(zVar);
                }
                net.one97.paytm.recharge.common.c.c d2 = this.f62397a.w;
                if (d2 != null) {
                    d2.a(8);
                }
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final int a() {
        return R.style.CreditCardAmountTheme;
    }

    public final void a(Toolbar toolbar) {
        CharSequence charSequence;
        super.a(toolbar);
        if (toolbar == null) {
            kotlin.g.b.k.a();
        }
        this.f62379c = toolbar;
        toolbar.setTitle((CharSequence) "");
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        View findViewById = findViewById(R.id.toolbar_layout);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.toolbar_layout)");
        this.f62380d = (CollapsingToolbarLayout) findViewById;
        CollapsingToolbarLayout collapsingToolbarLayout = this.f62380d;
        if (collapsingToolbarLayout == null) {
            kotlin.g.b.k.a("toolbar_layout");
        }
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.f62380d;
        if (collapsingToolbarLayout2 == null) {
            kotlin.g.b.k.a("toolbar_layout");
        }
        collapsingToolbarLayout.setExpandedTitleTypeface(Typeface.create(collapsingToolbarLayout2.getExpandedTitleTypeface(), 1));
        CollapsingToolbarLayout collapsingToolbarLayout3 = this.f62380d;
        if (collapsingToolbarLayout3 == null) {
            kotlin.g.b.k.a("toolbar_layout");
        }
        CollapsingToolbarLayout collapsingToolbarLayout4 = this.f62380d;
        if (collapsingToolbarLayout4 == null) {
            kotlin.g.b.k.a("toolbar_layout");
        }
        collapsingToolbarLayout3.setCollapsedTitleTypeface(Typeface.create(collapsingToolbarLayout4.getExpandedTitleTypeface(), 1));
        CollapsingToolbarLayout collapsingToolbarLayout5 = this.f62380d;
        if (collapsingToolbarLayout5 == null) {
            kotlin.g.b.k.a("toolbar_layout");
        }
        String str = this.j;
        if (str != null) {
            charSequence = str;
        } else {
            charSequence = "";
        }
        collapsingToolbarLayout5.setTitle(charSequence);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        appBarLayout.setExpanded(true, false);
        kotlin.g.b.k.a((Object) appBarLayout, "appbar_layout");
        appBarLayout.setActivated(false);
    }

    public final void onCreate(Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        androidx.lifecycle.y<Data<NetworkCustomError>> yVar;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8;
        String displayCardNumberHint;
        String displayCardNumber;
        String displayCardNumber2;
        LinearLayout linearLayout;
        Context context;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        List<CJRProductsItem> productList;
        Activity activity = this;
        com.paytm.utility.b.e(activity);
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "this.applicationContext");
        this.K = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext);
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.K;
        if (dVar == null) {
            kotlin.g.b.k.a();
        }
        Context applicationContext2 = getApplicationContext();
        Locale locale = Locale.getDefault();
        kotlin.g.b.k.a((Object) locale, "Locale.getDefault()");
        String lowerCase = "/credit_card/amount".toLowerCase(locale);
        kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        dVar.a(applicationContext2, lowerCase);
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb = new StringBuilder("CCAmount Screen: isRecreated ");
        sb.append(bundle != null);
        cJRRechargeUtilities.debugLog(sb.toString());
        setRequestedOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            postponeEnterTransition();
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            kotlin.g.b.k.a((Object) intent, "intent");
            if (intent.getExtras() != null && getIntent().hasExtra("recharge_item") && getIntent().hasExtra("selected_item")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("recharge_item");
                if (serializableExtra != null) {
                    this.f62385i = (CJRItem) serializableExtra;
                    Serializable serializableExtra2 = getIntent().getSerializableExtra("selected_item");
                    if (serializableExtra2 != null) {
                        this.f62383g = (CJRCreditCardModelV8) serializableExtra2;
                        this.j = getIntent().getStringExtra("title");
                        this.N = (CJRCategoryData) getIntent().getSerializableExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM);
                        this.k = getIntent().getStringExtra("Recharge browse plan disclaimer");
                        this.l = kotlin.m.p.a("saved_card", getIntent().getStringExtra(UpiConstants.FROM), true);
                        boolean booleanExtra = getIntent().getBooleanExtra("deeplink", false);
                        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62383g;
                        this.f62384h = cJRCreditCardModelV8 != null ? cJRCreditCardModelV8.getSelectedDCVariant() : null;
                        CJRAggsItem cJRAggsItem = this.f62384h;
                        if (!(cJRAggsItem == null || (productList = cJRAggsItem.getProductList()) == null || !(!productList.isEmpty()))) {
                            CJRAggsItem cJRAggsItem2 = this.f62384h;
                            if (cJRAggsItem2 == null) {
                                kotlin.g.b.k.a();
                            }
                            List<CJRProductsItem> productList2 = cJRAggsItem2.getProductList();
                            if (productList2 == null) {
                                kotlin.g.b.k.a();
                            }
                            this.D = productList2.get(0);
                        }
                        CJRItem cJRItem = this.f62385i;
                        if (cJRItem != null) {
                            if (cJRItem == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.c(cJRItem, "it");
                            net.one97.paytm.recharge.ordersummary.h.d dVar2 = this.K;
                            if (dVar2 == null) {
                                Context applicationContext3 = getApplicationContext();
                                kotlin.g.b.k.a((Object) applicationContext3, "this.applicationContext");
                                dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext3);
                            }
                            this.K = dVar2;
                            Context context2 = this;
                            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this;
                            d.a a2 = new d.a(d.b.CREDIT_CARD).a(cJRItem).a(net.one97.paytm.recharge.common.b.d.b(context2)).a(net.one97.paytm.recharge.common.b.d.d(context2)).a((kotlin.k.e<kotlin.x>) new c(aJRCreditCardEnterAmountActivity));
                            net.one97.paytm.recharge.ordersummary.h.d dVar3 = this.K;
                            if (dVar3 == null) {
                                kotlin.g.b.k.a();
                            }
                            dVar3.f64343a = cJRItem;
                            androidx.lifecycle.ai a3 = am.a((FragmentActivity) this, (al.b) new net.one97.paytm.recharge.common.h.d(a2.a(dVar3))).a(net.one97.paytm.recharge.creditcard.c.a.class);
                            kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(th…elFactory)[T::class.java]");
                            net.one97.paytm.recharge.creditcard.c.a aVar = (net.one97.paytm.recharge.creditcard.c.a) a3;
                            kotlin.g.b.k.c(aVar, "viewModel");
                            aVar.c(Constants.EASYPAY_PAYTYPE_CREDIT_CARD);
                            this.f62381e = aVar;
                            net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62381e;
                            if (!(aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null)) {
                                cJRCategoryDataHelper.setCategoryData(this.N);
                            }
                            aVar.a((kotlin.k.e<kotlin.x>) new k(aJRCreditCardEnterAmountActivity));
                            net.one97.paytm.recharge.common.utils.ai.a(this, aVar.f61408a, new l(aJRCreditCardEnterAmountActivity));
                            w wVar = aVar.t;
                            if (wVar != null) {
                                wVar.f61788h = new m(aJRCreditCardEnterAmountActivity);
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62383g;
                            if (!TextUtils.isEmpty(cJRCreditCardModelV82 != null ? cJRCreditCardModelV82.getDisplayCardNumber() : null)) {
                                net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                a4.setErrorType(ERROR_TYPE.UNDEFINED);
                                CRUFlowModel flowName = a4.getFlowName();
                                if (flowName != null) {
                                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                }
                                CRUFlowModel flowName2 = a4.getFlowName();
                                if (flowName2 != null) {
                                    flowName2.setActionType(ACTION_TYPE.CC_TOKEN.name());
                                }
                                this.O = true;
                                CJRCreditCardModelV8 cJRCreditCardModelV83 = this.f62383g;
                                if (cJRCreditCardModelV83 == null) {
                                    kotlin.g.b.k.a();
                                }
                                String displayCardNumber3 = cJRCreditCardModelV83.getDisplayCardNumber();
                                if (displayCardNumber3 == null) {
                                    kotlin.g.b.k.a();
                                }
                                context = context2;
                                aVar.a("get_credit_card_token", context2, kotlin.m.p.a(displayCardNumber3, " ", "", false), new n(this), this.f62383g, a4);
                            } else {
                                context = context2;
                            }
                            c.d dVar5 = this.u;
                            String string = getString(R.string.apply_promo_code);
                            kotlin.g.b.k.a((Object) string, "getString(R.string.apply_promo_code)");
                            dVar5.a(string);
                            this.u.a((c.b) this);
                            c.d dVar6 = this.u;
                            net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62381e;
                            if (aVar3 == null) {
                                kotlin.g.b.k.a();
                            }
                            LiveData<CJROffers> b2 = aVar3.b();
                            kotlin.g.b.k.c(b2, "offerListLiveData");
                            dVar6.f60970c = b2;
                            c.d dVar7 = this.u;
                            s sVar = this;
                            kotlin.g.b.k.c(sVar, "verifyCallOwner");
                            dVar7.f60971d = sVar;
                            c.d dVar8 = this.u;
                            c.C1181c cVar = this;
                            kotlin.g.b.k.c(cVar, "listner");
                            dVar8.f60972e = cVar;
                            c.d dVar9 = this.u;
                            dVar9.f60973f = true;
                            this.w = new net.one97.paytm.recharge.common.c.c(dVar9);
                            net.one97.paytm.recharge.creditcard.c.a aVar4 = this.f62381e;
                            if (aVar4 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.common.utils.g.a(this, aVar4.b(), new h(this));
                            if (net.one97.paytm.recharge.common.utils.z.a(context)) {
                                net.one97.paytm.recharge.widgets.c.d dVar10 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                CJRRechargeErrorModel a5 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                a5.setErrorType(ERROR_TYPE.UNDEFINED);
                                CRUFlowModel flowName3 = a5.getFlowName();
                                if (flowName3 != null) {
                                    flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                }
                                CRUFlowModel flowName4 = a5.getFlowName();
                                if (flowName4 != null) {
                                    flowName4.setActionType(ACTION_TYPE.FETCH_PROMOS.name());
                                }
                                net.one97.paytm.recharge.creditcard.c.a aVar5 = this.f62381e;
                                if (aVar5 == null) {
                                    kotlin.g.b.k.a();
                                }
                                String a6 = com.paytm.utility.d.a(context);
                                kotlin.g.b.k.a((Object) a6, "CJRNetUtility.getSSOToken(this)");
                                net.one97.paytm.recharge.common.f.d a7 = net.one97.paytm.recharge.common.f.d.a();
                                kotlin.g.b.k.a((Object) a7, "CJRVolley.getRequestQueue(this)");
                                az azVar = az.f61525a;
                                boolean f2 = az.f(context);
                                String a8 = com.paytm.utility.c.a(context, false);
                                kotlin.g.b.k.a((Object) a8, "CJRDefaultRequestParam.g…efaultParams(this, false)");
                                CJRItem cJRItem2 = this.f62385i;
                                if (cJRItem2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                String categoryId = cJRItem2.getCategoryId();
                                kotlin.g.b.k.a((Object) categoryId, "rechargeItem!!.categoryId");
                                aVar5.a("fetch_promo", a6, a7, f2, a8, categoryId, a5);
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 21 || !this.l) {
                            Window window = getWindow();
                            if (window != null) {
                                window.setSoftInputMode(17);
                            }
                        } else {
                            Window window2 = getWindow();
                            if (window2 != null) {
                                window2.setSoftInputMode(20);
                            }
                        }
                        super.onCreate(bundle);
                        setContentView(R.layout.v8_activity_credit_card_enter_amount);
                        a((Toolbar) findViewById(R.id.toolbar));
                        View findViewById = findViewById(R.id.lyt_outer_container);
                        CJRCreditCardModelV8 cJRCreditCardModelV84 = this.f62383g;
                        ba.a(findViewById, cJRCreditCardModelV84 != null ? cJRCreditCardModelV84.getCardType() : null);
                        this.B = (ImageView) findViewById(R.id.img_bank);
                        this.C = (ImageView) findViewById(R.id.cardtypeView);
                        LinearLayout linearLayout2 = (LinearLayout) a(R.id.creditcardnumber_set_view);
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(0);
                        }
                        if ((Build.VERSION.SDK_INT < 21 || this.l || bundle != null) && (linearLayout = (LinearLayout) a(R.id.creditcardnumber_get_view)) != null) {
                            linearLayout.setVisibility(8);
                        }
                        TextView textView = (TextView) findViewById(R.id.txt_card_number);
                        TextView textView2 = (TextView) findViewById(R.id.etCreditCard);
                        if (!this.l) {
                            textView.setOnClickListener(this);
                        }
                        kotlin.g.b.k.a((Object) textView, "txt_card_number");
                        CJRCreditCardModelV8 cJRCreditCardModelV85 = this.f62383g;
                        if (cJRCreditCardModelV85 == null || (displayCardNumber2 = cJRCreditCardModelV85.getDisplayCardNumber()) == null) {
                            charSequence = "";
                        } else {
                            charSequence = displayCardNumber2;
                        }
                        textView.setText(charSequence);
                        kotlin.g.b.k.a((Object) textView2, "etCreditCard");
                        CJRCreditCardModelV8 cJRCreditCardModelV86 = this.f62383g;
                        if (cJRCreditCardModelV86 == null || (displayCardNumber = cJRCreditCardModelV86.getDisplayCardNumber()) == null) {
                            charSequence2 = "";
                        } else {
                            charSequence2 = displayCardNumber;
                        }
                        textView2.setText(charSequence2);
                        EditText editText = (EditText) a(R.id.etCreditCardHint);
                        kotlin.g.b.k.a((Object) editText, "etCreditCardHint");
                        CJRCreditCardModelV8 cJRCreditCardModelV87 = this.f62383g;
                        if (cJRCreditCardModelV87 == null || (displayCardNumberHint = cJRCreditCardModelV87.getDisplayCardNumberHint()) == null) {
                            charSequence3 = "";
                        } else {
                            charSequence3 = displayCardNumberHint;
                        }
                        editText.setHint(charSequence3);
                        CJRProductsItem cJRProductsItem = this.D;
                        if (!TextUtils.isEmpty(cJRProductsItem != null ? cJRProductsItem.getDisclaimer() : null)) {
                            CJRProductsItem cJRProductsItem2 = this.D;
                            this.k = cJRProductsItem2 != null ? cJRProductsItem2.getDisclaimer() : null;
                        }
                        if (!TextUtils.isEmpty(this.k)) {
                            TextView textView3 = (TextView) findViewById(R.id.tv_subdisclaimer);
                            kotlin.g.b.k.a((Object) textView3, "tvSubDisclaimer");
                            textView3.setText(this.k);
                            textView3.setVisibility(0);
                        }
                        this.o = (TextView) findViewById(R.id.rupee_view);
                        TextView textView4 = this.o;
                        if (textView4 == null) {
                            kotlin.g.b.k.a();
                        }
                        textView4.setVisibility(0);
                        this.n = (CustomAmountTextInputEditTextV8) findViewById(R.id.amount_view);
                        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.n;
                        if (customAmountTextInputEditTextV82 == null) {
                            kotlin.g.b.k.a();
                        }
                        customAmountTextInputEditTextV82.addTextChangedListener(this);
                        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV83 = this.n;
                        if (customAmountTextInputEditTextV83 == null) {
                            kotlin.g.b.k.a();
                        }
                        customAmountTextInputEditTextV83.setVisibility(0);
                        g();
                        this.p = findViewById(R.id.promoApplied);
                        View view = this.p;
                        if (view == null) {
                            kotlin.g.b.k.a();
                        }
                        this.q = (TextView) view.findViewById(R.id.promoText);
                        this.r = (TextView) findViewById(R.id.havePromoText);
                        TextView textView5 = this.r;
                        if (textView5 == null) {
                            kotlin.g.b.k.a();
                        }
                        View.OnClickListener onClickListener = this;
                        textView5.setOnClickListener(onClickListener);
                        this.s = findViewById(R.id.offerDetails);
                        View view2 = this.s;
                        if (view2 == null) {
                            kotlin.g.b.k.a();
                        }
                        view2.setVisibility(8);
                        View view3 = this.s;
                        if (view3 == null) {
                            kotlin.g.b.k.a();
                        }
                        view3.setOnClickListener(onClickListener);
                        this.A = (TextView) findViewById(R.id.promoOfferDetail);
                        findViewById(R.id.removePromo).setOnClickListener(onClickListener);
                        this.t = (CJRProceedWidgetV8) findViewById(R.id.btn_proceed);
                        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
                        if (cJRProceedWidgetV8 == null) {
                            kotlin.g.b.k.a();
                        }
                        cJRProceedWidgetV8.setOnClickListener(onClickListener);
                        if (Build.VERSION.SDK_INT >= 21) {
                            com.squareup.picasso.w a9 = com.squareup.picasso.w.a();
                            CJRCreditCardModelV8 cJRCreditCardModelV88 = this.f62383g;
                            String operaterImage = cJRCreditCardModelV88 != null ? cJRCreditCardModelV88.getOperaterImage() : null;
                            if (!TextUtils.isEmpty(operaterImage) && this.B != null) {
                                a9.a(operaterImage).a(this.B, (com.squareup.picasso.e) new f(this));
                            }
                            CJRCreditCardModelV8 cJRCreditCardModelV89 = this.f62383g;
                            String operaterCardTypeImage = cJRCreditCardModelV89 != null ? cJRCreditCardModelV89.getOperaterCardTypeImage() : null;
                            if (!TextUtils.isEmpty(operaterCardTypeImage) && ((ImageView) a(R.id.cardtypeView)) != null) {
                                a9.a(operaterCardTypeImage).a((ImageView) a(R.id.cardtypeView), (com.squareup.picasso.e) new g(this));
                            }
                        }
                        if (this.D != null) {
                            net.one97.paytm.recharge.widgets.c.d dVar11 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            CJRRechargeErrorModel b3 = net.one97.paytm.recharge.widgets.c.d.b();
                            CJRProductsItem cJRProductsItem3 = this.D;
                            if (cJRProductsItem3 == null) {
                                kotlin.g.b.k.a();
                            }
                            b3.setProductId(String.valueOf(cJRProductsItem3.getProductId()));
                        }
                        net.one97.paytm.recharge.creditcard.c.a aVar6 = this.f62381e;
                        if (aVar6 != null) {
                            yVar = aVar6.Q;
                        } else {
                            yVar = null;
                        }
                        net.one97.paytm.recharge.common.utils.g.a(this, yVar, new d(this));
                        if (Build.VERSION.SDK_INT < 21) {
                            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV84 = this.n;
                            if (customAmountTextInputEditTextV84 != null) {
                                if (customAmountTextInputEditTextV84 == null) {
                                    kotlin.g.b.k.a();
                                }
                                customAmountTextInputEditTextV84.postDelayed(new j(this), 200);
                            }
                        } else if (bundle == null) {
                            Window window3 = getWindow();
                            kotlin.g.b.k.a((Object) window3, "window");
                            net.one97.paytm.recharge.creditcard.a aVar7 = net.one97.paytm.recharge.creditcard.a.f62350a;
                            Context context3 = this;
                            CJRCreditCardModelV8 cJRCreditCardModelV810 = this.f62383g;
                            if (cJRCreditCardModelV810 == null) {
                                kotlin.g.b.k.a();
                            }
                            window3.setEnterTransition(net.one97.paytm.recharge.creditcard.a.a(context3, cJRCreditCardModelV810, this.l));
                            Window window4 = getWindow();
                            kotlin.g.b.k.a((Object) window4, "window");
                            net.one97.paytm.recharge.creditcard.a aVar8 = net.one97.paytm.recharge.creditcard.a.f62350a;
                            CJRCreditCardModelV8 cJRCreditCardModelV811 = this.f62383g;
                            if (cJRCreditCardModelV811 == null) {
                                kotlin.g.b.k.a();
                            }
                            window4.setReturnTransition(net.one97.paytm.recharge.creditcard.a.c(context3, cJRCreditCardModelV811, this.l));
                            net.one97.paytm.recharge.creditcard.a aVar9 = net.one97.paytm.recharge.creditcard.a.f62350a;
                            CJRCreditCardModelV8 cJRCreditCardModelV812 = this.f62383g;
                            if (cJRCreditCardModelV812 == null) {
                                kotlin.g.b.k.a();
                            }
                            Transition b4 = net.one97.paytm.recharge.creditcard.a.b(context3, cJRCreditCardModelV812, this.l);
                            b4.addListener(new i(this));
                            Window window5 = getWindow();
                            kotlin.g.b.k.a((Object) window5, "window");
                            window5.setSharedElementEnterTransition(b4);
                            net.one97.paytm.recharge.creditcard.a aVar10 = net.one97.paytm.recharge.creditcard.a.f62350a;
                            CJRCreditCardModelV8 cJRCreditCardModelV813 = this.f62383g;
                            if (cJRCreditCardModelV813 == null) {
                                kotlin.g.b.k.a();
                            }
                            Transition d2 = net.one97.paytm.recharge.creditcard.a.d(context3, cJRCreditCardModelV813, this.l);
                            Window window6 = getWindow();
                            kotlin.g.b.k.a((Object) window6, "window");
                            window6.setSharedElementReturnTransition(d2);
                        } else {
                            Window window7 = getWindow();
                            kotlin.g.b.k.a((Object) window7, "window");
                            window7.setReturnTransition((Transition) null);
                            Window window8 = getWindow();
                            kotlin.g.b.k.a((Object) window8, "window");
                            window8.setSharedElementReturnTransition((Transition) null);
                        }
                        if (booleanExtra && (customAmountTextInputEditTextV8 = this.n) != null) {
                            customAmountTextInputEditTextV8.post(new r(this));
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
            }
        }
        CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: WITHOUT ANY INTENT DATA");
        a(bundle);
        super.onCreate(bundle);
        setResult(0);
        androidx.core.app.a.b(activity);
    }

    public static final class i extends a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62392b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            super();
            this.f62392b = aJRCreditCardEnterAmountActivity;
        }

        public final void onTransitionEnd(Transition transition) {
            CustomAmountTextInputEditTextV8 a2 = this.f62392b.n;
            if (a2 != null) {
                a2.requestFocus();
            }
            new t(this.f62392b);
            CustomAmountTextInputEditTextV8 a3 = this.f62392b.n;
            if (a3 == null) {
                kotlin.g.b.k.a();
            }
            t.b(a3);
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62393a;

        j(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62393a = aJRCreditCardEnterAmountActivity;
        }

        public final void run() {
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62393a;
            Context context = aJRCreditCardEnterAmountActivity;
            CJRCreditCardModelV8 b2 = aJRCreditCardEnterAmountActivity.f62383g;
            String str = null;
            ba.a(context, b2 != null ? b2.getOperaterImage() : null, this.f62393a.B, true);
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity2 = this.f62393a;
            Context context2 = aJRCreditCardEnterAmountActivity2;
            CJRCreditCardModelV8 b3 = aJRCreditCardEnterAmountActivity2.f62383g;
            if (b3 != null) {
                str = b3.getOperaterCardTypeImage();
            }
            ba.a(context2, str, (ImageView) this.f62393a.a(R.id.cardtypeView), true);
        }
    }

    static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62399a;

        r(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62399a = aJRCreditCardEnterAmountActivity;
        }

        public final void run() {
            if (this.f62399a.n != null) {
                new Handler().postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ r f62400a;

                    {
                        this.f62400a = r1;
                    }

                    public final void run() {
                        CustomAmountTextInputEditTextV8 a2 = this.f62400a.f62399a.n;
                        if (a2 == null) {
                            kotlin.g.b.k.a();
                        }
                        a2.requestFocus();
                        Object systemService = this.f62400a.f62399a.getSystemService("input_method");
                        if (!(systemService instanceof InputMethodManager)) {
                            systemService = null;
                        }
                        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                        if (inputMethodManager != null) {
                            CustomAmountTextInputEditTextV8 a3 = this.f62400a.f62399a.n;
                            if (a3 == null) {
                                kotlin.g.b.k.a();
                            }
                            inputMethodManager.toggleSoftInputFromWindow(a3.getApplicationWindowToken(), 2, 0);
                        }
                    }
                }, 200);
            }
        }
    }

    public final void startPostponedEnterTransition() {
        if (this.I + this.J > 1) {
            CJRRechargeUtilities.INSTANCE.debugLog("All images loaded successfully");
            this.I = -1;
            this.J = -1;
            super.startPostponedEnterTransition();
            return;
        }
        CJRRechargeUtilities.INSTANCE.debugLog("Waiting or partially loaded other images to load");
    }

    public static final class f implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62390a;

        f(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62390a = aJRCreditCardEnterAmountActivity;
        }

        public final void onSuccess() {
            this.f62390a.I = 1;
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62390a;
            ImageView c2 = aJRCreditCardEnterAmountActivity.B;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            aJRCreditCardEnterAmountActivity.a(c2);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.c(exc, "e");
            this.f62390a.I = 3;
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62390a;
            ImageView c2 = aJRCreditCardEnterAmountActivity.B;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            aJRCreditCardEnterAmountActivity.b(c2);
        }
    }

    public static final class g implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62391a;

        g(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62391a = aJRCreditCardEnterAmountActivity;
        }

        public final void onSuccess() {
            this.f62391a.J = 1;
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62391a;
            ImageView imageView = (ImageView) aJRCreditCardEnterAmountActivity.a(R.id.cardtypeView);
            if (imageView == null) {
                kotlin.g.b.k.a();
            }
            aJRCreditCardEnterAmountActivity.a(imageView);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.c(exc, "e");
            this.f62391a.J = 3;
            AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity = this.f62391a;
            ImageView imageView = (ImageView) aJRCreditCardEnterAmountActivity.a(R.id.cardtypeView);
            if (imageView == null) {
                kotlin.g.b.k.a();
            }
            aJRCreditCardEnterAmountActivity.b(imageView);
        }
    }

    public final void a(ImageView imageView) {
        kotlin.g.b.k.c(imageView, "view");
        imageView.setVisibility(0);
        startPostponedEnterTransition();
    }

    public final void b(ImageView imageView) {
        kotlin.g.b.k.c(imageView, "view");
        imageView.setVisibility(4);
        startPostponedEnterTransition();
    }

    public static final class n implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62394a;

        n(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62394a = aJRCreditCardEnterAmountActivity;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62394a.O = false;
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f62394a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    private final void g() {
        CJRProductsItem cJRProductsItem = this.D;
        if (cJRProductsItem != null) {
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            List<CJRInputFieldsItem> inputFields = cJRProductsItem.getInputFields();
            if (inputFields != null) {
                for (CJRInputFieldsItem cJRInputFieldsItem : inputFields) {
                    if (cJRInputFieldsItem != null && kotlin.m.p.a("price", cJRInputFieldsItem.getConfigKey(), true)) {
                        String regex = cJRInputFieldsItem.getRegex();
                        if (!TextUtils.isEmpty(regex)) {
                            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
                            if (!(customAmountTextInputEditTextV8 instanceof CustomAmountTextInputEditTextV8)) {
                                continue;
                            } else if (customAmountTextInputEditTextV8 != null) {
                                customAmountTextInputEditTextV8.setRegex(regex);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8");
                            }
                        } else {
                            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.n;
                            if (!(customAmountTextInputEditTextV82 instanceof CustomAmountTextInputEditTextV8)) {
                                continue;
                            } else if (customAmountTextInputEditTextV82 != null) {
                                customAmountTextInputEditTextV82.setRegex("");
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8");
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTextChanged(java.lang.CharSequence r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r0 = r11.n
            if (r0 != 0) goto L_0x0007
            kotlin.g.b.k.a()
        L_0x0007:
            java.lang.String r0 = r0.getCleanString()
            int r14 = r14 - r15
            java.lang.String r15 = ""
            r1 = 8
            if (r14 == 0) goto L_0x0023
            android.view.View r14 = r11.p
            if (r14 == 0) goto L_0x0019
            r14.setVisibility(r1)
        L_0x0019:
            android.widget.TextView r14 = r11.q
            if (r14 == 0) goto L_0x0023
            r2 = r15
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x0023:
            java.lang.String r14 = "txtAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)
            r14 = r0
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r2 = r14.length()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0036
            r2 = 1
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 == 0) goto L_0x0068
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r12 = r11.t
            if (r12 == 0) goto L_0x0040
            r12.setEnabled(r4)
        L_0x0040:
            android.widget.TextView r12 = r11.o
            if (r12 == 0) goto L_0x0050
            r13 = r11
            android.content.Context r13 = (android.content.Context) r13
            int r14 = net.one97.paytm.recharge.R.color.recharge_cc_light_grey
            int r13 = androidx.core.content.b.c(r13, r14)
            r12.setTextColor(r13)
        L_0x0050:
            android.widget.TextView r12 = r11.r
            if (r12 == 0) goto L_0x0057
            r12.setVisibility(r1)
        L_0x0057:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x005e
            r12.setVisibility(r1)
        L_0x005e:
            android.widget.TextView r12 = r11.q
            if (r12 == 0) goto L_0x0067
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r12.setText(r15)
        L_0x0067:
            return
        L_0x0068:
            double r5 = java.lang.Double.parseDouble(r0)
            r7 = 0
            int r15 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x014c
            net.one97.paytm.recharge.model.v4.CJRProductsItem r15 = r11.D
            r2 = 0
            if (r15 == 0) goto L_0x007c
            java.util.List r15 = r15.getInputFields()
            goto L_0x007d
        L_0x007c:
            r15 = r2
        L_0x007d:
            if (r15 == 0) goto L_0x00f0
            r5 = r15
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x00f0
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r5 = r11.M
            if (r5 != 0) goto L_0x00d0
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r15 = r15.iterator()
        L_0x009a:
            boolean r6 = r15.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r15.next()
            r9 = r6
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r9 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r9
            if (r9 != 0) goto L_0x00ac
            kotlin.g.b.k.a()
        L_0x00ac:
            java.lang.String r9 = r9.getType()
            java.lang.String r10 = "amount"
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r3)
            if (r9 == 0) goto L_0x009a
            r5.add(r6)
            goto L_0x009a
        L_0x00bc:
            java.util.List r5 = (java.util.List) r5
            r15 = r5
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r3
            if (r15 == 0) goto L_0x00d0
            java.lang.Object r15 = r5.get(r4)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r15 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r15
            r11.M = r15
        L_0x00d0:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r15 = r11.M
            if (r15 == 0) goto L_0x00d9
            java.lang.Double r15 = r15.getMax()
            goto L_0x00da
        L_0x00d9:
            r15 = r2
        L_0x00da:
            if (r15 == 0) goto L_0x00f0
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r15 = r11.M
            if (r15 == 0) goto L_0x00e5
            java.lang.Double r15 = r15.getMax()
            goto L_0x00e6
        L_0x00e5:
            r15 = r2
        L_0x00e6:
            if (r15 != 0) goto L_0x00eb
            kotlin.g.b.k.a()
        L_0x00eb:
            double r5 = r15.doubleValue()
            goto L_0x00f1
        L_0x00f0:
            r5 = r7
        L_0x00f1:
            int r15 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r15 != 0) goto L_0x0144
            net.one97.paytm.recharge.di.helper.c r15 = net.one97.paytm.recharge.di.helper.c.f62654a
            double r5 = net.one97.paytm.recharge.di.helper.c.bB()
            double r7 = java.lang.Double.parseDouble(r0)
            int r15 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r15 < 0) goto L_0x0144
            java.lang.String r15 = "."
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r14 = kotlin.m.p.a((java.lang.CharSequence) r14, (java.lang.CharSequence) r15, false)
            if (r14 == 0) goto L_0x0144
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r14 = r11.n
            if (r14 == 0) goto L_0x0117
            r15 = r11
            android.text.TextWatcher r15 = (android.text.TextWatcher) r15
            r14.removeTextChangedListener(r15)
        L_0x0117:
            if (r12 == 0) goto L_0x0121
            java.lang.CharSequence r12 = r12.subSequence(r4, r13)
            java.lang.String r2 = r12.toString()
        L_0x0121:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r12 = r11.n
            if (r12 == 0) goto L_0x012b
            r13 = r2
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
        L_0x012b:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r12 = r11.n
            if (r12 == 0) goto L_0x013a
            if (r2 == 0) goto L_0x0136
            int r13 = r2.length()
            goto L_0x0137
        L_0x0136:
            r13 = 0
        L_0x0137:
            r12.setSelection(r13)
        L_0x013a:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r12 = r11.n
            if (r12 == 0) goto L_0x0144
            r13 = r11
            android.text.TextWatcher r13 = (android.text.TextWatcher) r13
            r12.addTextChangedListener(r13)
        L_0x0144:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r12 = r11.t
            if (r12 == 0) goto L_0x0153
            r12.setEnabled(r3)
            goto L_0x0153
        L_0x014c:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r12 = r11.t
            if (r12 == 0) goto L_0x0153
            r12.setEnabled(r4)
        L_0x0153:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x015d
            int r12 = r12.getVisibility()
            if (r12 == r1) goto L_0x0168
        L_0x015d:
            android.view.View r12 = r11.p
            if (r12 == 0) goto L_0x016f
            int r12 = r12.getVisibility()
            r13 = 4
            if (r12 != r13) goto L_0x016f
        L_0x0168:
            android.widget.TextView r12 = r11.r
            if (r12 == 0) goto L_0x016f
            r12.setVisibility(r4)
        L_0x016f:
            android.widget.TextView r12 = r11.o
            if (r12 == 0) goto L_0x017f
            r13 = r11
            android.content.Context r13 = (android.content.Context) r13
            int r14 = net.one97.paytm.recharge.R.color.aprb_text
            int r13 = androidx.core.content.b.c(r13, r14)
            r12.setTextColor(r13)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        w wVar;
        if (i2 != 3 && i2 != 7) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("CCAmount Screen: onActivityResult not handled : requestCode " + i2 + " : resultCode " + i3);
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Login Success");
            if (!this.G) {
                this.G = false;
            } else if (!this.H || this.F == null) {
                h();
            } else {
                CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Re-requested handle-Verify-Call");
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.a();
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.CLP_PROCEED.name());
                }
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62381e;
                if (aVar != null && (wVar = aVar.t) != null) {
                    CJRRechargeCart cJRRechargeCart = this.F;
                    if (cJRRechargeCart == null) {
                        kotlin.g.b.k.a();
                    }
                    wVar.a("verify", cJRRechargeCart, (Object) a2);
                }
            }
        } else {
            ay ayVar = ay.f61523a;
            ay.a(i2);
            CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: Login Failed");
            this.G = false;
        }
    }

    public final void onPause() {
        if (this.l) {
            new t(this).a();
        }
        super.onPause();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        r0 = (r0 = r0.f61409b).getCategoryData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRInstruct r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart
            if (r2 == 0) goto L_0x001b
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "CCAmount Screen: saved successful verify call response"
            r2.debugLog(r3)
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart) r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r0.getRechargeCart()
            r1.F = r0
            r0 = 1
            r1.H = r0
            return
        L_0x001b:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.String r5 = ""
            r6 = 0
            if (r2 == 0) goto L_0x00b6
            net.one97.paytm.recharge.common.utils.a r2 = net.one97.paytm.recharge.common.utils.a.f61493a     // Catch:{ Exception -> 0x00a6 }
            r7 = r1
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x00a6 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r2     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = r2.getCategoryName()     // Catch:{ Exception -> 0x00a6 }
            if (r2 != 0) goto L_0x0034
            r8 = r5
            goto L_0x0035
        L_0x0034:
            r8 = r2
        L_0x0035:
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r2     // Catch:{ Exception -> 0x00a6 }
            net.one97.paytm.common.entity.CJRRechargeCart r9 = r2.getRechargeCart()     // Catch:{ Exception -> 0x00a6 }
            r10 = 0
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r2     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r12 = r2.getProtectionUrl()     // Catch:{ Exception -> 0x00a6 }
            net.one97.paytm.recharge.creditcard.c.a r2 = r1.f62381e     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = r2.q     // Catch:{ Exception -> 0x00a6 }
            r13 = r2
            goto L_0x004d
        L_0x004c:
            r13 = r6
        L_0x004d:
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r0     // Catch:{ Exception -> 0x00a6 }
            java.lang.Boolean r11 = r0.getDealsFastForward()     // Catch:{ Exception -> 0x00a6 }
            net.one97.paytm.recharge.creditcard.c.a r0 = r1.f62381e     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0067
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0067
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r0.getGAEventScreenName()     // Catch:{ Exception -> 0x00a6 }
            r14 = r0
            goto L_0x0068
        L_0x0067:
            r14 = r6
        L_0x0068:
            java.lang.String r15 = ""
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r1.f62384h     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = r0.getBbpsLogoUrl()     // Catch:{ Exception -> 0x00a6 }
            if (r0 != 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r16 = r0
            goto L_0x007a
        L_0x0078:
            r16 = r5
        L_0x007a:
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0088
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0088
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x00a6 }
        L_0x0088:
            r17 = r6
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 61512(0xf048, float:8.6197E-41)
            net.one97.paytm.recharge.common.utils.a.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x00a6 }
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x00a6 }
            r0.<init>()     // Catch:{ Exception -> 0x00a6 }
            net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$o r2 = new net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$o     // Catch:{ Exception -> 0x00a6 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ Exception -> 0x00a6 }
            r0.postDelayed(r2, r3)     // Catch:{ Exception -> 0x00a6 }
            return
        L_0x00a6:
            r0 = move-exception
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = r1.t
            if (r2 == 0) goto L_0x00ae
            r2.b()
        L_0x00ae:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.Throwable) r0)
            return
        L_0x00b6:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity
            if (r2 == 0) goto L_0x0132
            net.one97.paytm.recharge.common.utils.a r2 = net.one97.paytm.recharge.common.utils.a.f61493a     // Catch:{ Exception -> 0x00f4 }
            r7 = r1
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x00f4 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = r2.getCategoryName()     // Catch:{ Exception -> 0x00f4 }
            if (r2 != 0) goto L_0x00ca
            r8 = r5
            goto L_0x00cb
        L_0x00ca:
            r8 = r2
        L_0x00cb:
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.common.entity.CJRRechargeCart r9 = r2.getRechargeCart()     // Catch:{ Exception -> 0x00f4 }
            r2 = r0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r2     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r2.getRechargePayment()     // Catch:{ Exception -> 0x00f4 }
            r11 = 0
            r12 = 0
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r0     // Catch:{ Exception -> 0x00f4 }
            java.lang.Object r13 = r0.getHawkEyeEvent()     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.recharge.common.utils.a.a(r7, r8, r9, r10, r11, r12, r13, false)     // Catch:{ Exception -> 0x00f4 }
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x00f4 }
            r0.<init>()     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$p r2 = new net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$p     // Catch:{ Exception -> 0x00f4 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ Exception -> 0x00f4 }
            r0.postDelayed(r2, r3)     // Catch:{ Exception -> 0x00f4 }
            return
        L_0x00f4:
            r0 = move-exception
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = r1.t
            if (r2 == 0) goto L_0x00fc
            r2.b()
        L_0x00fc:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.Throwable) r0)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r6, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r6)
            java.lang.String r3 = "Unable to open PG page"
            r2.setErrorMsg(r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x011d
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x011d:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x012c
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r4 = r4.name()
            r3.setActionType(r4)
        L_0x012c:
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2, (java.lang.Throwable) r0)
            return
        L_0x0132:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog
            if (r2 == 0) goto L_0x017d
            net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog r0 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog) r0
            java.lang.Object r2 = r0.getHawkEyeEvent()
            boolean r2 = r2 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r2 == 0) goto L_0x015b
            java.lang.Object r2 = r0.getHawkEyeEvent()
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r2.getFlowName()
            if (r4 == 0) goto L_0x0152
            java.lang.String r6 = r4.getActionType()
        L_0x0152:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = r3.getActionType(r6, r4)
            r13 = r2
            r9 = r6
            goto L_0x015d
        L_0x015b:
            r9 = r6
            r13 = r9
        L_0x015d:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            if (r13 == 0) goto L_0x016a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = r13.getErrorType()
            if (r2 != 0) goto L_0x016c
        L_0x016a:
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
        L_0x016c:
            r8 = r2
            java.lang.String r10 = r0.getTitle()
            java.lang.String r11 = r0.getMessage()
            r12 = 0
            r14 = 0
            r15 = 1504(0x5e0, float:2.108E-42)
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (java.lang.String) r10, (java.lang.String) r11, (boolean) r12, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r13, (boolean) r14, (int) r15)
            return
        L_0x017d:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError
            if (r2 == 0) goto L_0x0188
            r22.c()
            r0 = 0
            r1.G = r0
            return
        L_0x0188:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "CCAmount Screen: performInstruction not handled "
            r3.<init>(r4)
            if (r0 == 0) goto L_0x019f
            java.lang.Class r4 = r23.getClass()
            if (r4 == 0) goto L_0x019f
            java.lang.String r4 = r4.getName()
            if (r4 != 0) goto L_0x01a0
        L_0x019f:
            r4 = r5
        L_0x01a0:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.debugLog(r3)
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62395a;

        o(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62395a = aJRCreditCardEnterAmountActivity;
        }

        public final void run() {
            CJRProceedWidgetV8 g2 = this.f62395a.t;
            if (g2 != null) {
                g2.b();
            }
        }
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62396a;

        p(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62396a = aJRCreditCardEnterAmountActivity;
        }

        public final void run() {
            CJRProceedWidgetV8 g2 = this.f62396a.t;
            if (g2 != null) {
                g2.b();
            }
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        Class<?> cls;
        String message;
        Class<?> cls2;
        String message2;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        String str2 = "";
        String str3 = null;
        if ((networkCustomError instanceof net.one97.paytm.recharge.common.utils.c) || (networkCustomError instanceof bc) || CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("CCAmount Screen: AuthError handled ");
            if (networkCustomError != null && (message = networkCustomError.getMessage()) != null) {
                str3 = message;
            } else if (!(networkCustomError == null || (cls = networkCustomError.getClass()) == null)) {
                str3 = cls.getName();
            }
            if (str3 != null) {
                str2 = str3;
            }
            sb.append(str2);
            cJRRechargeUtilities.debugLog(sb.toString());
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            return;
        }
        this.G = false;
        CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb2 = new StringBuilder("CCAmount Screen: onErrorResponse default handled ");
        if (networkCustomError != null && (message2 = networkCustomError.getMessage()) != null) {
            str3 = message2;
        } else if (!(networkCustomError == null || (cls2 = networkCustomError.getClass()) == null)) {
            str3 = cls2.getName();
        }
        if (str3 != null) {
            str2 = str3;
        }
        sb2.append(str2);
        cJRRechargeUtilities2.debugLog(sb2.toString());
        super.a(str, networkCustomError, obj);
    }

    public final void c() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
    }

    public final void onClick(View view) {
        net.one97.paytm.recharge.common.c.d dVar;
        net.one97.paytm.recharge.common.c.c cVar;
        androidx.fragment.app.j jVar = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.txt_card_number;
        if (valueOf != null && valueOf.intValue() == i2) {
            setResult(-1);
            androidx.core.app.a.b(this);
            return;
        }
        int i3 = R.id.havePromoText;
        if (valueOf != null && valueOf.intValue() == i3) {
            try {
                net.one97.paytm.recharge.common.c.c cVar2 = this.w;
                if (cVar2 != null) {
                    jVar = cVar2.getFragmentManager();
                }
                if (jVar == null && (cVar = this.w) != null && !cVar.isAdded()) {
                    net.one97.paytm.recharge.ordersummary.h.d dVar2 = this.K;
                    if (dVar2 != null) {
                        net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, this.L, "promocode_field_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
                    }
                    net.one97.paytm.recharge.common.c.c cVar3 = this.w;
                    if (cVar3 != null) {
                        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
                        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
                        cVar3.show(supportFragmentManager, net.one97.paytm.recharge.common.c.c.f60959c);
                    }
                    new t(this).a();
                }
            } catch (Exception unused) {
            }
        } else {
            int i4 = R.id.removePromo;
            if (valueOf != null && valueOf.intValue() == i4) {
                View view2 = this.p;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView = this.r;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                this.v = "";
                TextView textView2 = this.q;
                if (textView2 != null) {
                    textView2.setText("");
                    return;
                }
                return;
            }
            int i5 = R.id.offerDetails;
            if (valueOf != null && valueOf.intValue() == i5) {
                net.one97.paytm.recharge.common.c.d dVar3 = this.z;
                if (dVar3 != null && !dVar3.isAdded()) {
                    net.one97.paytm.recharge.common.c.d dVar4 = this.z;
                    if (dVar4 != null) {
                        jVar = dVar4.getFragmentManager();
                    }
                    if (jVar == null && (dVar = this.z) != null) {
                        androidx.fragment.app.j supportFragmentManager2 = getSupportFragmentManager();
                        d.a aVar = net.one97.paytm.recharge.common.c.d.f60981a;
                        dVar.show(supportFragmentManager2, net.one97.paytm.recharge.common.c.d.f60982d);
                        return;
                    }
                    return;
                }
                return;
            }
            int i6 = R.id.btn_proceed;
            if (valueOf != null && valueOf.intValue() == i6) {
                h();
            }
        }
    }

    public final void finishAfterTransition() {
        if (this.l) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            finish();
        }
    }

    public final void onBackPressed() {
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.K;
        if (dVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.L, "back_button_clicked", "", "amount", (Object) null, (Object) null, (Object) null, 112);
        }
        this.E = true;
        if (this.l) {
            new t(this).a();
        }
        net.one97.paytm.recharge.common.f.d.a();
        net.one97.paytm.recharge.common.f.d.a(this, ba.f61539a);
        super.onBackPressed();
    }

    private void h() {
        String str;
        Editable text;
        new t(this).a();
        int i2 = 0;
        this.H = false;
        this.E = false;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
        if (customAmountTextInputEditTextV8 != null) {
            if (customAmountTextInputEditTextV8 == null || (text = customAmountTextInputEditTextV8.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            customAmountTextInputEditTextV8.setText(c(str));
        }
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.n;
        if (customAmountTextInputEditTextV82 != null) {
            if (customAmountTextInputEditTextV82 != null) {
                i2 = customAmountTextInputEditTextV82.length();
            }
            customAmountTextInputEditTextV82.setSelection(i2);
        }
        if (!l() || this.l) {
            i();
        } else {
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r10 = this;
            android.widget.TextView r0 = r10.q
            if (r0 == 0) goto L_0x000f
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.toString()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = "without_promo"
            goto L_0x001f
        L_0x001c:
            java.lang.String r0 = "with_promo"
        L_0x001f:
            r5 = r0
            net.one97.paytm.recharge.ordersummary.h.d r1 = r10.K
            if (r1 == 0) goto L_0x004a
            java.lang.String r2 = r10.L
            java.lang.String r6 = net.one97.paytm.recharge.common.utils.ab.f61496a
            java.lang.String r0 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            android.widget.TextView r0 = r10.q
            if (r0 == 0) goto L_0x003d
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x003f
        L_0x003d:
            java.lang.String r0 = ""
        L_0x003f:
            r7 = r0
            r8 = 0
            r9 = 64
            java.lang.String r3 = "proceed_to_pay_clicked"
            java.lang.String r4 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x004a:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = r10.t
            if (r0 == 0) goto L_0x005a
            net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$e r1 = new net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity$e
            r1.<init>(r10)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 0
            r0.postDelayed(r1, r2)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.i():void");
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCreditCardEnterAmountActivity f62389a;

        e(AJRCreditCardEnterAmountActivity aJRCreditCardEnterAmountActivity) {
            this.f62389a = aJRCreditCardEnterAmountActivity;
        }

        public final void run() {
            CJRUtilityAlertV2 alert;
            if (this.f62389a.l()) {
                ax.a aVar = ax.f61521a;
                Context applicationContext = this.f62389a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                CJRProductsItem i2 = this.f62389a.D;
                Long l = null;
                boolean b2 = a2.b(String.valueOf(i2 != null ? i2.getProductId() : null), false, true);
                CJRProductsItem i3 = this.f62389a.D;
                if (((i3 == null || (alert = i3.getAlert()) == null) ? null : alert.getHeading()) == null || b2) {
                    this.f62389a.j();
                    return;
                }
                CJRProductsItem i4 = this.f62389a.D;
                CJRUtilityAlertV2 alert2 = i4 != null ? i4.getAlert() : null;
                CJRProductsItem i5 = this.f62389a.D;
                if (i5 != null) {
                    l = i5.getProductId();
                }
                net.one97.paytm.recharge.common.fragment.e.a(true, alert2, String.valueOf(l)).show(this.f62389a.getSupportFragmentManager(), net.one97.paytm.recharge.common.fragment.e.f61160a);
            }
        }
    }

    public final void b(boolean z2) {
        j();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r11 = this;
            net.one97.paytm.recharge.common.utils.t r0 = new net.one97.paytm.recharge.common.utils.t
            r1 = r11
            android.app.Activity r1 = (android.app.Activity) r1
            r0.<init>(r1)
            r0.a()
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = r11.t
            if (r0 == 0) goto L_0x0012
            r0.a()
        L_0x0012:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r0 = r11.f62382f
            r1 = 0
            if (r0 == 0) goto L_0x0022
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r0 = r0.getBody()
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r0.getCardToken()
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00fd
            r0 = 0
            r11.G = r0
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r2 = r11.f62383g
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = r2.getDisplayCardNumber()
            goto L_0x0038
        L_0x0037:
            r2 = r1
        L_0x0038:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0093
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r10.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()
            if (r1 == 0) goto L_0x005c
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x005c:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r10.getFlowName()
            if (r1 == 0) goto L_0x006b
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r2 = r2.name()
            r1.setActionType(r2)
        L_0x006b:
            net.one97.paytm.recharge.creditcard.c.a r4 = r11.f62381e
            if (r4 == 0) goto L_0x0092
            r6 = r11
            android.content.Context r6 = (android.content.Context) r6
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r1 = r11.f62383g
            if (r1 != 0) goto L_0x0079
            kotlin.g.b.k.a()
        L_0x0079:
            java.lang.String r1 = r1.getDisplayCardNumber()
            if (r1 != 0) goto L_0x0082
            kotlin.g.b.k.a()
        L_0x0082:
            java.lang.String r2 = " "
            java.lang.String r7 = kotlin.m.p.a(r1, r2, r3, r0)
            r8 = r11
            net.one97.paytm.recharge.common.e.ai r8 = (net.one97.paytm.recharge.common.e.ai) r8
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r9 = r11.f62383g
            java.lang.String r5 = "get_credit_card_token"
            r4.a(r5, r6, r7, r8, r9, r10)
        L_0x0092:
            return
        L_0x0093:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_ARG
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r4)
            net.one97.paytm.common.entity.CJRItem r4 = r11.f62385i
            if (r4 == 0) goto L_0x00a9
            java.lang.String r4 = r4.getCategoryId()
            if (r4 != 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r3 = r4
        L_0x00a9:
            r2.setCategoryId(r3)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = r11.D
            if (r3 == 0) goto L_0x00be
            java.lang.Long r3 = r3.getProductId()
            if (r3 == 0) goto L_0x00be
            long r3 = r3.longValue()
            java.lang.String r1 = java.lang.String.valueOf(r3)
        L_0x00be:
            r2.setProductId(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r2.getFlowName()
            if (r1 == 0) goto L_0x00d0
            net.one97.paytm.recharge.widgets.model.ALERT_TYPE r3 = net.one97.paytm.recharge.widgets.model.ALERT_TYPE.PROCEED_TO_PG
            java.lang.String r3 = r3.name()
            r1.setAlertType(r3)
        L_0x00d0:
            int r1 = net.one97.paytm.recharge.R.string.credit_card_final_verify_proceed
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Class<net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity> r4 = net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.class
            java.lang.String r4 = r4.getSimpleName()
            r3[r0] = r4
            r0 = 1
            java.lang.String r4 = "proceedToVerifyCall"
            r3[r0] = r4
            java.lang.String r0 = r11.getString(r1, r3)
            r2.setErrorMsg(r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.c.d.b(r2, r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2)
            return
        L_0x00fd:
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r0 = r11.f62382f
            r11.a((net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.j():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r2 = 1
            if (r20 == 0) goto L_0x003c
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r3 = r20.getBody()
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = r3.getMaskedCardNumber()
            if (r3 == 0) goto L_0x003c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x001c
            r3 = 1
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            if (r3 != r2) goto L_0x003c
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            r5 = 0
            int r1 = net.one97.paytm.recharge.R.string.something_went_wrong
            java.lang.String r6 = r0.getString(r1)
            r7 = 8
            net.one97.paytm.recharge.common.utils.az.a(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = r0.t
            if (r1 == 0) goto L_0x003b
            r1.b()
        L_0x003b:
            return
        L_0x003c:
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()
            if (r4 == 0) goto L_0x0055
            net.one97.paytm.recharge.widgets.model.ALERT_TYPE r5 = net.one97.paytm.recharge.widgets.model.ALERT_TYPE.PROCEED_TO_PG
            java.lang.String r5 = r5.name()
            r4.setAlertType(r5)
        L_0x0055:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()
            if (r4 == 0) goto L_0x0066
            java.lang.StringBuilder r4 = r4.getJourneyStackTrace()
            if (r4 == 0) goto L_0x0066
            java.lang.String r5 = "-clpProceedClick"
            r4.append(r5)
        L_0x0066:
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.c.d.b(r3, r4)
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4)
            r7 = r0
            android.content.Context r7 = (android.content.Context) r7
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r7)
            java.lang.String r5 = "verify"
            r6 = 0
            if (r4 == 0) goto L_0x0189
            boolean r4 = com.paytm.utility.d.c(r7)
            if (r4 == 0) goto L_0x017e
            r0.G = r2
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = r0.D
            if (r4 == 0) goto L_0x0095
            boolean r4 = r4.isProceedToPGEnabled()
            if (r4 != r2) goto L_0x0095
            r4 = 1
            goto L_0x0096
        L_0x0095:
            r4 = 0
        L_0x0096:
            net.one97.paytm.recharge.creditcard.c.a r5 = r0.f62381e
            if (r5 == 0) goto L_0x00a3
            net.one97.paytm.common.entity.CJRItem r5 = r5.r
            if (r5 == 0) goto L_0x00a3
            java.lang.String r5 = r5.getCategoryId()
            goto L_0x00a4
        L_0x00a3:
            r5 = r6
        L_0x00a4:
            com.google.gson.f r8 = new com.google.gson.f     // Catch:{ Exception -> 0x00ea }
            r8.<init>()     // Catch:{ Exception -> 0x00ea }
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x00ea }
            java.lang.Class<java.util.HashMap> r10 = java.util.HashMap.class
            java.lang.Object r8 = r8.a((java.lang.String) r9, r10)     // Catch:{ Exception -> 0x00ea }
            boolean r9 = r8 instanceof java.util.HashMap     // Catch:{ Exception -> 0x00ea }
            if (r9 != 0) goto L_0x00ba
            r8 = r6
        L_0x00ba:
            java.util.HashMap r8 = (java.util.HashMap) r8     // Catch:{ Exception -> 0x00ea }
            r9 = r5
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x00ea }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00ea }
            if (r9 != 0) goto L_0x00ea
            if (r8 == 0) goto L_0x00ea
            r9 = r8
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x00ea }
            if (r9 == 0) goto L_0x00e2
            boolean r9 = r9.containsKey(r5)     // Catch:{ Exception -> 0x00ea }
            if (r9 != r2) goto L_0x00ea
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x00ea }
            java.lang.Object r5 = r8.get(r5)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00ea }
            boolean r5 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r5, (android.content.Context) r0)     // Catch:{ Exception -> 0x00ea }
            if (r5 == 0) goto L_0x00ea
            r5 = 1
            goto L_0x00eb
        L_0x00e2:
            kotlin.u r5 = new kotlin.u     // Catch:{ Exception -> 0x00ea }
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r5.<init>(r8)     // Catch:{ Exception -> 0x00ea }
            throw r5     // Catch:{ Exception -> 0x00ea }
        L_0x00ea:
            r5 = 0
        L_0x00eb:
            if (r5 == 0) goto L_0x00f0
            r17 = 1
            goto L_0x00f2
        L_0x00f0:
            r17 = r4
        L_0x00f2:
            net.one97.paytm.recharge.creditcard.c.a r5 = r0.f62381e
            if (r5 == 0) goto L_0x017d
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r4 = r0.n
            java.lang.String r8 = ""
            if (r4 == 0) goto L_0x0102
            java.lang.String r4 = r4.getCleanString()
            if (r4 != 0) goto L_0x0103
        L_0x0102:
            r4 = r8
        L_0x0103:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r9 = r0.D
            if (r9 == 0) goto L_0x0117
            java.lang.Long r9 = r9.getProductId()
            if (r9 == 0) goto L_0x0117
            long r9 = r9.longValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            if (r9 != 0) goto L_0x0118
        L_0x0117:
            r9 = r8
        L_0x0118:
            if (r20 == 0) goto L_0x0126
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r10 = r20.getBody()
            if (r10 == 0) goto L_0x0126
            java.lang.String r10 = r10.getCardToken()
            if (r10 != 0) goto L_0x0127
        L_0x0126:
            r10 = r8
        L_0x0127:
            if (r20 == 0) goto L_0x0135
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r11 = r20.getBody()
            if (r11 == 0) goto L_0x0135
            java.lang.String r11 = r11.getMaskedCardNumber()
            if (r11 != 0) goto L_0x0136
        L_0x0135:
            r11 = r8
        L_0x0136:
            if (r20 == 0) goto L_0x0144
            net.one97.paytm.recharge.model.creditcard.CJRCreditCardBodyModel r12 = r20.getBody()
            if (r12 == 0) goto L_0x0144
            java.lang.String r12 = r12.getMaskedCardNumber()
            if (r12 != 0) goto L_0x0145
        L_0x0144:
            r12 = r8
        L_0x0145:
            java.lang.String r13 = r0.m
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r0.D
            if (r8 == 0) goto L_0x0153
            boolean r8 = r8.isVisaDirectEnabled()
            if (r8 != r2) goto L_0x0153
            r14 = 1
            goto L_0x0154
        L_0x0153:
            r14 = 0
        L_0x0154:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r0.D
            if (r8 == 0) goto L_0x0160
            boolean r8 = r8.isBillPaymentEnabled()
            if (r8 != r2) goto L_0x0160
            r15 = 1
            goto L_0x0161
        L_0x0160:
            r15 = 0
        L_0x0161:
            android.widget.TextView r1 = r0.q
            if (r1 == 0) goto L_0x0172
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0172
            java.lang.String r1 = r1.toString()
            r16 = r1
            goto L_0x0174
        L_0x0172:
            r16 = r6
        L_0x0174:
            java.lang.String r6 = "verify"
            r8 = r4
            r18 = r3
            r5.a((java.lang.String) r6, (android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (boolean) r17, (java.lang.Object) r18, (net.one97.paytm.recharge.common.e.ai) null)
        L_0x017d:
            return
        L_0x017e:
            net.one97.paytm.recharge.common.utils.c r1 = new net.one97.paytm.recharge.common.utils.c
            r1.<init>()
            com.paytm.network.model.NetworkCustomError r1 = (com.paytm.network.model.NetworkCustomError) r1
            r0.a((java.lang.String) r5, (com.paytm.network.model.NetworkCustomError) r1, (java.lang.Object) r3)
            return
        L_0x0189:
            net.one97.paytm.recharge.common.utils.as r4 = new net.one97.paytm.recharge.common.utils.as
            r4.<init>(r1, r2, r6)
            com.paytm.network.model.NetworkCustomError r4 = (com.paytm.network.model.NetworkCustomError) r4
            r0.a((java.lang.String) r5, (com.paytm.network.model.NetworkCustomError) r4, (java.lang.Object) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.a(net.one97.paytm.recharge.model.creditcard.CJRCreditCardTokenizationModel):void");
    }

    private final void k() {
        String str;
        Editable text;
        i.a aVar = net.one97.paytm.recharge.common.utils.i.f61643a;
        i.b bVar = this;
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62383g;
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
        if (customAmountTextInputEditTextV8 == null || (text = customAmountTextInputEditTextV8.getText()) == null || (str = text.toString()) == null) {
            str = "";
        }
        i.a.a(bVar, cJRCreditCardModelV8, str).show(getSupportFragmentManager(), "");
    }

    public final void b() {
        i();
    }

    private static String c(String str) {
        CharSequence charSequence = str;
        return (!kotlin.m.p.a(charSequence, (CharSequence) AppUtility.CENTER_DOT, false) || str.length() + -1 != kotlin.m.p.a(charSequence, AppUtility.CENTER_DOT, 0, false, 6)) ? str : kotlin.m.p.a(str, AppUtility.CENTER_DOT, "", false);
    }

    /* access modifiers changed from: private */
    public final boolean l() {
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8;
        if (!(this.D == null || (customAmountTextInputEditTextV8 = this.n) == null)) {
            if (customAmountTextInputEditTextV8 == null) {
                kotlin.g.b.k.a();
            }
            if (customAmountTextInputEditTextV8.getVisibility() != 8) {
                CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.n;
                if (customAmountTextInputEditTextV82 == null) {
                    kotlin.g.b.k.a();
                }
                if (!TextUtils.isEmpty(customAmountTextInputEditTextV82.getText().toString())) {
                    CJRProductsItem cJRProductsItem = this.D;
                    List<CJRInputFieldsItem> inputFields = cJRProductsItem != null ? cJRProductsItem.getInputFields() : null;
                    if (inputFields == null) {
                        return false;
                    }
                    for (CJRInputFieldsItem a2 : inputFields) {
                        if (!a(a2)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        String string = getResources().getString(R.string.electricity_empty_value_msg, new Object[]{"Amount"});
        kotlin.g.b.k.a((Object) string, "resources\n              …                \"Amount\")");
        az azVar = az.f61525a;
        az.a(this, ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, (String) null, string, 12);
        return false;
    }

    private final boolean a(CJRInputFieldsItem cJRInputFieldsItem) {
        Double max;
        CJRInputFieldsItem cJRInputFieldsItem2 = cJRInputFieldsItem;
        String str = null;
        if (kotlin.g.b.k.a((Object) cJRInputFieldsItem2 != null ? cJRInputFieldsItem.getType() : null, (Object) "amount")) {
            cJRInputFieldsItem2.setRegex("");
            String string = getString(R.string.invalid_amount);
            kotlin.g.b.k.a((Object) string, "getString(R.string.invalid_amount)");
            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
            if (customAmountTextInputEditTextV8 != null) {
                str = customAmountTextInputEditTextV8.getCleanString();
            }
            double d2 = 0.0d;
            double parseDouble = str != null ? Double.parseDouble(str) : 0.0d;
            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV82 = this.n;
            if (customAmountTextInputEditTextV82 != null && customAmountTextInputEditTextV82.getVisibility() == 0) {
                CharSequence charSequence = str;
                if (TextUtils.isEmpty(charSequence)) {
                    String string2 = getString(R.string.electricity_empty_value_msg, new Object[]{cJRInputFieldsItem.getTitle()});
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.elect…ue_msg, inputField.title)");
                    az azVar = az.f61525a;
                    az.a(this, ERROR_TYPE.INPUT_VALIDATION, (ACTION_TYPE) null, (String) null, string2, 12);
                    return false;
                }
                double d3 = 1.0d;
                if (cJRInputFieldsItem2 != null) {
                    double doubleValue = (cJRInputFieldsItem.getMax() == null || (max = cJRInputFieldsItem.getMax()) == null) ? 0.0d : max.doubleValue();
                    if (cJRInputFieldsItem.getMin() != null) {
                        Double min = cJRInputFieldsItem.getMin();
                        if (min != null) {
                            d2 = min.doubleValue();
                        }
                        d3 = d2;
                    }
                    if (parseDouble < d3) {
                        try {
                            Resources resources = getResources();
                            int i2 = R.string.electricity_bill_amount_more_than;
                            String string3 = resources.getString(i2, new Object[]{String.valueOf(d3)});
                            kotlin.g.b.k.a((Object) string3, "resources.getString(\n   …  minAmt.toString() + \"\")");
                            if (doubleValue >= d3) {
                                Resources resources2 = getResources();
                                int i3 = R.string.electricity_bill_amount_not_in_range;
                                string3 = resources2.getString(i3, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                                kotlin.g.b.k.a((Object) string3, "resources.getString(\n   …, maxAmt.toString() + \"\")");
                            }
                            az azVar2 = az.f61525a;
                            az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string3);
                            return false;
                        } catch (Exception e2) {
                            Resources resources3 = getResources();
                            int i4 = R.string.electricity_bill_amount_more_than;
                            String string4 = resources3.getString(i4, new Object[]{String.valueOf(d3)});
                            kotlin.g.b.k.a((Object) string4, "resources.getString(\n   …, minAmt.toString() + \"\")");
                            if (doubleValue >= d3) {
                                Resources resources4 = getResources();
                                int i5 = R.string.electricity_bill_amount_not_in_range;
                                string4 = resources4.getString(i5, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                                kotlin.g.b.k.a((Object) string4, "resources.getString(\n   …  maxAmt.toString() + \"\")");
                            }
                            az azVar3 = az.f61525a;
                            az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string4);
                            com.paytm.utility.q.d(e2.getMessage());
                            return false;
                        }
                    } else if (doubleValue >= d3 && parseDouble > doubleValue) {
                        Resources resources5 = getResources();
                        int i6 = R.string.electricity_bill_amount_not_in_range;
                        String string5 = resources5.getString(i6, new Object[]{String.valueOf(d3), String.valueOf(doubleValue)});
                        kotlin.g.b.k.a((Object) string5, "resources.getString(\n   …, maxAmt.toString() + \"\")");
                        az azVar4 = az.f61525a;
                        az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, string, string5);
                        return false;
                    } else if (!TextUtils.isEmpty(cJRInputFieldsItem.getRegex())) {
                        if (str == null) {
                            kotlin.g.b.k.a();
                        }
                        String regex = cJRInputFieldsItem.getRegex();
                        if (regex == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!new kotlin.m.l(regex).matches(charSequence)) {
                            String string6 = getString(R.string.electricity_empty_value_msg, new Object[]{cJRInputFieldsItem.getTitle()});
                            kotlin.g.b.k.a((Object) string6, "getString(R.string.elect…ue_msg, inputField.title)");
                            az azVar5 = az.f61525a;
                            az.a(this, ERROR_TYPE.INPUT_VALIDATION, ACTION_TYPE.CLP_PROCEED, getString(R.string.error), string6);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final androidx.lifecycle.y<CJRRechargeCart> b(CJROfferCode cJROfferCode, Object obj) {
        T t2;
        x.e eVar;
        String str;
        String str2;
        net.one97.paytm.recharge.common.f.c cVar;
        CJRCreditCardBodyModel body;
        CJROfferCode cJROfferCode2 = cJROfferCode;
        Object obj2 = obj;
        kotlin.g.b.k.c(cJROfferCode2, "promoCode");
        this.x = cJROfferCode2;
        x.e eVar2 = new x.e();
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62381e;
        if (aVar != null) {
            String code = cJROfferCode.getCode();
            CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62383g;
            if (cJRCreditCardModelV8 == null || (str = cJRCreditCardModelV8.getCardNumber()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject();
            String a2 = this.f62381e != null ? net.one97.paytm.recharge.creditcard.c.a.a(str) : null;
            String b2 = this.f62381e != null ? net.one97.paytm.recharge.creditcard.c.a.b(str) : null;
            if (this.f62381e != null) {
                net.one97.paytm.recharge.creditcard.c.a.b(str);
            }
            CJRAggsItem cJRAggsItem = this.f62384h;
            List<CJRProductsItem> productList = cJRAggsItem != null ? cJRAggsItem.getProductList() : null;
            if (productList == null) {
                kotlin.g.b.k.a();
            }
            String valueOf = String.valueOf(productList.get(0).getProductId());
            CJRAggsItem cJRAggsItem2 = this.f62384h;
            List<CJRProductsItem> productList2 = cJRAggsItem2 != null ? cJRAggsItem2.getProductList() : null;
            if (productList2 == null) {
                kotlin.g.b.k.a();
            }
            boolean isBillPaymentEnabled = productList2.get(0).isBillPaymentEnabled();
            CJRAggsItem cJRAggsItem3 = this.f62384h;
            List<CJRProductsItem> productList3 = cJRAggsItem3 != null ? cJRAggsItem3.getProductList() : null;
            if (productList3 == null) {
                kotlin.g.b.k.a();
            }
            boolean isVisaDirectEnabled = productList3.get(0).isVisaDirectEnabled();
            String str3 = this.m;
            String str4 = "";
            JSONObject jSONObject2 = new JSONObject();
            x.e eVar3 = eVar2;
            CJRItem cJRItem = this.f62385i;
            if (cJRItem == null) {
                kotlin.g.b.k.a();
            }
            jSONObject2.put("category_id", cJRItem.getCategoryId());
            CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
            if (customAmountTextInputEditTextV8 == null || (str2 = customAmountTextInputEditTextV8.getCleanString()) == null) {
                str2 = str4;
            }
            jSONObject2.put("price", str2);
            jSONObject2.put("recharge_number", b2);
            CJRCreditCardTokenizationModel cJRCreditCardTokenizationModel = this.f62382f;
            jSONObject2.put("recharge_number_2", (cJRCreditCardTokenizationModel == null || (body = cJRCreditCardTokenizationModel.getBody()) == null) ? null : body.getCardToken());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("bin_number", a2);
            CharSequence charSequence = str3;
            if (!TextUtils.isEmpty(charSequence)) {
                jSONObject3.put("payment_request_type", str3);
            }
            if (isBillPaymentEnabled) {
                jSONObject3.put("enable_bill_payment", "1");
                if (isVisaDirectEnabled) {
                    jSONObject3.put("enable_visa_direct", "1");
                } else {
                    jSONObject3.put("enable_visa_direct", "0");
                }
            }
            Context context = this;
            jSONObject3.put("id", com.paytm.utility.b.n(context));
            jSONObject3.put("customer_mobile", com.paytm.utility.b.l(context));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(CLPConstants.PRODUCT_ID, valueOf);
            jSONObject4.put("qty", 1);
            jSONObject4.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
            jSONObject4.put("meta_data", jSONObject3);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject4);
            jSONObject.put("cart_items", jSONArray);
            if (!TextUtils.isEmpty(charSequence)) {
                jSONObject.put("payment_request_type", str3);
            }
            if (code != null) {
                jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, code);
            }
            kotlin.g.b.k.c("fetch_promo_verify", "tag");
            kotlin.g.b.k.c(jSONObject, "jsonCart");
            kotlin.g.b.k.c(cJROfferCode2, "promoCode");
            kotlin.g.b.k.c(context, "context");
            aVar.V.setValue(null);
            aVar.V.setValue(new CJRRechargeCart());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            HashMap<String, String> a3 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, context);
            kotlin.g.b.k.a((Object) a3, "CJRAppCommonUtility.addS…nHeader(headers, context)");
            az azVar = az.f61525a;
            String a4 = az.a(jSONObject);
            net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
            String s2 = com.paytm.utility.b.s(context, net.one97.paytm.recharge.di.helper.c.c(a4));
            if (com.paytm.utility.b.c(context)) {
                Object obj3 = obj;
                if (obj3 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj3;
                    cJRRechargeErrorModel.setScreenName("Credit cardPromo");
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    String a5 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
                    CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                    if (flowName != null) {
                        flowName.setRequestBody(a5);
                    }
                }
                new net.one97.paytm.recharge.common.f.c("fetch_promo_verify", s2, new a.k(aVar, cJROfferCode, "fetch_promo_verify", obj, aVar, "fetch_promo_verify", obj), new CJRRechargeCart(), a3, jSONObject.toString(), a.c.RECHARGES, a.b.USER_FACING, "Credit cardPromo", obj);
                String str5 = ba.f61539a;
                kotlin.g.b.k.a((Object) str5, "RechargeUtils.VOLLEY_REQ_TAG");
                net.one97.paytm.recharge.common.f.c cVar3 = cVar;
                cVar3.a(str5);
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar3);
            } else {
                Object obj4 = obj;
                aVar.a("fetch_promo_verify", 0, (IJRPaytmDataModel) null, (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), obj);
            }
            t2 = aVar.V;
            eVar = eVar3;
        } else {
            t2 = null;
            eVar = eVar2;
        }
        eVar.element = t2;
        this.f62378a = new q(this, eVar);
        androidx.lifecycle.y yVar = (androidx.lifecycle.y) eVar.element;
        if (yVar != null) {
            z<CJRRechargeCart> zVar = this.f62378a;
            if (zVar == null) {
                kotlin.g.b.k.a();
            }
            yVar.observeForever(zVar);
        }
        return (androidx.lifecycle.y) eVar.element;
    }

    public final androidx.lifecycle.y<CJROffers> e() {
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62381e;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public final androidx.lifecycle.y<CJRRechargeCart> a(CJROfferCode cJROfferCode, Object obj) {
        kotlin.g.b.k.c(cJROfferCode, "promoCode");
        return b(cJROfferCode, obj);
    }

    public final void d() {
        if (this.v.length() == 0) {
            new t(this).b();
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        List<CJRProductsItem> productList;
        kotlin.g.b.k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRCreditCardTokenizationModel) {
            CJRCreditCardTokenizationModel cJRCreditCardTokenizationModel = (CJRCreditCardTokenizationModel) iJRPaytmDataModel;
            CJRCreditCardBodyModel body = cJRCreditCardTokenizationModel.getBody();
            if (!TextUtils.isEmpty(body != null ? body.getCardToken() : null)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("CCAmount Screen: onResponse : cc-token : SUCCESS : on-proceed-click " + this.G);
                this.f62382f = cJRCreditCardTokenizationModel;
                CJRAggsItem cJRAggsItem = this.f62384h;
                if (!(cJRAggsItem == null || (productList = cJRAggsItem.getProductList()) == null || !(!productList.isEmpty()))) {
                    CJRAggsItem cJRAggsItem2 = this.f62384h;
                    if (cJRAggsItem2 == null) {
                        kotlin.g.b.k.a();
                    }
                    List<CJRProductsItem> productList2 = cJRAggsItem2.getProductList();
                    if (productList2 == null) {
                        kotlin.g.b.k.a();
                    }
                    String requestType = productList2.get(0).getRequestType();
                    if (requestType == null) {
                        requestType = "";
                    }
                    this.m = requestType;
                }
                if (!this.G && !this.O) {
                    j();
                }
                this.O = false;
            } else if (this.G) {
                CJRRechargeUtilities.INSTANCE.debugLog("CCAmount Screen: onResponse : cc-token : Still NOT SUCCESS : on-proceed-click");
                CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.b();
                }
                this.O = false;
            } else if (obj instanceof CJRRechargeErrorModel) {
                if (!this.O) {
                    com.paytm.utility.b.b(this, getString(R.string.error_title_inconvenience), getString(R.string.oops_something_went_wrong), true);
                }
                CJRProceedWidgetV8 cJRProceedWidgetV82 = this.t;
                if (cJRProceedWidgetV82 != null) {
                    cJRProceedWidgetV82.b();
                }
                this.O = false;
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    flowName.setAlertType("");
                }
                CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                if (flowName2 != null) {
                    flowName2.setJourneyStackTrace((StringBuilder) null);
                }
                cJRRechargeErrorModel.setErrorMsg(getString(R.string.credit_card_fetch_card_token, new Object[]{AJRCreditCardEnterAmountActivity.class.getSimpleName(), "onApiSuccess"}));
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }
    }

    public class a implements Transition.TransitionListener {
        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }

        public a() {
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == -1225990041 && str.equals("get_credit_card_token")) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = this.t;
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        } else if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    public final void onDestroy() {
        CustomAmountTextInputEditTextV8 customAmountTextInputEditTextV8 = this.n;
        if (customAmountTextInputEditTextV8 != null) {
            customAmountTextInputEditTextV8.removeTextChangedListener(this);
        }
        super.onDestroy();
    }

    /* JADX WARNING: type inference failed for: r4v8, types: [androidx.fragment.app.j] */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r5 = r18.getCartStatus();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity r17, net.one97.paytm.common.entity.CJRRechargeCart r18, net.one97.paytm.common.entity.shopping.CJROfferCode r19) {
        /*
            r0 = r17
            r1 = r18
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            r3 = 0
            android.os.Bundle r2 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r2, (net.one97.paytm.common.entity.CJRRechargeCart) r1, (boolean) r3, (boolean) r3)
            java.lang.String r4 = "extra.has.error"
            boolean r2 = r2.getBoolean(r4)
            r4 = 0
            if (r1 == 0) goto L_0x0022
            net.one97.paytm.common.entity.shopping.CJRCartStatus r5 = r18.getCartStatus()
            if (r5 == 0) goto L_0x0022
            java.lang.String r5 = r5.getResult()
            goto L_0x0023
        L_0x0022:
            r5 = r4
        L_0x0023:
            java.lang.String r6 = "SUCCESS"
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r7)
            if (r5 == 0) goto L_0x01d2
            if (r2 != 0) goto L_0x01d2
            if (r1 != 0) goto L_0x0033
            kotlin.g.b.k.a()
        L_0x0033:
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r18.getCart()
            if (r2 == 0) goto L_0x004c
            java.util.ArrayList r5 = r2.getCartItems()
            if (r5 == 0) goto L_0x004c
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r5 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r5
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = r5.getPromoCode()
            goto L_0x004d
        L_0x004c:
            r5 = r4
        L_0x004d:
            if (r2 == 0) goto L_0x01d2
            if (r5 == 0) goto L_0x0208
            java.lang.String r8 = r2.getPromoStatus()
            java.lang.String r9 = "Success"
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r7)
            if (r8 == 0) goto L_0x01d2
            java.lang.String r8 = r19.getCode()
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r7)
            if (r5 == 0) goto L_0x01d2
            java.lang.String r1 = r19.getCode()
            java.lang.String r5 = "promoCode.code"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.v = r1
            net.one97.paytm.recharge.common.c.c r1 = r0.w     // Catch:{ IllegalStateException -> 0x0084 }
            if (r1 == 0) goto L_0x007a
            androidx.fragment.app.j r4 = r1.getFragmentManager()     // Catch:{ IllegalStateException -> 0x0084 }
        L_0x007a:
            if (r4 == 0) goto L_0x0085
            net.one97.paytm.recharge.common.c.c r1 = r0.w     // Catch:{ IllegalStateException -> 0x0084 }
            if (r1 == 0) goto L_0x0085
            r1.dismissAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
        L_0x0085:
            net.one97.paytm.recharge.common.utils.t r1 = new net.one97.paytm.recharge.common.utils.t
            r4 = r0
            android.app.Activity r4 = (android.app.Activity) r4
            r1.<init>(r4)
            r1.a()
            java.lang.String r1 = r19.getPromoText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00b5
            net.one97.paytm.recharge.ordersummary.h.d r8 = r0.K
            if (r8 == 0) goto L_0x00b5
            java.lang.String r9 = r0.L
            java.lang.String r12 = r19.getCode()
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 112(0x70, float:1.57E-43)
            java.lang.String r10 = "apply_promocode_success"
            java.lang.String r11 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x00b5:
            android.view.View r1 = r0.p
            if (r1 == 0) goto L_0x00bc
            r1.setVisibility(r3)
        L_0x00bc:
            android.widget.TextView r1 = r0.r
            r4 = 8
            if (r1 == 0) goto L_0x00c5
            r1.setVisibility(r4)
        L_0x00c5:
            android.widget.TextView r1 = r0.q
            if (r1 == 0) goto L_0x00d6
            java.lang.String r5 = r19.getCode()
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x00d6:
            net.one97.paytm.recharge.creditcard.widget.CustomAmountTextInputEditTextV8 r1 = r0.n
            if (r1 == 0) goto L_0x00dd
            r1.clearFocus()
        L_0x00dd:
            java.util.ArrayList r1 = r2.getCartItems()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x015c
            java.util.ArrayList r1 = r2.getCartItems()
            java.lang.String r5 = "cart.cartItems"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r5 = 0
        L_0x00f7:
            if (r5 >= r1) goto L_0x015c
            java.util.ArrayList r8 = r2.getCartItems()
            java.lang.Object r8 = r8.get(r5)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r8 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r8
            java.lang.String r8 = r8.getmPromoStatus()
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r6, (boolean) r7)
            if (r8 == 0) goto L_0x0159
            java.util.ArrayList r1 = r2.getCartItems()
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r6 = "cart.cartItems[i]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r1 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r1
            java.lang.String r1 = r1.getPromoCode()
            java.lang.String r8 = "cart.cartItems[i].promoCode"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            android.widget.TextView r8 = r0.A
            if (r8 == 0) goto L_0x0130
            android.text.method.MovementMethod r9 = android.text.method.LinkMovementMethod.getInstance()
            r8.setMovementMethod(r9)
        L_0x0130:
            android.widget.TextView r8 = r0.A
            if (r8 == 0) goto L_0x014a
            java.util.ArrayList r2 = r2.getCartItems()
            java.lang.Object r2 = r2.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2
            java.lang.String r2 = r2.getPromoText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8.setText(r2)
        L_0x014a:
            android.widget.TextView r2 = r0.A
            if (r2 == 0) goto L_0x0151
            r2.setHighlightColor(r3)
        L_0x0151:
            android.widget.TextView r2 = r0.A
            if (r2 == 0) goto L_0x015f
            r2.clearFocus()
            goto L_0x015f
        L_0x0159:
            int r5 = r5 + 1
            goto L_0x00f7
        L_0x015c:
            java.lang.String r1 = ""
            r7 = 0
        L_0x015f:
            kotlin.o r2 = new kotlin.o
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)
            r2.<init>(r5, r1)
            java.lang.Object r1 = r2.getFirst()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.Object r2 = r2.getSecond()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r5 = r19.getTerms()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01c0
            if (r1 == 0) goto L_0x01c0
            android.widget.TextView r1 = r0.A
            if (r1 == 0) goto L_0x018d
            r1.setVisibility(r3)
        L_0x018d:
            android.view.View r1 = r0.s
            if (r1 != 0) goto L_0x0194
            kotlin.g.b.k.a()
        L_0x0194:
            r1.setVisibility(r3)
            net.one97.paytm.recharge.common.c.d r1 = r0.z
            if (r1 != 0) goto L_0x01a2
            net.one97.paytm.recharge.common.c.d r1 = new net.one97.paytm.recharge.common.c.d
            r1.<init>()
            r0.z = r1
        L_0x01a2:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r3 = "tnc_title"
            r1.putString(r3, r2)
            java.lang.String r2 = r19.getTerms()
            java.lang.String r3 = "tnc_text"
            r1.putString(r3, r2)
            net.one97.paytm.recharge.common.c.d r0 = r0.z
            if (r0 != 0) goto L_0x01bc
            kotlin.g.b.k.a()
        L_0x01bc:
            r0.setArguments(r1)
            return
        L_0x01c0:
            android.widget.TextView r1 = r0.A
            if (r1 == 0) goto L_0x01c7
            r1.setVisibility(r4)
        L_0x01c7:
            android.view.View r0 = r0.s
            if (r0 != 0) goto L_0x01ce
            kotlin.g.b.k.a()
        L_0x01ce:
            r0.setVisibility(r4)
            return
        L_0x01d2:
            net.one97.paytm.recharge.ordersummary.h.d r5 = r0.K     // Catch:{ all -> 0x0208 }
            if (r5 == 0) goto L_0x0208
            java.lang.String r6 = r0.L     // Catch:{ all -> 0x0208 }
            java.lang.String r7 = "apply_promocode_failed"
            java.lang.String r8 = ""
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0208 }
            r0.<init>()     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = r19.getCode()     // Catch:{ all -> 0x0208 }
            r0.append(r2)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = "/"
            r0.append(r2)     // Catch:{ all -> 0x0208 }
            if (r1 == 0) goto L_0x01f9
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()     // Catch:{ all -> 0x0208 }
            if (r1 == 0) goto L_0x01f9
            java.lang.String r4 = r1.getPromoFailureText()     // Catch:{ all -> 0x0208 }
        L_0x01f9:
            r0.append(r4)     // Catch:{ all -> 0x0208 }
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0208 }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 112(0x70, float:1.57E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0208 }
        L_0x0208:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity.a(net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity, net.one97.paytm.common.entity.CJRRechargeCart, net.one97.paytm.common.entity.shopping.CJROfferCode):void");
    }
}
