package com.travel.train.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.j;
import com.travel.train.f.c;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.j.t;
import com.travel.train.model.trainticket.CJRTrainOfferCode;
import com.travel.train.model.trainticket.CJRTrainOffers;
import com.travel.train.model.trainticket.CJRTrainPromoVerify;
import com.travel.train.widget.EditView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRTrainOffersListActivity extends CJRTrainBaseActivity implements b, j.a, c.a, EditView.a {
    private String A;
    private String B = "AJRTrainOffersListActivity";

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f26024a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f26025b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f26026c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f26027d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f26028e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f26029f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f26030g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f26031h;

    /* renamed from: i  reason: collision with root package name */
    private int f26032i;
    private RecyclerView j;
    private j k;
    private ProgressBar l;
    private TextView m;
    private TextView n;
    private boolean o;
    private ArrayList<CJRTrainOfferCode> p;
    private String q;
    /* access modifiers changed from: private */
    public ImageView r;
    private Button s;
    private String t;
    private boolean u;
    private String v;
    /* access modifiers changed from: private */
    public String w;
    /* access modifiers changed from: private */
    public String x;
    /* access modifiers changed from: private */
    public String y;
    /* access modifiers changed from: private */
    public String z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_action_bar_layout);
        String string = getResources().getString(R.string.apply_promo_code);
        setSupportActionBar((Toolbar) findViewById(R.id.base_toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(string);
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainOffersListActivity.this.a(view);
            }
        });
        this.f26024a = (FrameLayout) findViewById(R.id.content_frame);
        this.f26024a.addView(getLayoutInflater().inflate(R.layout.pre_t_train_offer_lyt, (ViewGroup) null));
        this.s = (Button) findViewById(R.id.network_retry_btn);
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainOffersListActivity.this.b();
            }
        });
        this.f26030g = (RelativeLayout) findViewById(R.id.offers_layout);
        this.f26031h = (LinearLayout) findViewById(R.id.no_network);
        this.f26025b = (EditText) findViewById(R.id.edit_txt_promocode);
        this.l = (ProgressBar) findViewById(R.id.update_progress_bar_offers);
        this.f26028e = (RelativeLayout) findViewById(R.id.promocode_input_lyt);
        this.f26029f = (RelativeLayout) findViewById(R.id.promocode_success_lyt);
        this.m = (TextView) findViewById(R.id.promo_status_message);
        this.n = (TextView) findViewById(R.id.success_promo_code);
        this.r = (ImageView) findViewById(R.id.promo_remove_image);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainOffersListActivity.this.f26025b.setText((CharSequence) null);
                AJRTrainOffersListActivity.this.r.setVisibility(8);
                AJRTrainOffersListActivity.this.f26028e.setVisibility(0);
                AJRTrainOffersListActivity.this.f26029f.setVisibility(8);
                String unused = AJRTrainOffersListActivity.this.y = null;
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.f26025b.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    AJRTrainOffersListActivity.a(AJRTrainOffersListActivity.this, true);
                    AJRTrainOffersListActivity.this.r.setVisibility(8);
                    return;
                }
                AJRTrainOffersListActivity.a(AJRTrainOffersListActivity.this, false);
            }
        });
        this.f26026c = (RelativeLayout) findViewById(R.id.apply_btn_lyt);
        this.f26026c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainOffersListActivity aJRTrainOffersListActivity = AJRTrainOffersListActivity.this;
                String unused = aJRTrainOffersListActivity.z = aJRTrainOffersListActivity.f26025b.getText().toString();
                AJRTrainOffersListActivity aJRTrainOffersListActivity2 = AJRTrainOffersListActivity.this;
                String unused2 = aJRTrainOffersListActivity2.z = aJRTrainOffersListActivity2.z.trim();
                AJRTrainOffersListActivity aJRTrainOffersListActivity3 = AJRTrainOffersListActivity.this;
                String unused3 = aJRTrainOffersListActivity3.z = aJRTrainOffersListActivity3.z.replace(" ", "");
                if (!TextUtils.isEmpty(AJRTrainOffersListActivity.this.z)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("train_promocode", AJRTrainOffersListActivity.this.z);
                    AJRTrainOffersListActivity aJRTrainOffersListActivity4 = AJRTrainOffersListActivity.this;
                    aJRTrainOffersListActivity4.a("train_review_itinerary_promocode_applied", aJRTrainOffersListActivity4.w, AJRTrainOffersListActivity.this.x, com.paytm.utility.b.n((Context) AJRTrainOffersListActivity.this), hashMap);
                    AJRTrainOffersListActivity aJRTrainOffersListActivity5 = AJRTrainOffersListActivity.this;
                    aJRTrainOffersListActivity5.c(aJRTrainOffersListActivity5.z);
                }
            }
        });
        this.f26027d = (RelativeLayout) findViewById(R.id.promocode_lyt);
        this.j = (RecyclerView) findViewById(R.id.offers_list);
        this.j.setHasFixedSize(true);
        this.j.setLayoutManager(new LinearLayoutManager(this));
        this.j.addItemDecoration(new com.travel.train.widget.c(this));
        com.travel.train.b.a();
        ((TextView) findViewById(R.id.wallet_loyality_cash_back_text)).setText(com.travel.train.b.b().t());
        this.f26032i = com.paytm.utility.b.f((Context) this);
        this.f26026c.getLayoutParams().width = this.f26032i * 5;
        this.f26027d.getLayoutParams().height = (int) (((double) this.f26032i) * 2.5d);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("request_id") && intent.getStringExtra("request_id") != null) {
                this.v = intent.getStringExtra("request_id");
            }
            if (intent.hasExtra("offers") && intent.getSerializableExtra("offers") != null) {
                this.p = (ArrayList) intent.getSerializableExtra("offers");
            }
            if (intent.hasExtra("intent_extra_origin_city_list") && intent.getStringExtra("intent_extra_origin_city_list") != null) {
                this.w = intent.getStringExtra("intent_extra_origin_city_list");
            }
            if (intent.hasExtra("destination_city") && intent.getStringExtra("destination_city") != null) {
                this.x = intent.getStringExtra("destination_city");
            }
            if (intent.hasExtra(Utility.EVENT_CATEGORY_PROMOCODE) && intent.getStringExtra(Utility.EVENT_CATEGORY_PROMOCODE) != null) {
                this.y = intent.getStringExtra(Utility.EVENT_CATEGORY_PROMOCODE);
            }
            this.q = this.y;
        }
        ArrayList<CJRTrainOfferCode> arrayList = this.p;
        if (arrayList == null || arrayList.size() <= 0) {
            b();
        } else {
            a(this.p);
        }
        String str = this.y;
        if (str != null) {
            c(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        f();
        return true;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (com.paytm.utility.b.c((Context) this)) {
            this.l.setVisibility(0);
            this.f26031h.setVisibility(8);
            this.f26030g.setVisibility(0);
            c();
            return;
        }
        this.f26031h.setVisibility(0);
        this.f26030g.setVisibility(8);
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().u());
        sb.append("trains");
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            String b2 = o.b((Context) this, com.paytm.utility.b.s(this, sb2));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.o;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = n.b((Context) this);
            bVar.f42885i = new CJRTrainOffers();
            bVar.j = this;
            a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRTrainPromoVerify cJRTrainPromoVerify;
        TextView textView;
        if ((iJRPaytmDataModel instanceof CJRTrainOffers) && iJRPaytmDataModel != null) {
            this.l.setVisibility(8);
            findViewById(R.id.choose_offer_header).setVisibility(0);
            CJRTrainOffers cJRTrainOffers = (CJRTrainOffers) iJRPaytmDataModel;
            if (cJRTrainOffers == null || cJRTrainOffers.getBody() == null || cJRTrainOffers.getBody().getPromotions() == null || cJRTrainOffers.getBody().getPromotions().size() <= 0) {
                this.y = null;
                j jVar = this.k;
                if (jVar != null) {
                    jVar.a(this.y);
                }
                findViewById(R.id.no_offers_layout).setVisibility(0);
                findViewById(R.id.offers_list_lyt).setVisibility(8);
                findViewById(R.id.choose_offer_header).setVisibility(8);
                if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getNoOffers()) && (textView = (TextView) findViewById(R.id.no_valid_offer_title)) != null) {
                    textView.setText(g.f27551a.getNoOffers());
                    return;
                }
                return;
            }
            this.p = new ArrayList<>();
            Iterator<CJRTrainOfferCode> it2 = cJRTrainOffers.getBody().getPromotions().iterator();
            while (it2.hasNext()) {
                this.p.add(it2.next());
            }
            a(this.p);
        } else if ((iJRPaytmDataModel instanceof CJRTrainPromoVerify) && iJRPaytmDataModel != null && (cJRTrainPromoVerify = (CJRTrainPromoVerify) iJRPaytmDataModel) != null) {
            a(cJRTrainPromoVerify);
        }
    }

    private void a(CJRTrainPromoVerify cJRTrainPromoVerify) {
        if (cJRTrainPromoVerify == null || cJRTrainPromoVerify.getBody() == null || cJRTrainPromoVerify.getBody().getPromostatus() == null || !cJRTrainPromoVerify.getBody().getPromostatus().equalsIgnoreCase("success")) {
            if (!(cJRTrainPromoVerify == null || cJRTrainPromoVerify.getBody() == null || cJRTrainPromoVerify.getBody().getPromostatus() == null || !cJRTrainPromoVerify.getBody().getPromostatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE))) {
                b(cJRTrainPromoVerify.getBody().getPromofailuretext());
                this.y = null;
                j jVar = this.k;
                if (jVar != null) {
                    jVar.a(this.y);
                }
            }
            this.u = false;
            HashMap hashMap = new HashMap();
            hashMap.put("train_promocode", this.q);
            hashMap.put("train_promocode_error_message", cJRTrainPromoVerify.getBody().getPromofailuretext());
            a("train_review_itinerary_promocode_error", this.w, this.x, com.paytm.utility.b.n((Context) this), hashMap);
        } else {
            this.u = true;
            this.o = false;
            this.r.setVisibility(8);
            this.f26028e.setVisibility(8);
            this.f26029f.setVisibility(0);
            this.m.setVisibility(0);
            this.n.setText(cJRTrainPromoVerify.getBody().getPaytm_promocode());
            if (cJRTrainPromoVerify.getBody().getPromoText() != null) {
                this.m.setText(cJRTrainPromoVerify.getBody().getPromoText());
                this.t = cJRTrainPromoVerify.getBody().getPromoText();
            }
            this.q = cJRTrainPromoVerify.getBody().getPaytm_promocode();
            this.m.setTextColor(getResources().getColor(R.color.color_000000));
            ArrayList<CJRTrainOfferCode> arrayList = this.p;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<CJRTrainOfferCode> it2 = this.p.iterator();
                while (it2.hasNext()) {
                    CJRTrainOfferCode next = it2.next();
                    if (next == null || !next.getCode().equalsIgnoreCase(cJRTrainPromoVerify.getBody().getPaytm_promocode())) {
                        next.setIsOfferApplied(false);
                    } else {
                        next.setIsOfferApplied(true);
                        this.q = cJRTrainPromoVerify.getBody().getPaytm_promocode();
                        this.y = next.getCode();
                    }
                }
                j jVar2 = this.k;
                if (jVar2 != null) {
                    ArrayList<CJRTrainOfferCode> arrayList2 = this.p;
                    String str = this.y;
                    jVar2.f26429a = arrayList2;
                    jVar2.f26432d = str;
                    jVar2.notifyDataSetChanged();
                }
            }
        }
        removeProgressDialog();
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.l.setVisibility(8);
            removeProgressDialog();
            if (this.o) {
                this.o = false;
                HashMap hashMap = new HashMap();
                hashMap.put("train_promocode", this.q);
                hashMap.put("train_promocode_error_message", networkCustomError.getMessage());
                a("train_review_itinerary_promocode_error", this.w, this.x, com.paytm.utility.b.n((Context) this), hashMap);
            }
            String message = networkCustomError.getMessage();
            if (!isFinishing()) {
                if (i2 != 401) {
                    if (i2 != 410) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                            if (networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                com.paytm.utility.b.f((Context) this, networkCustomError.getUrl());
                                return;
                            }
                        }
                        if (i2 != 449) {
                            if (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503")) {
                                if (!message.equalsIgnoreCase("504")) {
                                    if (message.equals("failure_error")) {
                                        if (this.o) {
                                            b(networkCustomError.getAlertMessage());
                                            this.y = null;
                                            if (this.k != null) {
                                                this.k.a(this.y);
                                                return;
                                            }
                                            return;
                                        }
                                        com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                        this.l.setVisibility(8);
                                        return;
                                    } else if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage() != null) {
                                        com.travel.train.b.a();
                                        if (com.travel.train.b.b().a((Context) this, (Exception) networkCustomError, "error.trains@paytm.com")) {
                                            return;
                                        }
                                        if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                            com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(i2));
                                            return;
                                        } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("406")) {
                                            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                            this.l.setVisibility(8);
                                            return;
                                        } else if (this.o) {
                                            b(networkCustomError.getAlertMessage());
                                            this.y = null;
                                            if (this.k != null) {
                                                this.k.a(this.y);
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                            this.l.setVisibility(8);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            if (this.o) {
                                b(networkCustomError.getAlertMessage());
                                this.y = null;
                                if (this.k != null) {
                                    this.k.a(this.y);
                                    return;
                                }
                                return;
                            }
                            this.l.setVisibility(8);
                            return;
                        } else if (this.o) {
                            b(networkCustomError.getAlertMessage());
                            this.y = null;
                            if (this.k != null) {
                                this.k.a(this.y);
                                return;
                            }
                            return;
                        } else {
                            this.l.setVisibility(8);
                            com.paytm.utility.b.b((Context) this, message, networkCustomError.getMessage());
                            return;
                        }
                    }
                }
                com.travel.train.b.a();
                com.travel.common.a b2 = com.travel.train.b.b();
                AJRTrainOffersListActivity.class.getName();
                b2.a((Activity) this, networkCustomError);
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    private void b(String str) {
        removeProgressDialog();
        this.f26026c.setVisibility(8);
        this.o = false;
        this.m.setText(str);
        this.m.setVisibility(0);
        if (this.f26025b.getText() != null && !this.f26025b.getText().toString().isEmpty() && this.f26025b.getText().toString().trim().length() > 0) {
            this.r.setVisibility(0);
        }
        this.m.setTextColor(getResources().getColor(R.color.trains_promo_error));
        this.f26029f.setVisibility(8);
        this.f26028e.setVisibility(0);
        ArrayList<CJRTrainOfferCode> arrayList = this.p;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJRTrainOfferCode> it2 = this.p.iterator();
            while (it2.hasNext()) {
                it2.next().setIsOfferApplied(false);
                j jVar = this.k;
                if (jVar != null) {
                    jVar.notifyDataSetChanged();
                }
            }
        }
    }

    private void a(ArrayList<CJRTrainOfferCode> arrayList) {
        this.k = new j(this, arrayList, this, this.y);
        findViewById(R.id.choose_offer_header).setVisibility(0);
        this.j.setAdapter(this.k);
    }

    public final void a(String str) {
        a("train_review_itinerary_promocode_field_clicked", this.w, this.x, com.paytm.utility.b.n((Context) this), new HashMap());
        String replace = str.trim().replace(" ", "");
        if (!TextUtils.isEmpty(replace)) {
            c(replace);
        }
    }

    public final void a() {
        this.f26025b.setText((CharSequence) null);
        this.r.setVisibility(8);
        this.f26028e.setVisibility(0);
        this.m.setVisibility(8);
        this.f26029f.setVisibility(8);
        this.y = null;
        this.q = null;
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        this.A = str;
        if (str.length() == 12) {
            d();
        } else {
            e();
        }
    }

    private void d() {
        hideKeyboard();
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        new c(this, this, this.A);
    }

    private void e() {
        hideKeyboard();
        this.q = this.A;
        if (this.v != null) {
            StringBuilder sb = new StringBuilder();
            com.travel.train.b.a();
            sb.append(com.travel.train.b.b().v());
            sb.append(this.v);
            String b2 = o.b((Context) this, com.paytm.utility.b.s(this, sb.toString()));
            if (!URLUtil.isValidUrl(b2)) {
                this.l.setVisibility(8);
                this.m.setText(getResources().getString(R.string.msg_invalid_url_train));
                this.m.setVisibility(0);
            } else if (com.paytm.utility.b.c((Context) this)) {
                try {
                    showProgressDialog(this, getString(R.string.please_wait_progress_msg));
                    a(b2, this.A);
                } catch (t e2) {
                    this.l.setVisibility(8);
                    this.m.setText(e2.getMessage());
                    this.m.setVisibility(0);
                }
            } else {
                this.l.setVisibility(8);
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_train));
            }
        }
    }

    public void onBackPressed() {
        f();
        super.onBackPressed();
    }

    private void a(String str, String str2) throws t {
        this.o = true;
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.TRAIN;
        bVar.n = a.b.SILENT;
        bVar.o = g.o;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = str;
        bVar.f42882f = n.c((Context) this);
        bVar.f42884h = d(str2).toString();
        bVar.f42885i = new CJRTrainPromoVerify();
        bVar.j = this;
        a l2 = bVar.l();
        l2.f42859c = false;
        l2.a();
    }

    private static JSONObject d(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(PayUtility.PROMO_CODE, str);
            } catch (JSONException e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
        return jSONObject;
    }

    public void hideKeyboard() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f26025b.getWindowToken(), 0);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public void onEditViewClick(View view) {
        f();
    }

    private void f() {
        Intent intent = new Intent();
        String str = this.q;
        if (str != null) {
            intent.putExtra("cart_applied_promo", str);
        } else {
            String str2 = this.y;
            if (str2 != null) {
                intent.putExtra("cart_applied_promo", str2);
            }
        }
        String str3 = this.t;
        if (str3 != null) {
            intent.putExtra("offer_text", str3);
        }
        intent.putExtra("is_applied", this.u);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r6.size() <= 0) goto L_0x0008;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r1 = this;
            if (r6 == 0) goto L_0x0008
            int r0 = r6.size()     // Catch:{ Exception -> 0x0036 }
            if (r0 > 0) goto L_0x000d
        L_0x0008:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0036 }
            r6.<init>()     // Catch:{ Exception -> 0x0036 }
        L_0x000d:
            java.lang.String r0 = "train_origin_city"
            r6.put(r0, r3)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r3 = "train_destination_city"
            r6.put(r3, r4)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r3 = "train_user_id"
            if (r5 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            java.lang.String r5 = ""
        L_0x0021:
            r6.put(r3, r5)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r3 = "screenName"
            java.lang.String r4 = "/trains/review-itinerary"
            r6.put(r3, r4)     // Catch:{ Exception -> 0x0036 }
            com.travel.train.b.a()     // Catch:{ Exception -> 0x0036 }
            com.travel.common.a r3 = com.travel.train.b.b()     // Catch:{ Exception -> 0x0036 }
            r3.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r6, (android.content.Context) r1)     // Catch:{ Exception -> 0x0036 }
            return
        L_0x0036:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.c(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainOffersListActivity.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void a(boolean z2, String str) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (z2) {
            e();
        } else {
            b(str);
        }
    }

    static /* synthetic */ void a(AJRTrainOffersListActivity aJRTrainOffersListActivity, boolean z2) {
        if (z2) {
            aJRTrainOffersListActivity.f26026c.setVisibility(0);
        } else {
            aJRTrainOffersListActivity.f26026c.setVisibility(8);
        }
    }
}
