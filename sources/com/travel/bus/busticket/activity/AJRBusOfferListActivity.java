package com.travel.bus.busticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.a.l;
import com.travel.bus.busticket.i.o;
import com.travel.bus.pojo.busticket.CJRBlockOneResponse;
import com.travel.bus.pojo.busticket.CJRBusOffers;
import com.travel.bus.pojo.busticket.CJRBusRechargeCart;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import com.travel.bus.pojo.busticket.CJRNewTrainOffers;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRBusOfferListActivity extends PaytmActivity implements b, l.b {
    private String A;
    private CJRBlockOneResponse B;
    private ProgressDialog C;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;

    /* renamed from: a  reason: collision with root package name */
    private EditText f21847a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f21848b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f21849c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f21850d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f21851e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f21852f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f21853g;

    /* renamed from: h  reason: collision with root package name */
    private int f21854h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f21855i;
    private l j;
    private LottieAnimationView k;
    private TextView l;
    private TextView m;
    private boolean n;
    private ArrayList<CJROfferCode> o;
    private String p;
    /* access modifiers changed from: private */
    public ImageView q;
    private Button r;
    private String s;
    private boolean t;
    private String u;
    private CJRBusSearchInput v;
    private CJRBusSearchItem w;
    private ArrayList<TripBusDetailsItem> x;
    private double y;
    private CJRBusRechargeCart z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_activity_bus_offers_new);
        setTitle(getResources().getString(R.string.apply_promo_code));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_offers_new);
        ((TextView) toolbar.findViewById(R.id.title)).setText(getResources().getString(R.string.apply_promo_code));
        TextView textView = (TextView) toolbar.findViewById(R.id.doneButton);
        textView.setText(getResources().getString(R.string.done));
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.g(view);
            }
        });
        ((ImageView) findViewById(R.id.apply_tick_image)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.f(view);
            }
        });
        ((ImageView) toolbar.findViewById(R.id.toolbar_btn_back)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.e(view);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().b(false);
        this.r = (Button) findViewById(R.id.network_retry_btn);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.d(view);
            }
        });
        this.f21852f = (RelativeLayout) findViewById(R.id.offers_layout);
        this.f21853g = (LinearLayout) findViewById(R.id.no_network);
        this.f21847a = (EditText) findViewById(R.id.edit_txt_promocode);
        this.k = (LottieAnimationView) findViewById(R.id.update_progress_bar_offers);
        this.f21850d = (RelativeLayout) findViewById(R.id.promocode_input_lyt);
        this.f21851e = (RelativeLayout) findViewById(R.id.promocode_success_lyt);
        this.l = (TextView) findViewById(R.id.promo_status_message);
        this.m = (TextView) findViewById(R.id.success_promo_code);
        this.q = (ImageView) findViewById(R.id.promo_remove_image);
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.c(view);
            }
        });
        this.m.setOnClickListener($$Lambda$AJRBusOfferListActivity$cZbGgs_vUXZJpbK5UHMSamYQLOs.INSTANCE);
        this.f21847a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    AJRBusOfferListActivity.a(AJRBusOfferListActivity.this, true);
                    AJRBusOfferListActivity.this.q.setVisibility(0);
                    a.a();
                    a.b().a(d.cM, (Map<String, Object>) null, (Context) AJRBusOfferListActivity.this);
                    return;
                }
                AJRBusOfferListActivity.a(AJRBusOfferListActivity.this, false);
            }
        });
        this.f21848b = (RelativeLayout) findViewById(R.id.apply_btn_lyt);
        this.f21848b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusOfferListActivity.this.a(view);
            }
        });
        this.f21849c = (RelativeLayout) findViewById(R.id.promocode_lyt);
        this.f21855i = (RecyclerView) findViewById(R.id.offers_list);
        this.f21855i.setHasFixedSize(true);
        this.f21855i.setLayoutManager(new LinearLayoutManager(this));
        this.f21855i.addItemDecoration(new com.travel.bus.busticket.widgets.a(this));
        a.a();
        ((TextView) findViewById(R.id.wallet_loyality_cash_back_text)).setText(a.b().f("cashbackInfoMessage"));
        this.f21854h = com.paytm.utility.b.f((Context) this);
        this.f21848b.getLayoutParams().width = this.f21854h * 5;
        this.f21849c.getLayoutParams().height = (int) (((double) this.f21854h) * 2.5d);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("intent_extra_offers_list")) {
                this.o = (ArrayList) intent.getSerializableExtra("intent_extra_offers_list");
            }
            this.v = (CJRBusSearchInput) intent.getSerializableExtra("intent_extra_bus_search_input");
            this.w = (CJRBusSearchItem) intent.getSerializableExtra("intent_extra_bus_search_result_item");
            this.x = (ArrayList) intent.getSerializableExtra("intent_extra_selected_seats");
            this.u = intent.getStringExtra("cart_applied_promo");
            this.y = ((Double) intent.getSerializableExtra("total_fare")).doubleValue();
            this.B = (CJRBlockOneResponse) intent.getSerializableExtra("intent_block_ticket_response_data");
        }
        ArrayList<CJROfferCode> arrayList = this.o;
        if (arrayList == null || arrayList.size() <= 0) {
            b();
        } else {
            this.j = new l(this, this.o, this, this.u);
            findViewById(R.id.choose_offer_header).setVisibility(0);
            this.f21855i.setAdapter(this.j);
        }
        String str = this.u;
        if (str != null) {
            this.A = str;
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f21847a.setText((CharSequence) null);
        this.q.setVisibility(8);
        this.f21850d.setVisibility(0);
        this.f21851e.setVisibility(8);
        this.u = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String replace = this.f21847a.getText().toString().trim().replace(" ", "");
        if (!TextUtils.isEmpty(replace) && !replace.matches("[a-zA-Z0-9.? ]*")) {
            b(getString(R.string.bus_enter_valid_promo_code));
        } else if (!TextUtils.isEmpty(replace)) {
            new HashMap().put("train_promocode", replace);
            this.A = replace;
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        this.u = null;
        a();
        l lVar = this.j;
        if (lVar != null) {
            lVar.a(this.u);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        f();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void b() {
        if (com.paytm.utility.b.c((Context) this)) {
            this.k.setVisibility(0);
            this.f21853g.setVisibility(8);
            this.f21852f.setVisibility(0);
            c();
            return;
        }
        this.f21853g.setVisibility(0);
        this.f21852f.setVisibility(8);
    }

    private void c() {
        a.a();
        String f2 = a.b().f("busPromoUrl");
        ArrayList<TripBusDetailsItem> arrayList = this.x;
        String productId = (arrayList == null || arrayList.size() <= 0) ? null : this.x.get(0).getProductId();
        if (!TextUtils.isEmpty(productId)) {
            try {
                Uri parse = Uri.parse(f2);
                Uri.Builder buildUpon = Uri.parse(parse.getScheme() + "://" + parse.getAuthority()).buildUpon();
                buildUpon.appendEncodedPath(String.format("papi/v1/promosearch/product/%s/offers", new Object[]{productId}));
                f2 = buildUpon.build().toString();
            } catch (Exception unused) {
                a.a();
                f2 = a.b().f("busPromoUrl");
            }
        }
        if (URLUtil.isValidUrl(f2)) {
            if (o.b(getApplicationContext())) {
                f2 = Uri.parse(f2).buildUpon().appendQueryParameter("isReseller", "true").build().toString();
            }
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = f2;
            bVar.f42884h = null;
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = null;
            bVar.f42885i = new CJRNewTrainOffers();
            bVar.j = this;
            bVar.t = g();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-banner-page";
            bVar.l().a();
        }
    }

    private void b(String str) {
        e();
        this.f21848b.setVisibility(8);
        this.n = false;
        this.l.setText(str);
        this.l.setVisibility(0);
        if (this.f21847a.getText() != null && !this.f21847a.getText().toString().isEmpty() && this.f21847a.getText().toString().trim().length() > 0) {
            this.q.setVisibility(0);
        }
        this.l.setTextColor(getResources().getColor(R.color.trains_promo_error));
        this.f21851e.setVisibility(8);
        this.f21850d.setVisibility(0);
        ArrayList<CJROfferCode> arrayList = this.o;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJROfferCode> it2 = this.o.iterator();
            while (it2.hasNext()) {
                it2.next().setIsOfferApplied(false);
                l lVar = this.j;
                if (lVar != null) {
                    lVar.notifyDataSetChanged();
                }
            }
        }
    }

    public final void a(String str) {
        if (str != null && !str.trim().isEmpty()) {
            String replace = str.trim().replace(" ", "");
            if (!TextUtils.isEmpty(replace)) {
                this.A = replace;
                d();
            }
        }
    }

    public final void a() {
        this.f21847a.setText((CharSequence) null);
        this.q.setVisibility(8);
        this.f21850d.setVisibility(0);
        this.l.setVisibility(8);
        this.f21851e.setVisibility(8);
        this.u = null;
        this.p = null;
        this.z = null;
    }

    private void d() {
        com.travel.bus.a.a();
        String f2 = com.travel.bus.a.b().f("busPromoVerifyUrl");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
        String c2 = c(this.A);
        if (o.b(getApplicationContext())) {
            f2 = Uri.parse(f2).buildUpon().appendQueryParameter("is_reseller", "1").build().toString();
        }
        if (com.paytm.utility.b.c((Context) this)) {
            this.k.setVisibility(0);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = f2;
            bVar.f42884h = c2;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42885i = new CJRBusRechargeCart();
            bVar.j = this;
            bVar.t = g();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-banner-page";
            bVar.l().a();
            return;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = this;
        bVar2.f42878b = a.c.BUS;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = f2;
        bVar2.f42884h = c2;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap;
        bVar2.f42883g = null;
        bVar2.f42885i = new CJRBusRechargeCart();
        bVar2.j = this;
        bVar2.t = g();
        bVar2.n = a.b.SILENT;
        bVar2.o = "bus-banner-page";
        bVar2.l();
    }

    private String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", this.B.getBlockResponse().getRequestId());
            jSONObject.put("order_id", this.B.getBlockResponse().getTicketId());
            jSONObject.put(PayUtility.PROMO_CODE, str);
            jSONObject.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject.toString();
    }

    private void e() {
        ProgressDialog progressDialog = this.C;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.C.dismiss();
            this.C = null;
        }
    }

    public void onBackPressed() {
        f();
        super.onBackPressed();
    }

    private void f() {
        Intent intent = new Intent();
        CJRBusRechargeCart cJRBusRechargeCart = this.z;
        if (cJRBusRechargeCart != null) {
            intent.putExtra("cart_object", cJRBusRechargeCart);
        }
        setResult(-1, intent);
        finish();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRCart cart;
        this.k.setVisibility(8);
        if ((iJRPaytmDataModel instanceof CJRBusOffers) && iJRPaytmDataModel != null) {
            this.D = true;
            findViewById(R.id.choose_offer_header).setVisibility(0);
            CJRBusOffers cJRBusOffers = (CJRBusOffers) iJRPaytmDataModel;
            this.l.setVisibility(8);
            if (cJRBusOffers != null && cJRBusOffers.getOfferCodes() != null) {
                ArrayList<CJROfferCode> offerCodes = cJRBusOffers.getOfferCodes();
                if (offerCodes == null || offerCodes.size() <= 0) {
                    this.u = null;
                    l lVar = this.j;
                    if (lVar != null) {
                        lVar.a(this.u);
                    }
                    findViewById(R.id.no_offers_layout).setVisibility(0);
                    findViewById(R.id.offers_list_lyt).setVisibility(8);
                    findViewById(R.id.choose_offer_header).setVisibility(8);
                    return;
                }
                this.j.a(this.o, this.u);
                findViewById(R.id.choose_offer_header).setVisibility(0);
            }
        } else if (iJRPaytmDataModel instanceof CJRBusRechargeCart) {
            this.E = true;
            this.z = (CJRBusRechargeCart) iJRPaytmDataModel;
            CJRBusRechargeCart cJRBusRechargeCart = this.z;
            if (cJRBusRechargeCart != null && (cart = cJRBusRechargeCart.getCart()) != null) {
                if (cart == null || cart.getPromoStatus() == null || !cart.getPromoStatus().equalsIgnoreCase("success")) {
                    if (!(cart == null || cart.getPromoStatus() == null || !cart.getPromoStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE))) {
                        b(cart.getPromoFailureText());
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Confirm Booking page");
                        hashMap.put("bus_user_id", com.paytm.utility.b.n((Context) this));
                        hashMap.put("bus_origin", this.w.getSource().toString());
                        hashMap.put("bus_destination", this.w.getDestination().toString());
                        hashMap.put("bus_promocode", cart.getPromoCode());
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a("bus_confirm_promocode_error_displayed", (Map<String, Object>) hashMap, (Context) this);
                        this.u = null;
                        l lVar2 = this.j;
                        if (lVar2 != null) {
                            lVar2.a(this.u);
                        }
                    }
                    this.t = false;
                } else {
                    this.t = true;
                    this.n = false;
                    this.q.setVisibility(0);
                    this.f21850d.setVisibility(8);
                    this.f21851e.setVisibility(0);
                    this.l.setVisibility(8);
                    this.m.setText(cart.getPaytmPromocode());
                    if (cart.getPromoText() != null) {
                        this.l.setVisibility(0);
                        this.l.setText(cart.getPromoText());
                        this.s = cart.getPromoText();
                    }
                    this.p = cart.getPaytmPromocode();
                    this.u = cart.getPaytmPromocode();
                    this.l.setTextColor(getResources().getColor(R.color.color_000000));
                    ArrayList<CJROfferCode> arrayList = this.o;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<CJROfferCode> it2 = this.o.iterator();
                        while (it2.hasNext()) {
                            CJROfferCode next = it2.next();
                            if (next == null || !next.getCode().equalsIgnoreCase(cart.getPaytmPromocode())) {
                                next.setIsOfferApplied(false);
                            } else {
                                next.setIsOfferApplied(true);
                                this.p = cart.getPaytmPromocode();
                                this.u = next.getCode();
                            }
                        }
                        l lVar3 = this.j;
                        if (lVar3 != null) {
                            lVar3.a(this.o, this.u);
                        }
                    }
                }
                e();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            e();
            CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        cJRNewErrorFormat = (CJRNewErrorFormat) new f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (this.n) {
                this.n = false;
                HashMap hashMap = new HashMap();
                hashMap.put("train_promocode", this.p);
                hashMap.put("train_promocode_error_message", networkCustomError.getMessage());
            }
            String message = networkCustomError.getMessage();
            if (!isFinishing()) {
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    com.travel.bus.a.a();
                    com.travel.g.a b2 = com.travel.bus.a.b();
                    AJRBusOfferListActivity.class.getName();
                    b2.a((Activity) this, networkCustomError);
                }
                if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("449")) {
                    if (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503")) {
                        if (!message.equalsIgnoreCase("504")) {
                            if (message.equals("failure_error")) {
                                if (this.n) {
                                    if (cJRNewErrorFormat.getStatus() == null) {
                                        b(networkCustomError.getAlertMessage());
                                    } else if (cJRNewErrorFormat.getStatus().getMessage().f22820c != null) {
                                        b(cJRNewErrorFormat.getStatus().getMessage().f22820c);
                                    }
                                    this.u = null;
                                    if (this.j != null) {
                                        this.j.a(this.u);
                                        return;
                                    }
                                    return;
                                }
                                if (cJRNewErrorFormat.getStatus() != null) {
                                    o.a(this, cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a(), (Intent) null, getLayoutInflater());
                                } else {
                                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                }
                                this.k.setVisibility(8);
                                return;
                            } else if (networkCustomError.getMessage() == null) {
                                return;
                            } else {
                                if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    if (networkCustomError != null) {
                                        if (networkCustomError.getAlertMessage() != null) {
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put("event_category", "bus_home");
                                            hashMap2.put("event_action", "error_popup");
                                            hashMap2.put("event_label", networkCustomError.getAlertMessage());
                                            hashMap2.put("event_label2", "client_error");
                                            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
                                            hashMap2.put("vertical_name", "bus");
                                            hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
                                            com.travel.bus.a.a();
                                            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) this);
                                        }
                                    }
                                    com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                                    return;
                                } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("406")) {
                                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                    this.k.setVisibility(8);
                                    return;
                                } else if (this.n) {
                                    if (cJRNewErrorFormat.getStatus() == null) {
                                        b(networkCustomError.getAlertMessage());
                                    } else if (cJRNewErrorFormat.getStatus().getMessage().f22820c != null) {
                                        b(cJRNewErrorFormat.getStatus().getMessage().f22820c);
                                    }
                                    this.u = null;
                                    if (this.j != null) {
                                        this.j.a(this.u);
                                        return;
                                    }
                                    return;
                                } else {
                                    if (cJRNewErrorFormat.getStatus() != null) {
                                        o.a(this, cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a(), (Intent) null, getLayoutInflater());
                                    } else {
                                        com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                    }
                                    this.k.setVisibility(8);
                                    return;
                                }
                            }
                        }
                    }
                    if (this.n) {
                        if (cJRNewErrorFormat.getStatus() == null) {
                            b(networkCustomError.getAlertMessage());
                        } else if (cJRNewErrorFormat.getStatus().getMessage().f22820c != null) {
                            b(cJRNewErrorFormat.getStatus().getMessage().f22820c);
                        }
                        this.u = null;
                        if (this.j != null) {
                            this.j.a(this.u);
                            return;
                        }
                        return;
                    }
                    this.k.setVisibility(8);
                } else if (this.n) {
                    b(networkCustomError.getAlertMessage());
                    this.u = null;
                    if (this.j != null) {
                        this.j.a(this.u);
                    }
                } else {
                    this.k.setVisibility(8);
                    com.paytm.utility.b.b((Context) this, message, networkCustomError.getMessage());
                }
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    private static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusOffersScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        if (!TextUtils.isEmpty(this.u)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(d.cL, (Map<String, Object>) hashMap, (Context) this);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(Html.fromHtml(String.format(getString(R.string.remove_promo_cart), new Object[]{this.u})));
            builder.setPositiveButton(getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRBusOfferListActivity.this.b(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(17039360, $$Lambda$AJRBusOfferListActivity$I85Xhd13MWt0RnaSK59sG5pFjaY.INSTANCE);
            builder.show();
        }
    }

    static /* synthetic */ void a(AJRBusOfferListActivity aJRBusOfferListActivity, boolean z2) {
        if (z2) {
            aJRBusOfferListActivity.f21848b.setVisibility(0);
        } else {
            aJRBusOfferListActivity.f21848b.setVisibility(8);
        }
    }
}
