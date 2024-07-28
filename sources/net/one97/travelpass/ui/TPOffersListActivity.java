package net.one97.travelpass.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.travelpass.R;
import net.one97.travelpass.d;
import net.one97.travelpass.e.k;
import net.one97.travelpass.model.TPPromoVerifyData;
import net.one97.travelpass.model.TravelPassPromoOffers;
import net.one97.travelpass.ui.a.a;
import net.one97.travelpass.ui.fragment.TPBaseActivity;
import org.json.JSONObject;

public class TPOffersListActivity extends TPBaseActivity implements b, a.b {

    /* renamed from: a  reason: collision with root package name */
    private static String f30541a = "TPOffersListActivity";
    private boolean A = false;
    private String B;
    private int C;
    private int D;
    private double E;
    private String F;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f30542b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f30543c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f30544d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f30545e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f30546f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f30547g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f30548h;

    /* renamed from: i  reason: collision with root package name */
    private int f30549i;
    private RecyclerView j;
    /* access modifiers changed from: private */
    public a k;
    private LottieAnimationView l;
    private TextView m;
    private TextView n;
    private boolean o;
    private ArrayList<CJROfferCode> p = new ArrayList<>();
    private String q;
    /* access modifiers changed from: private */
    public ImageView r;
    private Button s;
    private String t;
    private boolean u;
    /* access modifiers changed from: private */
    public String v;
    private TPPromoVerifyData w;
    /* access modifiers changed from: private */
    public String x;
    private ProgressDialog y;
    private boolean z = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_tp_offer_lyt);
        setTitle(getResources().getString(R.string.apply_promo_code));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_offers_new);
        ((TextView) toolbar.findViewById(R.id.title)).setText(getResources().getString(R.string.apply_promo_code));
        TextView textView = (TextView) toolbar.findViewById(R.id.doneButton);
        textView.setText(getResources().getString(R.string.tp_done));
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TPOffersListActivity.this.f();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.apply_tick_image);
        ResourceUtils.loadTPassImagesFromCDN(imageView, "close_2.png", false, true, n.a.V1);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TPOffersListActivity.b(TPOffersListActivity.this);
            }
        });
        ((ImageView) toolbar.findViewById(R.id.toolbar_btn_back)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TPOffersListActivity.this.onBackPressed();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().b(false);
        this.s = (Button) findViewById(R.id.network_retry_btn);
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TPOffersListActivity.this.b();
            }
        });
        this.f30547g = (RelativeLayout) findViewById(R.id.offers_layout);
        this.f30548h = (LinearLayout) findViewById(R.id.no_network);
        this.f30542b = (EditText) findViewById(R.id.edit_txt_promocode);
        this.l = (LottieAnimationView) findViewById(R.id.update_progress_bar_offers);
        this.f30545e = (RelativeLayout) findViewById(R.id.promocode_input_lyt);
        this.f30546f = (RelativeLayout) findViewById(R.id.promocode_success_lyt);
        this.m = (TextView) findViewById(R.id.promo_status_message);
        this.n = (TextView) findViewById(R.id.success_promo_code);
        this.r = (ImageView) findViewById(R.id.promo_remove_image);
        ResourceUtils.loadTPassImagesFromCDN(this.r, "close_2.png", false, true, n.a.V1);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TPOffersListActivity.this.f30542b.setText((CharSequence) null);
                TPOffersListActivity.this.r.setVisibility(8);
                TPOffersListActivity.this.f30545e.setVisibility(0);
                TPOffersListActivity.this.f30546f.setVisibility(8);
                String unused = TPOffersListActivity.this.v = null;
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.f30542b.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    TPOffersListActivity.a(TPOffersListActivity.this, true);
                    TPOffersListActivity.this.r.setVisibility(0);
                    return;
                }
                TPOffersListActivity.a(TPOffersListActivity.this, false);
            }
        });
        this.f30543c = (RelativeLayout) findViewById(R.id.apply_btn_lyt);
        this.f30543c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                String replace = TPOffersListActivity.this.f30542b.getText().toString().trim().replace(" ", "");
                if (!TextUtils.isEmpty(replace) && !replace.matches("[a-zA-Z0-9.? ]*")) {
                    TPOffersListActivity tPOffersListActivity = TPOffersListActivity.this;
                    tPOffersListActivity.b(tPOffersListActivity.getString(R.string.travelpass_enter_valid_promo_code));
                } else if (!TextUtils.isEmpty(replace)) {
                    new HashMap().put("train_promocode", replace);
                    String unused = TPOffersListActivity.this.x = replace;
                    TPOffersListActivity.this.d();
                }
            }
        });
        this.f30544d = (RelativeLayout) findViewById(R.id.promocode_lyt);
        this.j = (RecyclerView) findViewById(R.id.offers_list);
        this.j.setHasFixedSize(true);
        this.j.setLayoutManager(new LinearLayoutManager(this));
        this.j.addItemDecoration(new com.travel.widget.a(this));
        d.a();
        ((TextView) findViewById(R.id.wallet_loyality_cash_back_text)).setText(d.a().f30317a.a());
        this.f30549i = com.paytm.utility.b.f((Context) this);
        this.f30543c.getLayoutParams().width = this.f30549i * 5;
        this.f30544d.getLayoutParams().height = (int) (((double) this.f30549i) * 2.5d);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("pass_id")) {
                this.B = intent.getStringExtra("pass_id");
            }
            if (intent.hasExtra("categoryId")) {
                this.C = intent.getIntExtra("categoryId", -1);
            }
            if (intent.hasExtra("quantity")) {
                this.D = intent.getIntExtra("quantity", -1);
            }
            if (intent.hasExtra("price")) {
                this.E = intent.getDoubleExtra("price", -1.0d);
            }
            if (intent.hasExtra("subCategory")) {
                this.F = intent.getStringExtra("subCategory");
            }
        }
        this.k = new a(this, this.p, this, this.v);
        findViewById(R.id.choose_offer_header).setVisibility(0);
        this.j.setAdapter(this.k);
        b();
        String str = this.v;
        if (str != null) {
            this.x = str;
            d();
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

    /* access modifiers changed from: private */
    public void b() {
        if (com.paytm.utility.b.c((Context) this)) {
            this.l.setVisibility(0);
            this.f30548h.setVisibility(8);
            this.f30547g.setVisibility(0);
            c();
            return;
        }
        this.f30548h.setVisibility(0);
        this.f30547g.setVisibility(8);
    }

    private void c() {
        try {
            d.a();
            String a2 = d.a().f30317a.a("tpassFetchPromos");
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pass_id", this.B);
            jSONObject.put("categoryId", this.C);
            if (URLUtil.isValidUrl(a2)) {
                String s2 = com.paytm.utility.b.s(this, a2);
                new k();
                String a3 = k.a(this, s2);
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.TRAVEL_PASS;
                bVar.n = a.b.SILENT;
                bVar.o = "travel_pass_offer_list_page";
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = a3;
                bVar.f42884h = jSONObject.toString();
                bVar.f42882f = hashMap;
                bVar.f42885i = new TravelPassPromoOffers();
                bVar.j = this;
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        e();
        this.f30543c.setVisibility(8);
        this.o = false;
        this.m.setText(str);
        this.m.setVisibility(0);
        if (this.f30542b.getText() != null && !this.f30542b.getText().toString().isEmpty() && this.f30542b.getText().toString().trim().length() > 0) {
            this.r.setVisibility(0);
        }
        this.m.setTextColor(getResources().getColor(R.color.tp_promo_error));
        this.f30546f.setVisibility(8);
        this.f30545e.setVisibility(0);
        ArrayList<CJROfferCode> arrayList = this.p;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJROfferCode> it2 = this.p.iterator();
            while (it2.hasNext()) {
                it2.next().setIsOfferApplied(false);
                net.one97.travelpass.ui.a.a aVar = this.k;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
            }
        }
    }

    public final void a(String str) {
        if (str != null && !str.trim().isEmpty()) {
            String replace = str.trim().replace(" ", "");
            if (!TextUtils.isEmpty(replace)) {
                this.x = replace;
                d();
            }
        }
    }

    public final void a() {
        this.f30542b.setText((CharSequence) null);
        this.r.setVisibility(8);
        this.f30545e.setVisibility(0);
        this.m.setVisibility(8);
        this.f30546f.setVisibility(8);
        this.v = null;
        this.q = null;
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            d.a();
            String a2 = d.a().f30317a.a("tpassPromoVerify");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("subCategory", this.F);
            jSONObject.put(PayUtility.PROMO_CODE, this.x);
            jSONObject.put("quantity", this.D);
            jSONObject.put("price", this.E);
            if (com.paytm.utility.b.c((Context) this)) {
                this.l.setVisibility(0);
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.TRAVEL_PASS;
                bVar.n = a.b.SILENT;
                bVar.o = "travel_pass_offer_list_page";
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = a2;
                bVar.f42884h = jSONObject.toString();
                bVar.f42882f = hashMap;
                bVar.f42885i = new TPPromoVerifyData();
                bVar.j = this;
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        ProgressDialog progressDialog = this.y;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.y.dismiss();
            this.y = null;
        }
    }

    public void onBackPressed() {
        f();
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public void f() {
        Intent intent = new Intent();
        TPPromoVerifyData tPPromoVerifyData = this.w;
        if (!(tPPromoVerifyData == null || tPPromoVerifyData.getBody().getPromoStatus() == null || !this.w.getBody().getPromoStatus().equalsIgnoreCase("success"))) {
            intent.putExtra("promo_data", this.w);
        }
        setResult(-1, intent);
        finish();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.l.setVisibility(8);
        if ((iJRPaytmDataModel instanceof TravelPassPromoOffers) && iJRPaytmDataModel != null) {
            this.z = true;
            findViewById(R.id.choose_offer_header).setVisibility(0);
            TravelPassPromoOffers travelPassPromoOffers = (TravelPassPromoOffers) iJRPaytmDataModel;
            this.m.setVisibility(8);
            if (travelPassPromoOffers != null && travelPassPromoOffers.getBody().getmOffers().getPromotions() != null) {
                this.p = (ArrayList) travelPassPromoOffers.getBody().getmOffers().getPromotions();
                ArrayList<CJROfferCode> arrayList = this.p;
                ImageView imageView = (ImageView) findViewById(R.id.banner_image);
                if (arrayList == null || arrayList.size() <= 0) {
                    this.v = null;
                    net.one97.travelpass.ui.a.a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(this.v);
                    }
                    ResourceUtils.loadTPassImagesFromCDN(imageView, "no_offers_image.png", false, true, n.a.V1);
                    findViewById(R.id.no_offers_layout).setVisibility(0);
                    findViewById(R.id.offers_list_lyt).setVisibility(8);
                    findViewById(R.id.choose_offer_header).setVisibility(8);
                    return;
                }
                this.k.a(arrayList, this.v);
                findViewById(R.id.choose_offer_header).setVisibility(0);
            }
        } else if (iJRPaytmDataModel instanceof TPPromoVerifyData) {
            this.w = (TPPromoVerifyData) iJRPaytmDataModel;
            TPPromoVerifyData tPPromoVerifyData = this.w;
            if (tPPromoVerifyData != null) {
                tPPromoVerifyData.getBody().setPromoCode(this.x);
                TPPromoVerifyData tPPromoVerifyData2 = this.w;
                if (tPPromoVerifyData2 == null || tPPromoVerifyData2.getBody().getPromoStatus() == null || !tPPromoVerifyData2.getBody().getPromoStatus().equalsIgnoreCase("success")) {
                    if (!(tPPromoVerifyData2 == null || tPPromoVerifyData2.getBody().getPromoStatus() == null || !tPPromoVerifyData2.getBody().getPromoStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE))) {
                        b(tPPromoVerifyData2.getBody().getPromoFailureText());
                        this.v = null;
                        net.one97.travelpass.ui.a.a aVar2 = this.k;
                        if (aVar2 != null) {
                            aVar2.a(this.v);
                        }
                    }
                    this.u = false;
                } else {
                    this.u = true;
                    this.o = false;
                    this.r.setVisibility(0);
                    this.f30545e.setVisibility(8);
                    this.f30546f.setVisibility(0);
                    this.m.setVisibility(8);
                    this.n.setText(tPPromoVerifyData2.getBody().getPromoCode());
                    if (tPPromoVerifyData2.getBody().getPromoCode() != null) {
                        this.m.setVisibility(0);
                        this.m.setText(tPPromoVerifyData2.getBody().getPromoStatusText());
                        this.t = tPPromoVerifyData2.getBody().getPromoStatusText();
                    }
                    this.q = tPPromoVerifyData2.getBody().getPromoCode();
                    this.m.setTextColor(getResources().getColor(R.color.color_000000));
                    ArrayList<CJROfferCode> arrayList2 = this.p;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        Iterator<CJROfferCode> it2 = this.p.iterator();
                        while (it2.hasNext()) {
                            CJROfferCode next = it2.next();
                            if (next == null || !next.getCode().equalsIgnoreCase(tPPromoVerifyData2.getBody().getPromoCode())) {
                                next.setIsOfferApplied(false);
                            } else {
                                next.setIsOfferApplied(true);
                                this.q = tPPromoVerifyData2.getBody().getPromoCode();
                                this.v = next.getCode();
                            }
                        }
                        net.one97.travelpass.ui.a.a aVar3 = this.k;
                        if (aVar3 != null) {
                            aVar3.a(this.p, this.v);
                        }
                    }
                }
                e();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.l.setVisibility(8);
            net.one97.travelpass.model.b bVar = new net.one97.travelpass.model.b();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        bVar = (net.one97.travelpass.model.b) new f().a(new String(networkResponse.data), bVar.getClass());
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (this.o) {
                this.o = false;
                HashMap hashMap = new HashMap();
                hashMap.put("travelpass_promocode", this.q);
                hashMap.put("travelpass_error_message", networkCustomError.getMessage());
            }
            String message = networkCustomError.getMessage();
            if (!isFinishing()) {
                if (i2 == 401 || i2 == 410) {
                    super.a(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError);
                }
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    super.a(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError);
                }
                if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("449")) {
                    if (TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503") && !message.equalsIgnoreCase("504"))) {
                        if (TextUtils.isEmpty(message) || !message.equals("failure_error")) {
                            if (networkCustomError.getMessage() == null) {
                                return;
                            }
                            if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                return;
                            }
                            if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("406")) {
                                com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), getResources().getString(R.string.tp_network_error_message) + " " + networkCustomError.getUrl());
                                this.l.setVisibility(8);
                            } else if (this.o) {
                                if (bVar.getStatus() == null) {
                                    b(networkCustomError.getAlertMessage());
                                } else if (bVar.getStatus().getMessage().f30487a != null) {
                                    b(bVar.getStatus().getMessage().f30487a);
                                }
                                this.v = null;
                                if (this.k != null) {
                                    this.k.a(this.v);
                                }
                            } else {
                                if (bVar.getStatus() == null) {
                                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                }
                                this.l.setVisibility(8);
                            }
                        } else if (this.o) {
                            if (bVar.getStatus() == null) {
                                b(networkCustomError.getAlertMessage());
                            } else if (bVar.getStatus().getMessage().f30487a != null) {
                                b(bVar.getStatus().getMessage().f30487a);
                            }
                            this.v = null;
                            if (this.k != null) {
                                this.k.a(this.v);
                            }
                        } else {
                            if (bVar.getStatus() == null) {
                                com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                            }
                            this.l.setVisibility(8);
                        }
                    } else if (this.o) {
                        if (bVar.getStatus() == null) {
                            b(networkCustomError.getAlertMessage());
                        } else if (bVar.getStatus().getMessage().f30487a != null) {
                            b(bVar.getStatus().getMessage().f30487a);
                        }
                        this.v = null;
                        if (this.k != null) {
                            this.k.a(this.v);
                        }
                    } else {
                        this.l.setVisibility(8);
                    }
                } else if (this.o) {
                    b(networkCustomError.getAlertMessage());
                    this.v = null;
                    if (this.k != null) {
                        this.k.a(this.v);
                    }
                } else {
                    this.l.setVisibility(8);
                    com.paytm.utility.b.b((Context) this, message, networkCustomError.getMessage());
                }
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    static /* synthetic */ void b(TPOffersListActivity tPOffersListActivity) {
        if (!TextUtils.isEmpty(tPOffersListActivity.v)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(tPOffersListActivity);
            builder.setMessage(Html.fromHtml(String.format(tPOffersListActivity.getString(R.string.remove_promo_cart), new Object[]{tPOffersListActivity.v})));
            builder.setPositiveButton(tPOffersListActivity.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    String unused = TPOffersListActivity.this.v = null;
                    TPOffersListActivity.this.a();
                    if (TPOffersListActivity.this.k != null) {
                        TPOffersListActivity.this.k.a(TPOffersListActivity.this.v);
                    }
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    static /* synthetic */ void a(TPOffersListActivity tPOffersListActivity, boolean z2) {
        if (z2) {
            tPOffersListActivity.f30543c.setVisibility(0);
        } else {
            tPOffersListActivity.f30543c.setVisibility(8);
        }
    }
}
