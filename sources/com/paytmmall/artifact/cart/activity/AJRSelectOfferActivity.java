package com.paytmmall.artifact.cart.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.a.a;
import com.paytmmall.artifact.cart.c.b;
import com.paytmmall.artifact.cart.c.c;
import com.paytmmall.artifact.cart.c.d;
import com.paytmmall.artifact.cart.entity.CJRDetailProduct;
import com.paytmmall.artifact.cart.entity.CJREMIProductPromoInfo;
import com.paytmmall.artifact.cart.entity.CJREMIProductReviewDetails;
import com.paytmmall.artifact.cart.entity.CJRFilterItem;
import com.paytmmall.artifact.cart.entity.CJRFilterValue;
import com.paytmmall.artifact.cart.entity.CJROffers;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.d.f;
import com.paytmmall.artifact.d.g;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.v;
import com.paytmmall.artifact.widget.CJRFlowLayout;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public class AJRSelectOfferActivity extends BaseActivity implements b, c, d {
    private String A;
    private String B;
    private boolean C;
    private CJREMIProductReviewDetails D;
    private CJRShoppingCart E;
    private boolean F = false;

    /* renamed from: a  reason: collision with root package name */
    private String f15481a = "AJRSelectOfferActivity";

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f15482b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJROffers f15483c;

    /* renamed from: d  reason: collision with root package name */
    private String f15484d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f15485e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f15486f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f15487g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f15488h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f15489i;
    private String j;
    /* access modifiers changed from: private */
    public ImageView k;
    private CJRShoppingCart l;
    private a m;
    private int n;
    private boolean o;
    private String p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public String r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private WishListProduct w;
    /* access modifiers changed from: private */
    public RelativeLayout x;
    private boolean y;
    private String z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_select_offer_layout_new);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.e(R.drawable.mall_back_arrow_order_detail);
        }
        this.f15487g = (TextView) findViewById(R.id.txt_choose_offer);
        this.f15482b = (RecyclerView) findViewById(R.id.recycler_view_offers);
        this.f15485e = (RelativeLayout) findViewById(R.id.apply_btn_lyt);
        this.f15486f = (RelativeLayout) findViewById(R.id.promocode_lyt);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_enter_promo);
        this.f15488h = (EditText) findViewById(R.id.edit_txt_promocode);
        this.k = (ImageView) findViewById(R.id.promo_remove_image);
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSelectOfferActivity.this.c(view);
            }
        });
        this.f15482b.setLayoutManager(new LinearLayoutManager(this));
        this.x = (RelativeLayout) findViewById(R.id.wishlist_product_filter_container);
        setTitle(getString(R.string.apply_promo_offer));
        this.f15489i = (TextView) findViewById(R.id.txt_error);
        this.f15485e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSelectOfferActivity.this.b(view);
            }
        });
        com.paytmmall.artifact.common.a.a.a();
        ((TextView) findViewById(R.id.wallet_loyality_cash_back_text)).setText(com.paytmmall.artifact.common.a.a.a("cashbackInfoMessage", (String) null));
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("offers_url")) {
                this.p = (String) extras.get("offers_url");
            }
            if (extras.containsKey(CLPConstants.ARGUMENT_KEY_POSITION)) {
                this.n = ((Integer) extras.get(CLPConstants.ARGUMENT_KEY_POSITION)).intValue();
            }
            if (extras.containsKey(CLPConstants.PRODUCT_ID)) {
                this.q = (String) extras.get(CLPConstants.PRODUCT_ID);
            }
            if (extras.containsKey(CLPConstants.BRAND_PARAMS)) {
                this.z = (String) extras.get(CLPConstants.BRAND_PARAMS);
            }
            if (extras.containsKey("product_name")) {
                this.A = (String) extras.get("product_name");
            }
            if (extras.containsKey("category_name")) {
                this.B = (String) extras.get("category_name");
            }
            if (extras.containsKey(f.f15705c)) {
                this.s = ((Boolean) extras.get(f.f15705c)).booleanValue();
            }
            if (extras.containsKey("applied_promo")) {
                this.f15484d = extras.getString("applied_promo");
            }
            if (extras.containsKey("is_from_grid")) {
                this.t = ((Boolean) extras.get("is_from_grid")).booleanValue();
            }
            if (extras.containsKey("is_complex_product")) {
                this.u = ((Boolean) extras.get("is_complex_product")).booleanValue();
            }
            if (extras.containsKey("is_in_stock")) {
                this.v = ((Boolean) extras.get("is_in_stock")).booleanValue();
            }
            if (!this.t) {
                if (!this.s && extras.containsKey("wish_list_item")) {
                    this.w = (WishListProduct) extras.get("wish_list_item");
                }
                if (extras.containsKey("express_cart_bean")) {
                    this.D = (CJREMIProductReviewDetails) extras.getSerializable("express_cart_bean");
                    this.C = true;
                }
            }
        }
        if (!this.s && !this.C) {
            this.f15486f.setVisibility(8);
            relativeLayout.setVisibility(8);
            setTitle(getString(R.string.offer_title));
        }
        this.f15488h.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    AJRSelectOfferActivity.a(AJRSelectOfferActivity.this, false);
                    return;
                }
                AJRSelectOfferActivity.this.a(false, (String) null);
                AJRSelectOfferActivity.this.k.setVisibility(0);
                AJRSelectOfferActivity.a(AJRSelectOfferActivity.this, true);
            }
        });
        this.f15486f.getLayoutParams().height = (int) (((double) com.paytmmall.artifact.d.c.h((Context) this)) * 2.5d);
        d();
        findViewById(R.id.lyt_cashback_info).setOnClickListener($$Lambda$AJRSelectOfferActivity$FCtqVhWV7HM4BIGEIk16NQEg0s.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f15488h.setText("");
        a(false, (String) null);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            j();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void d() {
        com.paytmmall.artifact.d.d.a((Activity) this, getString(R.string.please_wait_progress_msg));
        com.paytmmall.artifact.common.a.a.a();
        String a2 = com.paytmmall.artifact.common.a.a.a("cartPublicAPI", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            final String b2 = g.b(a2 + this.p, this);
            com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, b2, (String) null, com.paytmmall.artifact.d.d.a((HashMap<String, String>) new HashMap(), (Context) this), new CJROffers(), new com.paytmmall.b.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    com.paytmmall.artifact.d.d.h();
                    CJROffers cJROffers = (CJROffers) iJRPaytmDataModel;
                    if (cJROffers == null || cJROffers.getOfferCodes().size() <= 0) {
                        AJRSelectOfferActivity.c(AJRSelectOfferActivity.this);
                    } else {
                        CJROffers unused = AJRSelectOfferActivity.this.f15483c = cJROffers;
                    }
                    AJRSelectOfferActivity.d(AJRSelectOfferActivity.this);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSelectOfferActivity.c(AJRSelectOfferActivity.this);
                    AJRSelectOfferActivity.this.f15487g.setVisibility(8);
                    com.paytmmall.artifact.d.d.h();
                    AJRSelectOfferActivity.this.a(networkCustomError, b2);
                }
            });
        }
    }

    public final void a() {
        com.paytmmall.artifact.cart.b.a aVar = new com.paytmmall.artifact.cart.b.a(getApplicationContext());
        String a2 = aVar.a();
        if (!URLUtil.isValidUrl(a2)) {
            a(true, getString(R.string.msg_invalid_url));
        } else if (com.paytmmall.artifact.d.d.a((Context) this)) {
            com.paytmmall.artifact.d.d.a((Activity) this, getString(R.string.please_wait_progress_msg));
            try {
                if (!this.u || !this.y) {
                    aVar.a((b) this, this.f15484d, a2, this.q);
                } else {
                    aVar.a((b) this, this.f15484d, a2, this.r);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        } else {
            com.paytmmall.artifact.d.d.h();
            a(true, getString(R.string.no_internet));
        }
    }

    public final void b() {
        this.o = true;
        this.f15484d = null;
        l.c((String) null);
        com.paytmmall.artifact.d.d.h();
        d();
    }

    public final void a(NetworkCustomError networkCustomError) {
        a(networkCustomError, "");
    }

    public final void b(NetworkCustomError networkCustomError) {
        a(networkCustomError, "");
    }

    private void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("parent_activity", AJRShoppingCartActivity.class.getName());
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("sign_in_title", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("sign_up_title", str2);
        }
        intent.putExtra("set_result_required", true);
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        t.e().resolveIntentByMainApp(this, intent, "authActivity", 111);
    }

    /* access modifiers changed from: private */
    public void a(NetworkCustomError networkCustomError, String str) {
        this.f15485e.setEnabled(true);
        com.paytmmall.artifact.d.d.h();
        String alertMessage = networkCustomError.getAlertMessage();
        if (!isFinishing()) {
            if (!TextUtils.isEmpty(alertMessage) && (alertMessage.equalsIgnoreCase("410") || alertMessage.equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                com.paytmmall.artifact.d.d.a((Activity) this, networkCustomError, AJRShoppingCartActivity.class.getName(), str);
            }
            if (!TextUtils.isEmpty(alertMessage) && alertMessage.equalsIgnoreCase("449")) {
                a(true, alertMessage);
                a(getResources().getString(R.string.sign_in_apply_promo_code), getResources().getString(R.string.sign_up_apply_promo_code));
            } else if (!TextUtils.isEmpty(alertMessage) && alertMessage.equals("failure_error")) {
                a(true, alertMessage);
            } else if (!TextUtils.isEmpty(alertMessage)) {
                a(true, alertMessage);
            }
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        l.c(this.j);
        this.o = true;
        this.f15485e.setEnabled(true);
        com.paytmmall.artifact.d.d.h();
        if (iJRPaytmDataModel instanceof CJRShoppingCart) {
            this.l = (CJRShoppingCart) iJRPaytmDataModel;
            if (this.l.getCart() != null) {
                this.f15484d = this.l.getCart().getPromoCode();
            }
        }
        j();
    }

    public final void a(String str) {
        this.f15485e.setEnabled(false);
        this.F = true;
        this.j = str;
        if (this.C) {
            b(str);
        } else if (this.s) {
            d(str);
        } else {
            e();
        }
    }

    private void b(String str) {
        CJREMIProductPromoInfo cJREMIProductPromoInfo = new CJREMIProductPromoInfo();
        cJREMIProductPromoInfo.setAppliedPromoCode(str);
        this.D.setProductPromoInfo(cJREMIProductPromoInfo);
        com.paytmmall.artifact.cart.b.c cVar = new com.paytmmall.artifact.cart.b.c();
        CJREMIProductReviewDetails cJREMIProductReviewDetails = this.D;
        cVar.a(this, this, cJREMIProductReviewDetails, cJREMIProductReviewDetails.getMiddleWareUrl());
    }

    private void e() {
        if (!this.v) {
            c(getString(R.string.cart_oos_item));
        } else if (!this.u || this.y) {
            h();
        } else {
            f();
        }
    }

    private void f() {
        WishListProduct wishListProduct = this.w;
        if (wishListProduct != null && wishListProduct.getUrl() != null) {
            g();
        }
    }

    private void g() {
        String url;
        if (!TextUtils.isEmpty(this.w.getUrl()) && (url = this.w.getUrl()) != null) {
            com.paytmmall.artifact.d.d.a((Context) this, url);
            com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, this.w.getUrl(), (String) null, (Map<String, String>) null, new CJRDetailProduct(), new com.paytmmall.b.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    CJRDetailProduct cJRDetailProduct = (CJRDetailProduct) iJRPaytmDataModel;
                    if (!cJRDetailProduct.getFilterList().isEmpty()) {
                        AJRSelectOfferActivity.this.findViewById(R.id.wishlist_product_filter_container).setVisibility(0);
                        AJRSelectOfferActivity.this.x.startAnimation(AnimationUtils.loadAnimation(AJRSelectOfferActivity.this, R.anim.mall_bottom_bar_slide_up));
                        String unused = AJRSelectOfferActivity.this.r = cJRDetailProduct.getItemId();
                        AJRSelectOfferActivity.a(AJRSelectOfferActivity.this, (ArrayList) cJRDetailProduct.getFilterList());
                    }
                }
            });
        }
    }

    private void a(CJRFlowLayout cJRFlowLayout, CJRFilterItem cJRFilterItem, TextView textView, TextView textView2, RelativeLayout relativeLayout, CJRFlowLayout cJRFlowLayout2) {
        cJRFlowLayout.removeAllViews();
        relativeLayout.setOnClickListener(new View.OnClickListener(textView2) {
            private final /* synthetic */ TextView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AJRSelectOfferActivity.a(CJRFlowLayout.this, this.f$1, view);
            }
        });
        textView.setText(cJRFilterItem.getDisplayValue());
        Iterator<CJRFilterValue> it2 = cJRFilterItem.getFilterValues().iterator();
        while (it2.hasNext()) {
            CJRFilterValue next = it2.next();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mall_layout_pdp_filter_option_item, (ViewGroup) null, false);
            ((TextView) linearLayout.findViewById(R.id.txt_filter_name)).setText(next.getName());
            linearLayout.setOnClickListener(new View.OnClickListener((LinearLayout) linearLayout.findViewById(R.id.lyt_filter_option_btn_container), cJRFlowLayout, textView2, next) {
                private final /* synthetic */ LinearLayout f$1;
                private final /* synthetic */ CJRFlowLayout f$2;
                private final /* synthetic */ TextView f$3;
                private final /* synthetic */ CJRFilterValue f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void onClick(View view) {
                    AJRSelectOfferActivity.this.a(this.f$1, this.f$2, this.f$3, this.f$4, view);
                }
            });
            cJRFlowLayout.addView(linearLayout);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(CJRFlowLayout cJRFlowLayout, TextView textView, View view) {
        if (cJRFlowLayout.getVisibility() == 8) {
            cJRFlowLayout.setVisibility(0);
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(LinearLayout linearLayout, CJRFlowLayout cJRFlowLayout, TextView textView, CJRFilterValue cJRFilterValue, View view) {
        if (!linearLayout.isSelected()) {
            for (int i2 = 0; i2 < cJRFlowLayout.getChildCount(); i2++) {
                ((LinearLayout) cJRFlowLayout.getChildAt(i2)).findViewById(R.id.lyt_filter_option_btn_container).setSelected(false);
            }
            textView.setText(cJRFilterValue.getName());
            linearLayout.setSelected(true);
            textView.setVisibility(0);
            cJRFlowLayout.setVisibility(8);
            this.y = true;
            e();
        }
    }

    private void c(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setNegativeButton(getResources().getString(R.string.ok), $$Lambda$AJRSelectOfferActivity$RSQJTVCIaME0Q0A406vthugbTQI.INSTANCE);
        builder.show();
    }

    private void h() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Html.fromHtml(String.format(getString(R.string.wishlist_apply_promo_msg), new Object[]{this.j}))).setCancelable(false);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                AJRSelectOfferActivity.this.i();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void i() {
        com.paytmmall.artifact.d.d.a((Activity) this, getString(R.string.please_wait_progress_msg));
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = com.paytmmall.artifact.d.d.a((HashMap<String, String>) hashMap, (Context) this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "update");
            JSONObject jSONObject2 = new JSONObject();
            if (this.u) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, this.r);
            } else {
                jSONObject2.put(CLPConstants.PRODUCT_ID, this.q);
            }
            jSONObject2.put("quantity", 1);
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject2.put(Utility.EVENT_CATEGORY_PROMOCODE, this.j);
            }
            jSONObject.put("object", jSONObject2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        com.paytmmall.artifact.common.a.a.a();
        String a3 = com.paytmmall.artifact.common.a.a.a("cartv2", (String) null);
        if (!TextUtils.isEmpty(a3)) {
            final String str = (a3 + "/" + l.b()) + g.a((Context) this);
            com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.POST, str, jSONObject.toString(), a2, new StringModel(), new com.paytmmall.b.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    String data = ((StringModel) iJRPaytmDataModel).getData();
                    if (!TextUtils.isEmpty(data)) {
                        v a2 = v.a();
                        a2.a((Context) AJRSelectOfferActivity.this, data);
                        CJRShoppingCart cJRShoppingCart = a2.f15746a;
                        if (cJRShoppingCart.getCart() != null && !cJRShoppingCart.getCart().getCartItems().isEmpty()) {
                            l.a(cJRShoppingCart.getCart().getCartItems().size());
                            l.b(cJRShoppingCart.getCart().getFinalPrice());
                            com.paytmmall.artifact.cart.d.c.a(AJRSelectOfferActivity.this, new com.paytmmall.b.b() {
                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                }

                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    AJRSelectOfferActivity aJRSelectOfferActivity = AJRSelectOfferActivity.this;
                                    com.paytmmall.artifact.cart.d.a.c(aJRSelectOfferActivity, aJRSelectOfferActivity.q);
                                    AJRSelectOfferActivity.this.j();
                                }
                            }, AJRSelectOfferActivity.this.q);
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSelectOfferActivity.this.a(networkCustomError, str);
                }
            });
        }
    }

    private void d(String str) {
        com.paytmmall.artifact.d.d.a((Activity) this, getString(R.string.please_wait_progress_msg));
        com.paytmmall.artifact.cart.b.a aVar = new com.paytmmall.artifact.cart.b.a(getApplicationContext());
        String a2 = aVar.a();
        if (!URLUtil.isValidUrl(a2)) {
            a(true, getString(R.string.msg_invalid_url));
        } else if (com.paytmmall.artifact.d.d.a((Context) this)) {
            try {
                if (!this.u || !this.y) {
                    aVar.a(str, (b) this, a2, this.q);
                } else {
                    aVar.a(str, (b) this, a2, this.r);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
                a(true, e2.getMessage());
            }
        } else {
            com.paytmmall.artifact.d.d.h();
            a(true, getString(R.string.no_internet));
        }
    }

    public void onBackPressed() {
        j();
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public void j() {
        WishListProduct wishListProduct;
        if (!this.C) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("is_updated", Boolean.valueOf(this.o));
            bundle.putSerializable("cart_details", this.l);
            bundle.putSerializable("applied_promo", this.f15484d);
            if (!this.s && (wishListProduct = this.w) != null) {
                bundle.putSerializable("item_name", wishListProduct.getName());
            }
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        } else if (this.E != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("express_cart_bean", this.E);
            setResult(-1, intent2);
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 111) {
            com.paytmmall.artifact.cart.b.a aVar = new com.paytmmall.artifact.cart.b.a(this);
            String a2 = aVar.a();
            a(false, "");
            if (URLUtil.isValidUrl(a2)) {
                try {
                    aVar.a(this.j, (b) this, a2, this.q);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                    a(true, e2.getMessage());
                }
            } else {
                a(true, getString(R.string.msg_invalid_url));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, String str) {
        if (z2) {
            this.f15485e.setVisibility(8);
            if (this.f15488h.getText().length() > 0) {
                this.k.setVisibility(0);
            }
            e(str);
            return;
        }
        this.f15489i.setVisibility(8);
        this.f15489i.setText((CharSequence) null);
        findViewById(R.id.view_divider).setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_promo_bg_color));
    }

    private void e(String str) {
        if (this.F) {
            b(this.j, str);
            this.f15489i.setVisibility(8);
            this.f15489i.setText((CharSequence) null);
            findViewById(R.id.view_divider).setBackgroundColor(androidx.core.content.b.c(this, R.color.cart_promo_bg_color));
            return;
        }
        b("", str);
        findViewById(R.id.view_divider).setBackgroundColor(androidx.core.content.b.c(this, R.color.color_blue));
        this.f15489i.setVisibility(0);
        this.f15489i.setText(str);
    }

    private void b(String str, String str2) {
        com.paytmmall.artifact.cart.a.a aVar = this.m;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public final void a(CJRShoppingCart cJRShoppingCart) {
        this.E = cJRShoppingCart;
        j();
    }

    public final void a(String str, CJRShoppingCart cJRShoppingCart) {
        this.f15485e.setEnabled(true);
        if (cJRShoppingCart != null) {
            this.E = cJRShoppingCart;
        }
        a(true, str);
    }

    public final void a(String str, String str2, String str3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_PROMO_REMOVE", false);
        bundle.putString("applied_promo", str);
        bundle.putString("cash_back", str2);
        bundle.putString("cashback_msg", str3);
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, this.n);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public final void c() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_PROMO_REMOVE", true);
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, this.n);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.F = false;
        if (this.C) {
            this.j = this.f15488h.getText().toString();
            b(this.f15488h.getText().toString());
        } else if (!this.t) {
            this.j = this.f15488h.getText().toString();
            if (this.s) {
                d(this.f15488h.getText().toString());
            } else {
                i();
            }
        }
    }

    static /* synthetic */ void a(AJRSelectOfferActivity aJRSelectOfferActivity, boolean z2) {
        if (z2) {
            aJRSelectOfferActivity.findViewById(R.id.ll_options).setVisibility(0);
            aJRSelectOfferActivity.f15485e.setVisibility(0);
            return;
        }
        aJRSelectOfferActivity.findViewById(R.id.ll_options).setVisibility(8);
        aJRSelectOfferActivity.f15485e.setVisibility(8);
    }

    static /* synthetic */ void c(AJRSelectOfferActivity aJRSelectOfferActivity) {
        aJRSelectOfferActivity.findViewById(R.id.no_offers_layout).setVisibility(0);
        aJRSelectOfferActivity.findViewById(R.id.view1).setVisibility(4);
        aJRSelectOfferActivity.findViewById(R.id.lyt_cashback_info).setVisibility(8);
        aJRSelectOfferActivity.findViewById(R.id.view2).setVisibility(8);
        aJRSelectOfferActivity.findViewById(R.id.txv_or).setVisibility(8);
    }

    static /* synthetic */ void d(AJRSelectOfferActivity aJRSelectOfferActivity) {
        CJROffers cJROffers = aJRSelectOfferActivity.f15483c;
        if (cJROffers != null && cJROffers.getOfferCodes() != null && aJRSelectOfferActivity.f15483c.getOfferCodes().size() > 0) {
            if (aJRSelectOfferActivity.m == null) {
                aJRSelectOfferActivity.f15487g.setVisibility(0);
                aJRSelectOfferActivity.m = new com.paytmmall.artifact.cart.a.a(aJRSelectOfferActivity.f15483c.getOfferCodes(), aJRSelectOfferActivity, aJRSelectOfferActivity, aJRSelectOfferActivity.f15484d, aJRSelectOfferActivity.s, aJRSelectOfferActivity.w, aJRSelectOfferActivity.t, aJRSelectOfferActivity, aJRSelectOfferActivity.C);
                aJRSelectOfferActivity.f15482b.setAdapter(aJRSelectOfferActivity.m);
                aJRSelectOfferActivity.f15482b.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        int i2 = com.paytmmall.artifact.d.d.i();
                        rect.set(i2, 0, i2, i2);
                    }
                });
                aJRSelectOfferActivity.f15482b.addOnScrollListener(new RecyclerView.l() {
                    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                        super.onScrollStateChanged(recyclerView, i2);
                    }
                });
                return;
            }
            aJRSelectOfferActivity.f15487g.setVisibility(8);
            com.paytmmall.artifact.cart.a.a aVar = aJRSelectOfferActivity.m;
            String promoCode = aJRSelectOfferActivity.l.getCart().getPromoCode();
            aVar.j = "";
            aVar.f15413e = promoCode;
            aVar.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(AJRSelectOfferActivity aJRSelectOfferActivity, ArrayList arrayList) {
        RelativeLayout relativeLayout = (RelativeLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_overlay_item_1);
        RelativeLayout relativeLayout2 = (RelativeLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_overlay_item_2);
        relativeLayout.setVisibility(8);
        relativeLayout2.setVisibility(8);
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.get(0) != null) {
                relativeLayout.setVisibility(0);
                aJRSelectOfferActivity.a((CJRFlowLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_type_1_options_container), (CJRFilterItem) arrayList.get(0), (TextView) aJRSelectOfferActivity.x.findViewById(R.id.filter_type_1), (TextView) aJRSelectOfferActivity.x.findViewById(R.id.filter_type_1_expand), (RelativeLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_overlay_item_1_header), (CJRFlowLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_type_1_options_container));
            }
            if (arrayList.size() <= 1 || arrayList.get(1) == null) {
                RelativeLayout relativeLayout3 = (RelativeLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_overlay_item_1_header);
                if (relativeLayout3 != null) {
                    relativeLayout3.performClick();
                    return;
                }
                return;
            }
            relativeLayout2.setVisibility(0);
            aJRSelectOfferActivity.a((CJRFlowLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_type_2_options_container), (CJRFilterItem) arrayList.get(1), (TextView) aJRSelectOfferActivity.x.findViewById(R.id.filter_type_2), (TextView) aJRSelectOfferActivity.x.findViewById(R.id.filter_type_2_expand), (RelativeLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_overlay_item_2_header), (CJRFlowLayout) aJRSelectOfferActivity.x.findViewById(R.id.lyt_filter_type_2_options_container));
        }
    }
}
