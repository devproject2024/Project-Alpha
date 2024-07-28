package net.one97.paytm.wifi.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wifi.R;
import net.one97.paytm.wifi.models.WifiPlan;

public final class WifiDataPlansActivity extends WifiBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21247a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private List<WifiPlan> f21248c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.wifi.ui.a.b f21249d;

    /* renamed from: e  reason: collision with root package name */
    private CJRRechargeCart f21250e;

    /* renamed from: f  reason: collision with root package name */
    private String f21251f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f21252g;

    public final View a(int i2) {
        if (this.f21252g == null) {
            this.f21252g = new HashMap();
        }
        View view = (View) this.f21252g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f21252g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends l implements kotlin.g.a.b<WifiPlan, x> {
        final /* synthetic */ WifiDataPlansActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(WifiDataPlansActivity wifiDataPlansActivity) {
            super(1);
            this.this$0 = wifiDataPlansActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((WifiPlan) obj);
            return x.f47997a;
        }

        public final void invoke(WifiPlan wifiPlan) {
            k.c(wifiPlan, "it");
            WifiDataPlansActivity.a(this.this$0, wifiPlan);
        }
    }

    public final int a() {
        return R.layout.activity_wifi_data_plans;
    }

    public final int b() {
        return R.layout.wifi_empty_toolbar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null) {
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                if (intent2.getExtras().containsKey("key_wifi_plans")) {
                    Intent intent3 = getIntent();
                    k.a((Object) intent3, "intent");
                    if (intent3.getExtras().containsKey("key_wifi_ssid")) {
                        Intent intent4 = getIntent();
                        k.a((Object) intent4, "intent");
                        if (intent4.getExtras().containsKey("key_cart_item")) {
                            Intent intent5 = getIntent();
                            k.a((Object) intent5, "intent");
                            ArrayList parcelableArrayList = intent5.getExtras().getParcelableArrayList("key_wifi_plans");
                            k.a((Object) parcelableArrayList, "intent.extras.getParcela…ArrayList(KEY_WIFI_PLANS)");
                            this.f21248c = parcelableArrayList;
                            Intent intent6 = getIntent();
                            k.a((Object) intent6, "intent");
                            String string = intent6.getExtras().getString("key_wifi_ssid", "");
                            k.a((Object) string, "intent.extras.getString(KEY_WIFI_SSID, \"\")");
                            this.f21251f = string;
                            Intent intent7 = getIntent();
                            k.a((Object) intent7, "intent");
                            Serializable serializable = intent7.getExtras().getSerializable("key_cart_item");
                            if (serializable != null) {
                                this.f21250e = (CJRRechargeCart) serializable;
                                RecyclerView recyclerView = (RecyclerView) a(R.id.listView);
                                k.a((Object) recyclerView, "listView");
                                Context context = this;
                                recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
                                List<WifiPlan> list = this.f21248c;
                                if (list == null) {
                                    k.a("planList");
                                }
                                this.f21249d = new net.one97.paytm.wifi.ui.a.b(context, list, new c(this));
                                RecyclerView recyclerView2 = (RecyclerView) a(R.id.listView);
                                k.a((Object) recyclerView2, "listView");
                                net.one97.paytm.wifi.ui.a.b bVar = this.f21249d;
                                if (bVar == null) {
                                    k.a("listAdapter");
                                }
                                recyclerView2.setAdapter(bVar);
                                RoboTextView roboTextView = (RoboTextView) a(R.id.tvTitle);
                                k.a((Object) roboTextView, "tvTitle");
                                String str = this.f21251f;
                                if (str == null) {
                                    k.a("ssid");
                                }
                                roboTextView.setText(str);
                                c();
                                return;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("Must pass key_wifi_plans & key_wifi_ssid");
    }

    public static final class b implements net.one97.paytm.wifi.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDataPlansActivity f21253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WifiPlan f21254b;

        b(WifiDataPlansActivity wifiDataPlansActivity, WifiPlan wifiPlan) {
            this.f21253a = wifiDataPlansActivity;
            this.f21254b = wifiPlan;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            androidx.lifecycle.k lifecycle = this.f21253a.getLifecycle();
            k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                this.f21253a.c();
                if (networkCustomError != null) {
                    if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (p.a(networkCustomError.getMessage(), "410", true) || p.a(networkCustomError.getMessage(), UpiUtils.AUTHENTICATION_FAILURE_401, true))) {
                        kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
                        net.one97.paytm.wifi.a.c().handleError(this.f21253a, networkCustomError, (String) null, (Bundle) null, true);
                    } else if (networkCustomError.getMessage() != null) {
                        kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
                        if (net.one97.paytm.wifi.a.c().reportError(this.f21253a, networkCustomError, "error.utilities@paytm.com")) {
                            return;
                        }
                        if (networkCustomError.getMessage() == null || !p.a(networkCustomError.getMessage(), "parsing_error", true)) {
                            WifiDataPlansActivity wifiDataPlansActivity = this.f21253a;
                            com.paytm.utility.b.b((Context) wifiDataPlansActivity, wifiDataPlansActivity.getResources().getString(R.string.network_error_heading_re), this.f21253a.getResources().getString(R.string.network_error_heading_re) + " " + networkCustomError.getUrl());
                            return;
                        }
                        com.paytm.utility.b.d((Context) this.f21253a, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                    }
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            androidx.lifecycle.k lifecycle = this.f21253a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRRechargePayment)) {
                    this.f21253a.c();
                    Snackbar a2 = Snackbar.a((View) (RecyclerView) this.f21253a.a(R.id.listView), R.string.fetch_data_plans_error, -2);
                    kotlin.g.b.k.a((Object) a2, "Snackbar.make(listView,\n…ackbar.LENGTH_INDEFINITE)");
                    kotlin.g.b.k.a((Object) a2.a(R.string.retry, (View.OnClickListener) new a(this, a2)), "snake.setAction(R.string…                        }");
                    return;
                }
                WifiDataPlansActivity.a(this.f21253a, (CJRRechargePayment) iJRPaytmDataModel);
            }
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f21255a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Snackbar f21256b;

            a(b bVar, Snackbar snackbar) {
                this.f21255a = bVar;
                this.f21256b = snackbar;
            }

            public final void onClick(View view) {
                this.f21256b.d();
                WifiDataPlansActivity.a(this.f21255a.f21253a, this.f21255a.f21254b);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.progressRootLayout);
        kotlin.g.b.k.a((Object) frameLayout, "progressRootLayout");
        net.one97.paytm.wifi.ui.b.b.b(frameLayout);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loaderView));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(WifiDataPlansActivity wifiDataPlansActivity, WifiPlan wifiPlan) {
        FrameLayout frameLayout = (FrameLayout) wifiDataPlansActivity.a(R.id.progressRootLayout);
        kotlin.g.b.k.a((Object) frameLayout, "progressRootLayout");
        net.one97.paytm.wifi.ui.b.b.a(frameLayout);
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) wifiDataPlansActivity.a(R.id.loaderView));
        Context applicationContext = wifiDataPlansActivity.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        net.one97.paytm.wifi.b.a aVar = new net.one97.paytm.wifi.b.a(applicationContext);
        CJRRechargeCart cJRRechargeCart = wifiDataPlansActivity.f21250e;
        if (cJRRechargeCart == null) {
            kotlin.g.b.k.a("cart");
        }
        aVar.a(cJRRechargeCart, wifiPlan, new b(wifiDataPlansActivity, wifiPlan));
    }

    public static final /* synthetic */ void a(WifiDataPlansActivity wifiDataPlansActivity, CJRRechargePayment cJRRechargePayment) {
        wifiDataPlansActivity.c();
        if (cJRRechargePayment.getStatus() == null || !p.a(cJRRechargePayment.getStatus(), "SUCCESS", true)) {
            wifiDataPlansActivity.c();
            if (cJRRechargePayment.getCode() == 401 || cJRRechargePayment.getCode() == 410 || cJRRechargePayment.getCode() == 403) {
                NetworkCustomError networkCustomError = new NetworkCustomError();
                kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
                net.one97.paytm.wifi.b c2 = net.one97.paytm.wifi.a.c();
                kotlin.g.b.k.a((Object) c2, "WifiController.getInstance().wifiEventListener");
                if (!TextUtils.isEmpty(c2.getCartCheckoutUrl())) {
                    kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
                    net.one97.paytm.wifi.b c3 = net.one97.paytm.wifi.a.c();
                    kotlin.g.b.k.a((Object) c3, "WifiController.getInstance().wifiEventListener");
                    networkCustomError.setUrl(c3.getCartCheckoutUrl());
                    if (cJRRechargePayment.getError() != null) {
                        CJRError error = cJRRechargePayment.getError();
                        kotlin.g.b.k.a((Object) error, "rechargePayment.error");
                        if (!TextUtils.isEmpty(error.getMessage())) {
                            CJRError error2 = cJRRechargePayment.getError();
                            kotlin.g.b.k.a((Object) error2, "rechargePayment.error");
                            networkCustomError.setAlertMessage(error2.getMessage());
                        }
                    }
                }
                kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
                net.one97.paytm.wifi.b c4 = net.one97.paytm.wifi.a.c();
                if (wifiDataPlansActivity != null) {
                    c4.showSessionTimeoutAlert(wifiDataPlansActivity, (String) null, (Bundle) null, networkCustomError);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } else if (cJRRechargePayment.getError() != null) {
                CJRError error3 = cJRRechargePayment.getError();
                kotlin.g.b.k.a((Object) error3, "rechargePayment.error");
                String title = error3.getTitle();
                CJRError error4 = cJRRechargePayment.getError();
                kotlin.g.b.k.a((Object) error4, "rechargePayment.error");
                com.paytm.utility.b.b((Context) wifiDataPlansActivity, title, error4.getMessage());
            } else {
                com.paytm.utility.b.b((Context) wifiDataPlansActivity, wifiDataPlansActivity.getResources().getString(R.string.error), wifiDataPlansActivity.getResources().getString(R.string.msg_invalid_url));
            }
        } else {
            q.d("Direct transaction");
            Intent intent = new Intent();
            intent.putExtra("price", cJRRechargePayment.getTxnAmount());
            intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
            try {
                CJRRechargeCart cJRRechargeCart = wifiDataPlansActivity.f21250e;
                if (cJRRechargeCart == null) {
                    kotlin.g.b.k.a("cart");
                }
                if (cJRRechargeCart.getCart() != null) {
                    CJRRechargeCart cJRRechargeCart2 = wifiDataPlansActivity.f21250e;
                    if (cJRRechargeCart2 == null) {
                        kotlin.g.b.k.a("cart");
                    }
                    CJRCart cart = cJRRechargeCart2.getCart();
                    kotlin.g.b.k.a((Object) cart, "cart.cart");
                    if (cart.getCartItems() != null) {
                        CJRRechargeCart cJRRechargeCart3 = wifiDataPlansActivity.f21250e;
                        if (cJRRechargeCart3 == null) {
                            kotlin.g.b.k.a("cart");
                        }
                        CJRCart cart2 = cJRRechargeCart3.getCart();
                        kotlin.g.b.k.a((Object) cart2, "cart.cart");
                        if (cart2.getCartItems().size() > 0) {
                            CJRRechargeCart cJRRechargeCart4 = wifiDataPlansActivity.f21250e;
                            if (cJRRechargeCart4 == null) {
                                kotlin.g.b.k.a("cart");
                            }
                            CJRCart cart3 = cJRRechargeCart4.getCart();
                            kotlin.g.b.k.a((Object) cart3, "cart.cart");
                            CJRCartProduct cJRCartProduct = cart3.getCartItems().get(0);
                            kotlin.g.b.k.a((Object) cJRCartProduct, "cart.cart.cartItems[0]");
                            String verticalLabel = cJRCartProduct.getVerticalLabel();
                            if (verticalLabel != null) {
                                intent.putExtra(UpiConstants.FROM, verticalLabel);
                            } else {
                                intent.putExtra(UpiConstants.FROM, SDKConstants.GA_KEY_DEFAULT);
                            }
                            CJRRechargeCart cJRRechargeCart5 = wifiDataPlansActivity.f21250e;
                            if (cJRRechargeCart5 == null) {
                                kotlin.g.b.k.a("cart");
                            }
                            CJRCart cart4 = cJRRechargeCart5.getCart();
                            kotlin.g.b.k.a((Object) cart4, "cart.cart");
                            CJRCartProduct cJRCartProduct2 = cart4.getCartItems().get(0);
                            kotlin.g.b.k.a((Object) cJRCartProduct2, "cart.cart.cartItems[0]");
                            intent.putExtra("vertical_id", cJRCartProduct2.getLastItemInCategoryMap());
                        }
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
            kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
            net.one97.paytm.wifi.a.c().startRechargePaymentActivity(wifiDataPlansActivity, intent, cJRRechargePayment);
            wifiDataPlansActivity.finish();
        }
    }
}
