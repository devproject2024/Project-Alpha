package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.adapter.c;
import net.one97.paytm.adapter.d;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRSavedCard;
import net.one97.paytm.common.entity.shopping.CJRSavedCards;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ai;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.widget.PaytmAutomaticSavedCardsListview;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Deprecated
public class AJRPaytmAutomaticConfirmActivity extends CJRActionBarBaseActivity {
    private TextView C;
    private TextView D;
    private LinearLayout E;
    private LinearLayout F;
    private CJRSavedCard G;
    private JSONObject H;
    private CJROrderedCart I;
    private boolean J;
    private ProgressBar K;
    private RelativeLayout L;

    /* renamed from: a  reason: collision with root package name */
    String f51631a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f51632b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public Dialog f51633c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public int f51634d;

    /* renamed from: e  reason: collision with root package name */
    private String f51635e;

    /* renamed from: f  reason: collision with root package name */
    private String f51636f;

    /* renamed from: g  reason: collision with root package name */
    private String f51637g;

    /* renamed from: h  reason: collision with root package name */
    private String f51638h;

    /* renamed from: i  reason: collision with root package name */
    private String f51639i;
    /* access modifiers changed from: private */
    public c j;
    private CJRSavedCards k = new CJRSavedCards();
    private TextView l;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.paytm_automatic_confirm_page, (ViewGroup) null));
        o();
        p();
        setTitle(getResources().getString(R.string.paytm_automatic));
        Intent intent = getIntent();
        if (intent != null) {
            this.f51631a = intent.getStringExtra(AppConstants.DURATION);
            this.f51635e = intent.getStringExtra("recharge_number");
            this.f51636f = intent.getStringExtra("price");
            this.f51638h = intent.getStringExtra("expiryDate");
            this.f51639i = intent.getStringExtra("automatic_operator_url");
            this.I = (CJROrderedCart) intent.getSerializableExtra("cart");
            this.f51637g = intent.getStringExtra("automatic_name");
        }
        int u = a.u(this);
        this.E = (LinearLayout) findViewById(R.id.automatic_recharge_lyt);
        this.E.setPadding(u, u, u, 0);
        this.F = (LinearLayout) findViewById(R.id.saved_cards_lyt);
        this.K = (ProgressBar) findViewById(R.id.saved_card_progress_bar);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.content_thumbnail_layout_automatic);
        relativeLayout.setVisibility(0);
        ((RelativeLayout) findViewById(R.id.automatic_change_lyt)).setVisibility(0);
        final ImageView imageView = (ImageView) findViewById(R.id.content_thumbnail_automatic);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.automatic_img_loading);
        this.D = (TextView) findViewById(R.id.automatic_recharge_description);
        if (this.f51637g != null) {
            TextView textView = this.D;
            textView.setText(this.f51637g + " " + getResources().getString(R.string.auto_rescharge_desc1) + " " + this.f51636f + " " + getResources().getString(R.string.auto_rescharge_desc2) + " " + this.f51631a);
        }
        this.l = (TextView) findViewById(R.id.next_due_recharge);
        this.l.setPadding(0, u, 0, u);
        this.C = (TextView) findViewById(R.id.automatic_recharge_money_desc);
        CJROrderedCart cJROrderedCart = this.I;
        if (cJROrderedCart == null || cJROrderedCart.getProductDetail() == null || this.I.getProductDetail().getVertical() == null) {
            this.C.setVisibility(8);
        } else if (this.I.getProductDetail().getVertical().equalsIgnoreCase("Recharge")) {
            if (this.f51638h != null) {
                TextView textView2 = this.l;
                textView2.setText(Html.fromHtml(getResources().getString(R.string.auto_recharge_due_date_desc1) + "<b>" + this.f51638h + "</b>"));
            } else {
                this.l.setVisibility(8);
            }
            TextView textView3 = this.C;
            textView3.setText(Html.fromHtml(getResources().getString(R.string.automatic_recharge_money_desc_part_1) + "<br/><br/> " + getResources().getString(R.string.automatic_recharge_money_desc_part_3)));
        } else if (this.I.getProductDetail().getVertical().equalsIgnoreCase(getResources().getString(R.string.fs_name_wallet))) {
            if (this.f51638h != null) {
                TextView textView4 = this.l;
                textView4.setText(Html.fromHtml(getResources().getString(R.string.auto_recharge_due_date_desc2) + "<b>" + this.f51638h + "</b>"));
            } else {
                this.l.setVisibility(8);
            }
            if (this.f51631a != null) {
                TextView textView5 = this.C;
                textView5.setText(Html.fromHtml(getResources().getString(R.string.automatic_wallet_money_desc_part_1) + "<br/><br/> " + getResources().getString(R.string.automatic_wallet_money_desc_part_2) + " " + this.f51631a + " " + getResources().getString(R.string.automatic_wallet_money_desc_part_3)));
            } else {
                this.C.setText(Html.fromHtml(getResources().getString(R.string.automatic_wallet_money_desc_part_1)));
            }
        }
        this.C.setPadding(0, u, 0, u);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(getResources().getColor(R.color.gray));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            relativeLayout.setBackground(shapeDrawable);
        } else {
            relativeLayout.setBackgroundDrawable(shapeDrawable);
        }
        if (this.f51639i != null) {
            ai.INSTANCE.getImageLoader().get(this.f51639i.replace(" ", "%20"), new ImageLoader.ImageListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                }

                public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                    Bitmap bitmap;
                    if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                        imageView.setImageBitmap(bitmap);
                        progressBar.setVisibility(8);
                    }
                }
            });
        }
        ((TextView) findViewById(R.id.change_automatic_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    ArrayList unused = AJRPaytmAutomaticConfirmActivity.this.f51632b = new ArrayList(Arrays.asList(AJRPaytmAutomaticConfirmActivity.this.getResources().getStringArray(R.array.automatic_recharge_duration)));
                    AJRPaytmAutomaticConfirmActivity aJRPaytmAutomaticConfirmActivity = AJRPaytmAutomaticConfirmActivity.this;
                    AlertDialog.Builder builder = new AlertDialog.Builder(aJRPaytmAutomaticConfirmActivity);
                    TextView textView = new TextView(aJRPaytmAutomaticConfirmActivity);
                    int u = a.u(aJRPaytmAutomaticConfirmActivity);
                    textView.setText(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.auto_recharge_duration_label_recharge));
                    textView.setPadding(u, u, u, u);
                    textView.setGravity(17);
                    textView.setTextSize(20.0f);
                    textView.setTextColor(aJRPaytmAutomaticConfirmActivity.getResources().getColor(R.color.color_33b5e5));
                    ListView listView = new ListView(aJRPaytmAutomaticConfirmActivity);
                    listView.setChoiceMode(1);
                    d dVar = new d(aJRPaytmAutomaticConfirmActivity, aJRPaytmAutomaticConfirmActivity.f51631a, aJRPaytmAutomaticConfirmActivity.f51632b, u);
                    listView.setAdapter(dVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(dVar) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ d f51645a;

                        {
                            this.f51645a = r2;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                            d dVar = this.f51645a;
                            if (dVar != null && dVar.getCount() > 0) {
                                this.f51645a.a((String) this.f51645a.getItem(i2));
                            }
                            if (AJRPaytmAutomaticConfirmActivity.this.f51633c.isShowing()) {
                                int unused = AJRPaytmAutomaticConfirmActivity.this.f51634d = i2;
                            }
                        }
                    });
                    builder.setCustomTitle(textView);
                    builder.setCancelable(false);
                    builder.setInverseBackgroundForced(true);
                    builder.setPositiveButton(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AJRPaytmAutomaticConfirmActivity aJRPaytmAutomaticConfirmActivity = AJRPaytmAutomaticConfirmActivity.this;
                            AJRPaytmAutomaticConfirmActivity.a(aJRPaytmAutomaticConfirmActivity, (String) aJRPaytmAutomaticConfirmActivity.f51632b.get(AJRPaytmAutomaticConfirmActivity.this.f51634d));
                            AJRPaytmAutomaticConfirmActivity.this.f51633c.dismiss();
                        }
                    });
                    builder.setNegativeButton(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AJRPaytmAutomaticConfirmActivity.this.f51633c.dismiss();
                        }
                    });
                    builder.setView(listView);
                    aJRPaytmAutomaticConfirmActivity.f51633c = builder.create();
                    aJRPaytmAutomaticConfirmActivity.f51634d = 0;
                    aJRPaytmAutomaticConfirmActivity.f51633c.show();
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
        });
        this.L = (RelativeLayout) findViewById(R.id.lyt_save_btn);
        this.L.setPadding(0, u * 3, 0, 0);
        try {
            if (a.m(this)) {
                net.one97.paytm.common.b.d.a(this, b(), this, (Map<String, String>) null, new HashMap(), a.C0715a.POST, (String) null, new CJRSavedCards(), a.c.HOME, a.b.SILENT).a();
                return;
            }
            m();
            b.b((Context) this, getResources().getString(R.string.title_connection_problem), getResources().getString(R.string.msg_connection_problem));
            this.K.setVisibility(8);
            this.F.setVisibility(0);
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private String b() {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("SavedCard", (String) null);
        String b2 = t.b((Context) this);
        try {
            return Uri.parse(a2).buildUpon().appendQueryParameter("JsonData", "{\"SSOToken\":\"" + b2 + "\"}").build().toString();
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        k();
        i();
        j();
        l();
        return super.onPrepareOptionsMenu(menu);
    }

    public void onSaveClick(View view) {
        super.onSignInMenuClick(view);
        c cVar = this.j;
        if (cVar != null) {
            this.G = cVar.f52317a;
        }
        if (this.G != null) {
            this.J = true;
            try {
                a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
                this.H = a(true);
                c();
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        Intent intent;
        String str;
        super.onApiSuccess(iJRPaytmDataModel);
        if (iJRPaytmDataModel instanceof CJRSavedCards) {
            this.k = (CJRSavedCards) iJRPaytmDataModel;
            CJRSavedCards cJRSavedCards = this.k;
            try {
                this.K.setVisibility(8);
                this.F.setVisibility(0);
                this.L.setVisibility(8);
                if (cJRSavedCards == null) {
                    return;
                }
                if (cJRSavedCards.getSavedCardList().size() > 0) {
                    ArrayList<CJRSavedCard> savedCardList = cJRSavedCards.getSavedCardList();
                    ArrayList arrayList = new ArrayList();
                    Iterator<CJRSavedCard> it2 = savedCardList.iterator();
                    while (it2.hasNext()) {
                        CJRSavedCard next = it2.next();
                        if (next.getPaymentmode().trim().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.L.setVisibility(0);
                        d(getResources().getString(R.string.save));
                        PaytmAutomaticSavedCardsListview paytmAutomaticSavedCardsListview = (PaytmAutomaticSavedCardsListview) findViewById(R.id.saved_card_list);
                        this.j = new c(this, arrayList, (CJRSavedCard) arrayList.get(0));
                        paytmAutomaticSavedCardsListview.setChoiceMode(1);
                        paytmAutomaticSavedCardsListview.setAdapter(this.j);
                        paytmAutomaticSavedCardsListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                                if (AJRPaytmAutomaticConfirmActivity.this.j != null && AJRPaytmAutomaticConfirmActivity.this.j.getCount() > 0) {
                                    c a2 = AJRPaytmAutomaticConfirmActivity.this.j;
                                    a2.f52317a = (CJRSavedCard) AJRPaytmAutomaticConfirmActivity.this.j.getItem(i2);
                                    a2.notifyDataSetChanged();
                                }
                            }
                        });
                        return;
                    }
                    this.L.setVisibility(8);
                    return;
                }
                this.L.setVisibility(8);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
            if (cJRPGTokenList != null) {
                try {
                    String a2 = t.a(cJRPGTokenList);
                    if (!TextUtils.isEmpty(a2)) {
                        net.one97.paytm.j.c.a();
                        String b2 = b.b((Context) this, net.one97.paytm.j.c.a("automaticSubscription", (String) null));
                        JSONObject jSONObject = this.H;
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, (Context) this);
                        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
                        String k2 = b.k();
                        if (Uri.parse(b2).getQuery() != null) {
                            str = b2 + "&wallet_token=" + a2 + "&client_id=" + k2;
                        } else {
                            str = b2 + "?wallet_token=" + a2 + "&client_id=" + k2;
                        }
                        com.paytm.network.a a4 = net.one97.paytm.common.b.d.a(this, str, this, a3, (Map<String, String>) null, a.C0715a.POST, jSONObject2, new CJRRechargePayment(), a.c.HOME, a.b.SILENT);
                        if (com.paytm.utility.a.m(this)) {
                            a4.a();
                        } else {
                            r.a(a4, (Context) this, (DialogInterface.OnCancelListener) this);
                        }
                    } else {
                        a((NetworkCustomError) null);
                    }
                } catch (Exception e3) {
                    if (b.v) {
                        q.b(e3.getMessage());
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
            CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
            try {
                if (cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                    m();
                    if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                        NetworkCustomError networkCustomError = new NetworkCustomError();
                        net.one97.paytm.j.c.a();
                        if (!TextUtils.isEmpty(net.one97.paytm.j.c.a("automaticSubscription", (String) null))) {
                            net.one97.paytm.j.c.a();
                            networkCustomError.setUrl(net.one97.paytm.j.c.a("automaticSubscription", (String) null));
                            if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                                networkCustomError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                            }
                        }
                        a(networkCustomError);
                    } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                        b.b((Context) this, cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
                    }
                } else {
                    if (!this.J) {
                        intent = new Intent(this, AJRRechargePaymentActivity.class);
                        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                        intent.putExtra(UpiConstants.FROM, "Auto_Recharge");
                        m();
                    } else {
                        this.J = false;
                        intent = new Intent(this, AJROrderSummaryActivity.class);
                        intent.putExtra(UpiConstants.FROM, "paytm_automatic");
                        if (cJRRechargePayment.getOrderId() != null) {
                            intent.putExtra("order_id", cJRRechargePayment.getOrderId());
                        }
                    }
                    startActivity(intent);
                    m();
                    finish();
                }
            } catch (Exception e4) {
                if (b.v) {
                    q.b(e4.getMessage());
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            m();
            this.E.setVisibility(0);
            this.K.setVisibility(8);
            this.F.setVisibility(0);
            if (networkCustomError == null) {
                return;
            }
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                l.a((Activity) this, networkCustomError, (String) null);
            } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    return;
                }
                b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
            }
        }
    }

    private static String a(String str) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.add(5, Integer.parseInt(str.split("\\s")[0]));
            return new SimpleDateFormat("dd MMM yyyy").format(instance.getTime());
        } catch (Exception e2) {
            if (!b.v) {
                return "";
            }
            q.b(e2.getMessage());
            return "";
        }
    }

    private void c() {
        if (!TextUtils.isEmpty(ag.a(getApplicationContext()).b("sso_token=", "", true))) {
            t.a((Activity) this, (com.paytm.network.listener.b) this, a.c.OAUTH);
            return;
        }
        m();
        a((NetworkCustomError) null);
    }

    private JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        CJROrderedCart cJROrderedCart = this.I;
        try {
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            if (productDetail != null && !TextUtils.isEmpty(String.valueOf(productDetail.getId()))) {
                jSONObject.put(CLPConstants.PRODUCT_ID, productDetail.getId());
            }
            jSONObject.put("qty", cJROrderedCart.getQuantity());
            if (cJROrderedCart.getRechargeConfiguration() != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (cJROrderedCart.getRechargeNumber() != null) {
                    jSONObject2.put("recharge_number", cJROrderedCart.getRechargeNumber());
                }
                if (cJROrderedCart.getRechargePrice() != null) {
                    jSONObject2.put("price", Long.parseLong(cJROrderedCart.getRechargePrice()));
                }
                jSONObject.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
            }
        } catch (Exception unused) {
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        if (z) {
            try {
                jSONObject3.put("type", "S2S");
                jSONObject3.put("savedCardId", Long.parseLong(this.G.getCardID()));
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        if (this.f51631a != null) {
            jSONObject3.put(StringSet.interval, Integer.parseInt(this.f51631a.split("\\s")[0]));
        }
        if (!TextUtils.isEmpty(cJROrderedCart.getRechargePrice())) {
            jSONObject3.put("amount", Long.parseLong(cJROrderedCart.getRechargePrice()));
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("cart_items", jSONArray);
            jSONObject4.put("subscribe", true);
            jSONObject4.put("subscriptionInfo", jSONObject3);
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
        }
        return jSONObject4;
    }

    public void onAddCardClicked(View view) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.add_card_alert_title));
            builder.setMessage(getResources().getString(R.string.add_card_alert_desc)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.continue_label), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRPaytmAutomaticConfirmActivity.e(AJRPaytmAutomaticConfirmActivity.this);
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(AJRPaytmAutomaticConfirmActivity aJRPaytmAutomaticConfirmActivity, String str) {
        if (str != null) {
            try {
                aJRPaytmAutomaticConfirmActivity.f51631a = str;
                if (aJRPaytmAutomaticConfirmActivity.f51637g != null) {
                    TextView textView = aJRPaytmAutomaticConfirmActivity.D;
                    textView.setText(aJRPaytmAutomaticConfirmActivity.f51637g + " " + aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.auto_rescharge_desc1) + " " + aJRPaytmAutomaticConfirmActivity.f51636f + " " + aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.auto_rescharge_desc2) + " " + str);
                }
                if (aJRPaytmAutomaticConfirmActivity.I != null && aJRPaytmAutomaticConfirmActivity.I.getProductDetail() != null && aJRPaytmAutomaticConfirmActivity.I.getProductDetail().getVertical() != null) {
                    if (aJRPaytmAutomaticConfirmActivity.I.getProductDetail().getVertical().equalsIgnoreCase("Recharge")) {
                        TextView textView2 = aJRPaytmAutomaticConfirmActivity.l;
                        textView2.setText(Html.fromHtml(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.auto_recharge_due_date_desc1) + "<b>" + a(str) + "</b>"));
                        TextView textView3 = aJRPaytmAutomaticConfirmActivity.C;
                        textView3.setText(Html.fromHtml(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_recharge_money_desc_part_1) + "<br/><br/> " + aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_recharge_money_desc_part_3)));
                    } else if (aJRPaytmAutomaticConfirmActivity.I.getProductDetail().getVertical().equalsIgnoreCase(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.fs_name_wallet))) {
                        TextView textView4 = aJRPaytmAutomaticConfirmActivity.l;
                        textView4.setText(Html.fromHtml(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.auto_recharge_due_date_desc2) + "<b>" + a(str) + "</b>"));
                        if (aJRPaytmAutomaticConfirmActivity.f51631a != null) {
                            TextView textView5 = aJRPaytmAutomaticConfirmActivity.C;
                            textView5.setText(Html.fromHtml(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_wallet_money_desc_part_1) + "<br/><br/> " + aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_wallet_money_desc_part_2) + " " + aJRPaytmAutomaticConfirmActivity.f51631a + " " + aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_wallet_money_desc_part_3)));
                            return;
                        }
                        aJRPaytmAutomaticConfirmActivity.C.setText(Html.fromHtml(aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.automatic_wallet_money_desc_part_1)));
                    }
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    static /* synthetic */ void e(AJRPaytmAutomaticConfirmActivity aJRPaytmAutomaticConfirmActivity) {
        aJRPaytmAutomaticConfirmActivity.a((Context) aJRPaytmAutomaticConfirmActivity, aJRPaytmAutomaticConfirmActivity.getResources().getString(R.string.please_wait_progress_msg));
        aJRPaytmAutomaticConfirmActivity.H = aJRPaytmAutomaticConfirmActivity.a(false);
        aJRPaytmAutomaticConfirmActivity.c();
    }
}
