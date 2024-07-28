package com.paytmmall.artifact.search.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.entity.CJRDetailProduct;
import com.paytmmall.artifact.cart.entity.StringModel;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.common.a.a;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.e;
import com.paytmmall.artifact.d.h;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.m;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.u;
import com.paytmmall.artifact.d.v;
import com.paytmmall.artifact.grid.entity.CJRFilterValue;
import com.paytmmall.artifact.grid.entity.CJRFrontEndFilter;
import com.paytmmall.artifact.grid.entity.CJRGrid;
import com.paytmmall.artifact.grid.entity.CJRGridMeta;
import com.paytmmall.artifact.grid.entity.CJRGridProduct;
import com.paytmmall.artifact.grid.entity.CJRSearchSuggestion;
import com.paytmmall.artifact.search.a.b;
import com.paytmmall.artifact.search.a.c;
import com.paytmmall.artifact.search.entity.CJRSearchCuration;
import com.paytmmall.artifact.search.entity.CJRSearchLayout;
import com.paytmmall.artifact.search.entity.CJRSearchPage;
import com.paytmmall.artifact.widget.RoboTextView;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.SearchCostants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRSearchActivity extends BaseActivity implements b.a, c.b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<CJRSearchLayout> f15950a;
    private CJRHomePageItem A;
    /* access modifiers changed from: private */
    public boolean B = false;
    /* access modifiers changed from: private */
    public String C;
    private String D;
    private String E = "";
    private String F;
    private String G;
    private String H;
    private HashMap<String, String> I;
    /* access modifiers changed from: private */
    public boolean J = false;
    private RoboTextView K;
    private TextView L;
    private String M = Payload.TYPE_STORE;
    private View.OnClickListener N;
    /* access modifiers changed from: private */
    public String O = P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT;
    private View P;
    private RadioGroup Q;
    private RadioButton R;
    private RadioButton S;
    private String T;
    private String U = "";
    /* access modifiers changed from: private */
    public HashMap<String, String> V;

    /* renamed from: b  reason: collision with root package name */
    public String f15951b;

    /* renamed from: c  reason: collision with root package name */
    public String f15952c;

    /* renamed from: d  reason: collision with root package name */
    public String f15953d;

    /* renamed from: e  reason: collision with root package name */
    public String f15954e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15955f;

    /* renamed from: g  reason: collision with root package name */
    private String f15956g = "AJRSearchActivity";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public SearchView f15957h;

    /* renamed from: i  reason: collision with root package name */
    private ActionBar f15958i;
    private ListView j;
    private ScrollView k;
    private RecyclerView l;
    private TextView m;
    private TextView n;
    private RecyclerView o;
    /* access modifiers changed from: private */
    public c p;
    private b q;
    private CJRSearchPage r;
    /* access modifiers changed from: private */
    public CJRSearchPage s;
    /* access modifiers changed from: private */
    public String t = "";
    private TextView u;
    private ColorDrawable v;
    /* access modifiers changed from: private */
    public RelativeLayout w;
    private CharSequence x;
    private boolean y;
    private boolean z;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.f15958i = getSupportActionBar();
        ActionBar actionBar = this.f15958i;
        if (actionBar != null) {
            actionBar.b(true);
            this.f15958i.a((CharSequence) "");
            this.f15958i.b();
            this.f15958i.a(R.layout.mall_search_action_bar_layoyt);
            this.f15958i.c(R.drawable.action_bar_logo_mall);
            this.f15958i.b(R.drawable.action_bar_logo_mall);
            this.f15958i.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
            this.f15958i.a(0.0f);
        }
        this.f15957h = (SearchView) findViewById(R.id.search_action_bar);
        this.f15957h.setIconifiedByDefault(false);
        this.f15957h.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
        this.x = getIntent().getStringExtra(CLPConstants.EXTRA_INTENT_HEADER_EDITABLE);
        this.y = getIntent().getBooleanExtra("is_from_search", false);
        this.z = getIntent().getBooleanExtra("is_from_grid", false);
        this.G = getIntent().getStringExtra(AppConstants.TAG_SITE_ID);
        this.F = getIntent().getStringExtra(AppConstants.TAG_CHILD_SITE_ID);
        this.f15954e = getIntent().getStringExtra("badge_url");
        this.f15951b = getIntent().getStringExtra("logo_url");
        this.f15952c = getIntent().getStringExtra("banner_url");
        this.f15953d = getIntent().getStringExtra("display_title");
        this.H = getIntent().getStringExtra("brand_tag_slot");
        this.I = (HashMap) getIntent().getSerializableExtra(CLPConstants.EXTRA_INTENT_CONTEXT_PARAMS_OBJECT);
        if (getIntent().getStringExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME) != null) {
            this.M = getIntent().getStringExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME);
        }
        try {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            if (!(cJRHomePageItem == null || cJRHomePageItem.getQueryString() == null)) {
                this.D = cJRHomePageItem.getQueryString();
            }
        } catch (Exception unused) {
        }
        HashMap<String, String> hashMap = this.I;
        if (hashMap != null && hashMap.size() > 0) {
            this.J = true;
            if (this.I.get(CLPConstants.DISCOVERABILITY) != null) {
                this.O = this.I.get(CLPConstants.DISCOVERABILITY);
            }
        }
        String b2 = u.a(this).b("search_cookie", "", true);
        if (!TextUtils.isEmpty(b2)) {
            str = b2 + ";_ga=" + d.h((Context) this);
        } else {
            str = "_ga=" + d.h((Context) this);
        }
        this.T = str;
        if (!this.J || this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
            a();
        } else {
            RelativeLayout relativeLayout = this.w;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        setContentView(R.layout.mall_activity_search);
        this.j = (ListView) findViewById(R.id.listView);
        this.k = (ScrollView) findViewById(R.id.no_search_results_view);
        this.m = (TextView) findViewById(R.id.shopping_offers_header);
        this.l = (RecyclerView) findViewById(R.id.shopping_offers_rv);
        this.n = (TextView) findViewById(R.id.recently_viewed_header_tv);
        this.o = (RecyclerView) findViewById(R.id.recently_viewed_rv);
        this.u = (TextView) findViewById(R.id.search_suggestion_keywords_tv);
        this.v = new ColorDrawable(getResources().getColor(R.color.separators));
        this.p = new c(this, new CJRSearchPage(), this);
        this.q = new b(this, new CJRSearchPage(), this);
        this.j.setAdapter(this.q);
        this.w = (RelativeLayout) findViewById(R.id.lyt_search_progress_bar);
        this.K = (RoboTextView) findViewById(R.id.search_across_tv);
        this.L = (TextView) findViewById(R.id.no_result_txt_view);
        this.P = findViewById(R.id.store_search_layout);
        this.Q = (RadioGroup) findViewById(R.id.store_select_radio_group);
        this.S = (RadioButton) findViewById(R.id.radio_button_2);
        this.R = (RadioButton) findViewById(R.id.radio_button_1);
        this.N = new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSearchActivity.this.a(view);
            }
        };
        this.Q.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                AJRSearchActivity.this.a(radioGroup, i2);
            }
        });
        if (this.J) {
            if (!(this.I.get("store_id") == null && this.I.get("merchant_id") == null)) {
                this.j.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.w;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            if (this.I.get("store_id") == null || !this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
                this.P.setVisibility(8);
            } else {
                this.P.setVisibility(0);
            }
        } else {
            this.P.setVisibility(8);
        }
        ArrayList<CJRSearchLayout> c2 = v.a().c();
        f15950a = c2;
        if (c2 == null) {
            f15950a = new ArrayList<>();
        }
        try {
            com.paytmmall.artifact.common.a.b.a("screen_loaded_search", "Search Screen", getApplicationContext());
        } catch (Exception unused2) {
        }
        if (getIntent().hasExtra("query")) {
            String stringExtra = getIntent().getStringExtra("query");
            this.B = false;
            this.C = "organic";
            this.f15957h.setQuery(stringExtra, true);
            e(stringExtra);
            this.f15957h.clearFocus();
        }
        this.f15957h.setQueryHint(getResources().getString(R.string.search_bar_hint));
        if (this.J) {
            if (!TextUtils.isEmpty(this.I.get("searchLabel"))) {
                this.f15957h.setQueryHint(e());
            }
            if (!TextUtils.isEmpty(this.I.get("store_id")) && this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
                this.P.setVisibility(0);
                this.R.setText(getString(R.string.search_within_store, new Object[]{this.M}));
                this.f15957h.setQueryHint(getResources().getString(R.string.search));
            }
            if (this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT)) {
                this.f15957h.setQueryHint(getResources().getString(R.string.search_within_offline_store, new Object[]{this.M}));
            }
            if (!TextUtils.isEmpty(this.I.get("merchant_id"))) {
                this.R.setText(getResources().getString(R.string.search_seller));
                if (this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT)) {
                    this.P.setVisibility(8);
                    this.f15957h.setQueryHint(e());
                } else {
                    this.P.setVisibility(0);
                    this.f15957h.setQueryHint(getResources().getString(R.string.search));
                }
            }
            this.S.setText(getResources().getString(R.string.search_across_btn_txt));
            this.R.setSelected(true);
        } else {
            this.P.setVisibility(8);
        }
        CharSequence charSequence = this.x;
        if (charSequence != null && !charSequence.toString().isEmpty() && this.y) {
            this.f15957h.setQuery(this.x, false);
        }
        ArrayList<CJRSearchLayout> arrayList = f15950a;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f15957h.setQuery(f(f15950a.get(0).getText()), false);
        }
        this.f15957h.setOnQueryTextListener(new SearchView.b() {
            public final boolean a(String str) {
                boolean unused = AJRSearchActivity.this.B = false;
                HashMap unused2 = AJRSearchActivity.this.V = null;
                String unused3 = AJRSearchActivity.this.C = "organic";
                AJRSearchActivity.this.e(str);
                AJRSearchActivity.this.f15957h.clearFocus();
                return true;
            }

            public final boolean b(String str) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        str = str.replaceAll("\\s+", " ");
                    }
                    String unused = AJRSearchActivity.this.t = str;
                    AJRSearchActivity.this.i();
                    if (str != null) {
                        if (str.length() > 2) {
                            if (AJRSearchActivity.this.J) {
                                if (!AJRSearchActivity.this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
                                    if (AJRSearchActivity.this.w != null) {
                                        AJRSearchActivity.this.w.setVisibility(8);
                                    }
                                    return false;
                                }
                            }
                            AJRSearchActivity.this.a(str);
                            return false;
                        }
                    }
                    if (str != null && str.length() <= 2) {
                        if (AJRSearchActivity.this.p != null) {
                            AJRSearchActivity.this.p.a(str);
                        }
                        if (AJRSearchActivity.this.s != null) {
                            AJRSearchActivity.this.a(AJRSearchActivity.this.s);
                        } else {
                            if (AJRSearchActivity.this.w != null) {
                                if (AJRSearchActivity.this.J) {
                                    AJRSearchActivity.this.w.setVisibility(8);
                                } else {
                                    AJRSearchActivity.this.w.setVisibility(0);
                                }
                            }
                            if (!AJRSearchActivity.this.J || AJRSearchActivity.this.O.equalsIgnoreCase(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
                                AJRSearchActivity.this.a();
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
                return false;
            }
        });
        if (!TextUtils.isEmpty(this.D)) {
            this.f15957h.setQuery(this.D, false);
            this.t = this.D;
            a(this.t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.J && !TextUtils.isEmpty(this.I.get("merchant_id"))) {
            this.f15957h.setQueryHint(e());
        }
        this.S.setChecked(true);
        this.C = "organic";
        e(this.t);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.radio_button_1) {
            HashMap<String, String> hashMap = this.I;
            if (hashMap != null && hashMap.size() > 0) {
                this.J = true;
                if (this.I.get(CLPConstants.DISCOVERABILITY) != null) {
                    this.O = this.I.get(CLPConstants.DISCOVERABILITY);
                }
                this.j.setVisibility(8);
            }
            this.K.setVisibility(0);
        } else if (i2 == R.id.radio_button_2) {
            this.O = P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT;
            this.j.setVisibility(0);
            this.K.setVisibility(8);
            a();
        }
    }

    public final void a() {
        try {
            a.a();
            String a2 = a.a("popularsearch", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                String g2 = d.g(this, a2);
                String h2 = h();
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(h2)) {
                    hashMap.put("search_user_id", h2);
                    hashMap.put("Cookie", this.T);
                }
                a((Map<String, String>) hashMap, com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN);
                final String k2 = k(g2);
                if (d.a((Context) this)) {
                    com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, k2, (String) null, hashMap, new CJRSearchPage(), new com.paytmmall.b.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            AJRSearchActivity.a(AJRSearchActivity.this, (CJRSearchPage) iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            AJRSearchActivity.this.a(networkCustomError, k2);
                        }
                    });
                } else {
                    d();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void d() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRSearchActivity.this.b(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (d.a(getApplicationContext())) {
            a();
        } else {
            d();
        }
    }

    public final void a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            com.paytmmall.artifact.common.a.a.a();
            sb.append(com.paytmmall.artifact.common.a.a.a("autosuggest", (String) null));
            sb.append("?s=");
            sb.append(URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8).replace("+", "%20"));
            String g2 = d.g(this, sb.toString());
            if (!URLUtil.isValidUrl(g2)) {
                d.b(this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                return;
            }
            if (this.J) {
                g2 = l(g2);
            }
            String h2 = h();
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(h2)) {
                hashMap.put("search_user_id", h2);
                hashMap.put("Cookie", this.T);
            }
            a((Map<String, String>) hashMap, com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN);
            final String k2 = k(g2);
            if (d.a((Context) this)) {
                com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, k2, (String) null, hashMap, new CJRSearchPage(), new com.paytmmall.b.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AJRSearchActivity.b(AJRSearchActivity.this, (CJRSearchPage) iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AJRSearchActivity.this.a(networkCustomError, k2);
                    }
                });
            } else {
                d(k2);
            }
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private void d(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRSearchActivity.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (d.a(getApplicationContext())) {
            a(str);
        } else {
            d(str);
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRSearchPage cJRSearchPage) {
        this.q.a(cJRSearchPage);
        this.j.setAdapter(this.q);
    }

    private void a(CJRSearchPage cJRSearchPage, boolean z2) {
        String str = this.t;
        if (str == null) {
            return;
        }
        if (z2) {
            if (str.length() <= 2) {
                a(cJRSearchPage);
            }
        } else if (str.length() > 2) {
            c cVar = this.p;
            cVar.f15927a = cJRSearchPage.getKeyWordsLayoutList();
            cVar.f15928b = cJRSearchPage.getProductsLayoutList();
            cVar.f15929c = cJRSearchPage.getmSearchPopularProductsList();
            cVar.notifyDataSetChanged();
            c cVar2 = this.p;
            if (cVar2 != null) {
                cVar2.a(this.t);
            }
            this.j.setAdapter(this.p);
        }
    }

    public void onDestroy() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void onResume() {
        this.U = "";
        this.V = null;
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private String e() {
        String string = getResources().getString(R.string.search_bar_hint);
        if (TextUtils.isEmpty(this.I.get("searchLabel"))) {
            return string;
        }
        String str = this.I.get("searchLabel");
        return TextUtils.isEmpty(str) ? string : str;
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        try {
            a(str, f());
            com.paytmmall.artifact.common.a.a.a();
            String a2 = com.paytmmall.artifact.common.a.a.a("searchurl_v2", (String) null);
            if (URLUtil.isValidUrl(a2) && !TextUtils.isEmpty(str)) {
                String trim = str.trim();
                this.A = new CJRHomePageItem();
                this.A.setSearchUrl(a2);
                this.A.setSearcKey(trim);
                this.f15955f = false;
                a(a2, trim);
                d(trim, "");
            }
        } catch (Exception unused) {
        }
    }

    private static String f(String str) {
        try {
            return URLDecoder.decode(str);
        } catch (Exception unused) {
            return str;
        }
    }

    private String[] f() {
        CJRSearchPage cJRSearchPage = this.r;
        if (cJRSearchPage == null || cJRSearchPage.getKeyWordsLayoutList() == null || this.r.getKeyWordsLayoutList().size() <= 0) {
            return null;
        }
        String[] strArr = new String[5];
        int i2 = 0;
        Iterator<CJRSearchLayout> it2 = this.r.getKeyWordsLayoutList().iterator();
        while (it2.hasNext()) {
            CJRSearchLayout next = it2.next();
            if (i2 >= 5) {
                break;
            }
            strArr[i2] = next.getText();
            i2++;
        }
        return strArr;
    }

    private void a(String str, String str2) {
        String str3;
        try {
            this.w.setVisibility(0);
            i();
            if (Uri.parse(str).getQuery() != null) {
                str3 = str + "&userQuery=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&from=" + URLEncoder.encode(this.C, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&cat_tree=1&curated=" + a(getIntent());
            } else {
                str3 = str + "?userQuery=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&from=" + URLEncoder.encode(this.C, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&cat_tree=1&curated=" + a(getIntent());
            }
            if (this.V != null && this.V.size() > 0) {
                Uri.Builder buildUpon = Uri.parse(str3).buildUpon();
                for (Map.Entry next : this.V.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                str3 = buildUpon.build().toString();
            }
            String h2 = h(str3);
            if (this.J) {
                h2 = l(h2);
            }
            if (this.A != null) {
                this.A.setSearchUrl(h2);
            }
            if (this.F != null && this.E != null && this.E.contains("Brand Store") && this.f15955f) {
                h2 = h2 + "&child_site_id=" + this.F;
            }
            if (!URLUtil.isValidUrl(h2)) {
                d.b(this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                return;
            }
            String c2 = d.c((Context) this, h2);
            HashMap hashMap = new HashMap();
            String h3 = h();
            String k2 = k(g(c2));
            if (!TextUtils.isEmpty(h3)) {
                hashMap.put("search_user_id", h3);
                hashMap.put("Cookie", this.T);
            }
            a((Map<String, String>) hashMap, com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN);
            if (d.a((Context) this)) {
                b(k2, hashMap, str2, k2);
            } else {
                a(k2, (Map<String, String>) hashMap, str2, k2);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, Map<String, String> map, String str2, String str3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(str, map, str2, str3) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Map f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRSearchActivity.this.a(this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, String str2, String str3, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (d.a(getApplicationContext())) {
            b(str, map, str2, str3);
        } else {
            a(str, (Map<String, String>) map, str2, str3);
        }
    }

    private void b(String str, Map<String, String> map, final String str2, final String str3) {
        com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, str, (String) null, map, new StringModel(), new com.paytmmall.b.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                AJRSearchActivity.a(AJRSearchActivity.this, ((StringModel) iJRPaytmDataModel).getData(), str2);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRSearchActivity.this.a(networkCustomError, str3);
            }
        });
    }

    private static String g(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("allow_spe", "1").toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private String h(String str) {
        boolean z2;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String a2 = com.paytmmall.artifact.d.b.a(getApplicationContext());
        if (!TextUtils.isEmpty(a2)) {
            buildUpon.appendQueryParameter("pin_code", a2);
            z2 = true;
        } else {
            z2 = false;
        }
        return z2 ? buildUpon.build().toString() : str;
    }

    private static int a(Intent intent) {
        if (intent == null || TextUtils.isEmpty(CLPConstants.IS_SEARCH_CURATED)) {
            return 1;
        }
        return intent.getIntExtra(CLPConstants.IS_SEARCH_CURATED, 1);
    }

    private void b(String str, String str2) {
        if (this.P.getVisibility() != 0 || !this.R.isChecked()) {
            CJRSearchLayout cJRSearchLayout = new CJRSearchLayout();
            cJRSearchLayout.setText(this.A.getSearchKey());
            cJRSearchLayout.setmFilterAttributes(this.V);
            if (TextUtils.isEmpty(str2) || !t.a(str2)) {
                cJRSearchLayout.setPaytm(Boolean.TRUE);
            } else {
                cJRSearchLayout.setAPIUrl(str);
                cJRSearchLayout.setPaytm(Boolean.FALSE);
            }
            v.a().a((Context) this, cJRSearchLayout);
        }
    }

    private void g() {
        this.A.setSearchType(this.C);
        this.A.setAutoSuggestMetaData(this.U);
        this.A.setSearchCategory(this.E);
        this.A.setIsFromSearch(true);
        HashMap<String, Object> a2 = com.paytmmall.artifact.common.b.a.a(this.A);
        a2.put("search_term", this.A.getSearchKey());
        a2.put("experimentName", "");
        t.e().setSearchMap(a2);
    }

    private String h() {
        return u.a(getApplicationContext()).b("search_user_id", "", false);
    }

    private void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            String h2 = h();
            if (TextUtils.isEmpty(h2) || !str.equalsIgnoreCase(h2)) {
                u.a(getApplicationContext()).a("search_user_id", str, false);
            }
        }
    }

    private boolean j(String str) {
        ArrayList<CJRSearchLayout> keyWordsLayoutList;
        if (str == null) {
            return false;
        }
        try {
            if (this.q != null) {
                int i2 = this.q.f15907a;
                if (f15950a != null) {
                    int size = f15950a.size();
                    if (size < i2) {
                        i2 = size;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (str.equalsIgnoreCase(f15950a.get((size - 1) - i3).getText())) {
                            return true;
                        }
                    }
                }
            }
            if (!(this.s == null || (keyWordsLayoutList = this.s.getKeyWordsLayoutList()) == null)) {
                for (int i4 = 0; i4 < keyWordsLayoutList.size(); i4++) {
                    if (str.equalsIgnoreCase(keyWordsLayoutList.get(i4).getText())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0103 A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0118 A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0052=Splitter:B:13:0x0052, B:35:0x00aa=Splitter:B:35:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r13, com.paytm.network.model.IJRPaytmDataModel r14, java.lang.String r15) {
        /*
            r12 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "search"
            boolean r1 = r13.equalsIgnoreCase(r1)
            java.lang.String r2 = "child_site_id"
            java.lang.String r3 = "badge_url"
            java.lang.String r4 = "display_title"
            java.lang.String r5 = "banner_url"
            java.lang.String r6 = "logo_url"
            java.lang.String r7 = "Brand Store"
            java.lang.String r8 = "UTF-8"
            java.lang.String r9 = "origin"
            java.lang.String r10 = "grid"
            java.lang.String r11 = "product"
            if (r1 == 0) goto L_0x005c
            java.lang.String r13 = r12.f15952c
            if (r13 == 0) goto L_0x0052
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x0052
            java.lang.String r13 = r12.E
            if (r13 == 0) goto L_0x0052
            boolean r13 = r13.contains(r7)
            if (r13 == 0) goto L_0x0052
            boolean r13 = r12.f15955f
            if (r13 == 0) goto L_0x0052
            java.lang.String r13 = r12.f15951b
            r0.putExtra(r6, r13)
            java.lang.String r13 = r12.f15952c
            r0.putExtra(r5, r13)
            java.lang.String r13 = r12.f15953d
            r0.putExtra(r4, r13)
            java.lang.String r13 = r12.f15954e
            r0.putExtra(r3, r13)
            java.lang.String r13 = r12.F
            r0.putExtra(r2, r13)
        L_0x0052:
            java.lang.String r13 = java.net.URLEncoder.encode(r15, r8)     // Catch:{ UnsupportedEncodingException -> 0x005a }
            r0.putExtra(r9, r13)     // Catch:{ UnsupportedEncodingException -> 0x005a }
            goto L_0x00b1
        L_0x005a:
            goto L_0x00b1
        L_0x005c:
            boolean r1 = r13.equalsIgnoreCase(r11)
            if (r1 != 0) goto L_0x00b1
            boolean r1 = r13.equalsIgnoreCase(r10)
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = "list"
            boolean r1 = r13.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = "smart_list"
            boolean r13 = r13.equalsIgnoreCase(r1)
            if (r13 == 0) goto L_0x00b1
        L_0x0079:
            java.lang.String r13 = r12.f15952c
            if (r13 == 0) goto L_0x00aa
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x00aa
            java.lang.String r13 = r12.E
            if (r13 == 0) goto L_0x00aa
            boolean r13 = r13.contains(r7)
            if (r13 == 0) goto L_0x00aa
            boolean r13 = r12.f15955f
            if (r13 == 0) goto L_0x00aa
            java.lang.String r13 = r12.f15951b
            r0.putExtra(r6, r13)
            java.lang.String r13 = r12.f15952c
            r0.putExtra(r5, r13)
            java.lang.String r13 = r12.f15953d
            r0.putExtra(r4, r13)
            java.lang.String r13 = r12.f15954e
            r0.putExtra(r3, r13)
            java.lang.String r13 = r12.F
            r0.putExtra(r2, r13)
        L_0x00aa:
            java.lang.String r13 = java.net.URLEncoder.encode(r15, r8)     // Catch:{ UnsupportedEncodingException -> 0x005a }
            r0.putExtra(r9, r13)     // Catch:{ UnsupportedEncodingException -> 0x005a }
        L_0x00b1:
            if (r14 == 0) goto L_0x00d2
            boolean r13 = r14 instanceof com.paytmmall.artifact.common.entity.CJRHomePageItem
            if (r13 == 0) goto L_0x00d2
            r13 = r14
            com.paytmmall.artifact.common.entity.CJRHomePageItem r13 = (com.paytmmall.artifact.common.entity.CJRHomePageItem) r13
            java.lang.String r15 = r13.getSearchType()
            if (r15 == 0) goto L_0x00d2
            java.lang.String r13 = r13.getSearchType()
            java.lang.String r15 = "popularsearch"
            boolean r13 = r13.equals(r15)
            if (r13 != 0) goto L_0x00d2
            r13 = 1
            java.lang.String r15 = "is_normal_search"
            r0.putExtra(r15, r13)
        L_0x00d2:
            boolean r13 = r12.z
            if (r13 == 0) goto L_0x00dc
            r13 = -1
            r12.setResult(r13, r0)
            goto L_0x0159
        L_0x00dc:
            android.content.ComponentName r13 = r0.getComponent()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r15 = ""
            if (r13 == 0) goto L_0x00fb
            android.content.ComponentName r13 = r0.getComponent()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r13 = r13.getClassName()     // Catch:{ Exception -> 0x0155 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0155 }
            if (r13 == 0) goto L_0x00fb
            android.content.ComponentName r13 = r0.getComponent()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r13 = r13.getClassName()     // Catch:{ Exception -> 0x0155 }
            goto L_0x00fc
        L_0x00fb:
            r13 = r15
        L_0x00fc:
            if (r14 == 0) goto L_0x0103
            com.paytmmall.artifact.common.entity.CJRHomePageItem r14 = (com.paytmmall.artifact.common.entity.CJRHomePageItem) r14     // Catch:{ Exception -> 0x0155 }
            java.lang.String r14 = r14.mSearchResultType     // Catch:{ Exception -> 0x0155 }
            goto L_0x0104
        L_0x0103:
            r14 = r15
        L_0x0104:
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0155 }
            if (r0 != 0) goto L_0x0114
            java.lang.String r0 = "AJRSecondaryHome"
            boolean r13 = r13.equals(r0)     // Catch:{ Exception -> 0x0155 }
            if (r13 == 0) goto L_0x0114
            java.lang.String r14 = "homepage_secondary"
        L_0x0114:
            com.paytmmall.artifact.common.entity.CJRHomePageItem r13 = r12.A     // Catch:{ Exception -> 0x0155 }
            if (r13 == 0) goto L_0x013f
            r15 = r13
            com.paytmmall.artifact.common.entity.CJRHomePageItem r15 = (com.paytmmall.artifact.common.entity.CJRHomePageItem) r15     // Catch:{ Exception -> 0x0155 }
            java.lang.String r15 = r15.getSearchUrl()     // Catch:{ Exception -> 0x0155 }
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0155 }
            if (r0 != 0) goto L_0x013f
            android.net.Uri r15 = android.net.Uri.parse(r15)     // Catch:{ Exception -> 0x0155 }
            android.net.Uri$Builder r15 = r15.buildUpon()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r0 = "current_category"
            java.lang.String r13 = r13.getCategoryId()     // Catch:{ Exception -> 0x0155 }
            android.net.Uri$Builder r13 = r15.appendQueryParameter(r0, r13)     // Catch:{ Exception -> 0x0155 }
            android.net.Uri r13 = r13.build()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r15 = r13.toString()     // Catch:{ Exception -> 0x0155 }
        L_0x013f:
            boolean r13 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0155 }
            if (r13 != 0) goto L_0x0159
            boolean r13 = r14.equals(r10)     // Catch:{ Exception -> 0x0155 }
            if (r13 != 0) goto L_0x0151
            boolean r13 = r14.equals(r11)     // Catch:{ Exception -> 0x0155 }
            if (r13 == 0) goto L_0x0159
        L_0x0151:
            com.paytmmall.a.a.b(r15, r14)     // Catch:{ Exception -> 0x0155 }
            goto L_0x0159
        L_0x0155:
            r13 = move-exception
            com.paytmmall.artifact.d.s.a(r13)
        L_0x0159:
            r12.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.activity.AJRSearchActivity.a(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void i() {
        ScrollView scrollView = this.k;
        if (scrollView != null && scrollView.getVisibility() != 8) {
            this.k.setVisibility(8);
        }
    }

    private void a(CJRGrid cJRGrid) {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ScrollView scrollView = this.k;
        if (scrollView != null) {
            scrollView.setVisibility(0);
            if (this.J) {
                if (!TextUtils.isEmpty(this.I.get("merchant_id"))) {
                    if (this.S.isChecked()) {
                        this.L.setText(getResources().getString(R.string.no_results_paytmmall));
                    } else if (this.J) {
                        this.L.setText(getResources().getString(R.string.no_results_merchant));
                    }
                } else if (!TextUtils.isEmpty(this.I.get("store_id"))) {
                    this.L.setText(getString(R.string.no_results_store, new Object[]{this.M}));
                }
            }
        }
        ArrayList<CJRSearchSuggestion> arrayList = null;
        if (!(cJRGrid == null || cJRGrid.getSearchSuggestionList() == null)) {
            arrayList = cJRGrid.getSearchSuggestionList();
        }
        if (arrayList == null || arrayList.size() == 0) {
            this.u.setText(getString(R.string.search_try_again_different_keyword));
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append("Search for ");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                final String value = arrayList.get(i2).getValue();
                spannableStringBuilder.append(value);
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(AJRSearchActivity.this.getResources().getColor(R.color.blue_dot));
                        textPaint.setUnderlineText(false);
                    }

                    public final void onClick(View view) {
                        if (AJRSearchActivity.this.f15957h != null) {
                            AJRSearchActivity.this.f15957h.setQuery(value, true);
                            AJRSearchActivity.this.f15957h.requestFocus();
                        }
                    }
                }, spannableStringBuilder.length() - value.length(), spannableStringBuilder.length(), 33);
                if (i2 != arrayList.size() - 1) {
                    spannableStringBuilder.append(", ");
                }
            }
            spannableStringBuilder.append(" instead");
            this.u.setMovementMethod(LinkMovementMethod.getInstance());
            this.u.setText(spannableStringBuilder);
        }
        j();
        if (com.paytmmall.artifact.search.utils.b.f16018d == null) {
            com.paytmmall.artifact.search.utils.b.f16018d = new com.paytmmall.artifact.search.utils.b(this);
        }
        ArrayList<CJRGridProduct> b2 = com.paytmmall.artifact.search.utils.b.f16018d.b();
        if (!(b2 == null || b2.size() == 0)) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(0);
            this.n.setVisibility(0);
            RecyclerView recyclerView = this.o;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
                if (this.o.getAdapter() == null) {
                    this.o.addItemDecoration(new RecyclerView.h() {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            rect.set(e.a(10.0f, AJRSearchActivity.this), 0, 0, e.a(10.0f, AJRSearchActivity.this));
                        }
                    });
                }
                this.o.setAdapter(new com.paytmmall.artifact.search.a.a(b2, this));
            }
        }
        this.K.setOnClickListener(this.N);
        if (this.S.isChecked()) {
            this.K.setVisibility(8);
        } else if (this.J) {
            this.K.setVisibility(0);
        }
    }

    private void j() {
        d.g();
        HashMap<String, String> m2 = d.m();
        a((Map<String, String>) m2, com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN);
        final String a2 = d.a((Context) this, "https://catalog.paytm.com/v1/g/paytm-home/exclusive-discount-deals");
        if (d.a((Context) this)) {
            com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.POST, a2, (String) null, m2, new CJRGrid(), new com.paytmmall.b.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    AJRSearchActivity.a(AJRSearchActivity.this, (CJRGrid) iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSearchActivity.this.a(networkCustomError, a2);
                }
            });
        } else {
            k();
        }
    }

    private void k() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRSearchActivity.this.a(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (d.a(getApplicationContext())) {
            j();
        } else {
            k();
        }
    }

    private static String k(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("page_count", "1").appendQueryParameter("items_per_page", "16").toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private void a(CJRGrid cJRGrid, String str) {
        String str2;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(h.f15721b, com.paytmmall.artifact.common.a.b.a((Context) this));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/search");
            hashMap.put("event_label", str);
            if (!(cJRGrid == null || cJRGrid.getGridMeta() == null)) {
                hashMap.put("event_label3", cJRGrid.getGridMeta().getVersion() + ";" + this.U);
            }
            hashMap.put(h.f15720a, "search");
            hashMap.put("event_category", "search");
            if ("organic".equalsIgnoreCase(this.C)) {
                str2 = "manual/organic";
            } else {
                str2 = this.C + "/organic";
            }
            hashMap.put("search_type", str2);
            hashMap.put("search_within_category", "");
            hashMap.put("search_term", str);
            hashMap.put("event_action", "no_results_".concat(String.valueOf(str2)));
            com.paytmmall.artifact.common.a.b.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            SearchView searchView = this.f15957h;
            if (searchView != null) {
                searchView.clearFocus();
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void a(NetworkCustomError networkCustomError, String str) {
        if (networkCustomError != null) {
            String m2 = m(str);
            if (!TextUtils.isEmpty(networkCustomError.getAlertMessage()) && (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410)) {
                d.a((Activity) this, networkCustomError, (String) null, m2);
            } else if (networkCustomError.getMessage() != null && !d.a((Context) this, networkCustomError, m2)) {
                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    d.b(this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + m2);
                    return;
                }
                d.a((Context) this, m2, String.valueOf(networkCustomError.getStatusCode()));
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration) {
        try {
            this.U = str4;
            this.V = hashMap;
            if (URLUtil.isValidUrl(str) && !TextUtils.isEmpty(str3)) {
                String trim = str3.trim();
                this.A = new CJRHomePageItem();
                this.A.setSearchUrl(str);
                this.A.setSearcKey(trim);
                this.A.setTitle(trim);
                this.A.setSearchUrl(str);
                this.A.setSearcKey(trim);
                this.A.setTitle(trim);
                this.A.setSearchType("autosuggest");
                this.E = str2;
                this.A.setSearchCategory(str2);
                this.A.setSearchTerm(trim);
                this.C = "autosuggest";
                d(trim, trim);
                a(trim, (String[]) null);
                if (this.F != null) {
                    c(this.H, trim);
                }
                this.f15955f = true;
                if (cJRSearchCuration == null || TextUtils.isEmpty(cJRSearchCuration.getmAppUrl())) {
                    a(str, trim);
                } else {
                    d.b((Activity) this, cJRSearchCuration.getmAppUrl());
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, String[] strArr) {
        com.paytmmall.artifact.common.a.a.a();
        if (com.paytmmall.artifact.common.a.a.a("key_af_search", false)) {
            a((Context) this, str, strArr);
        }
    }

    private static void a(Context context, String str, String[] strArr) {
        t.e().sendAppsFlyerFbSearchClickEvent(context, str, strArr);
    }

    public final void b() {
        this.V = null;
        a("product", (IJRPaytmDataModel) new CJRDetailProduct(), "search");
    }

    private void a(String str, CJRSearchCuration cJRSearchCuration) {
        if (cJRSearchCuration == null || TextUtils.isEmpty(cJRSearchCuration.getmAppUrl())) {
            e(str);
            return;
        }
        if (this.A == null) {
            this.A = new CJRHomePageItem();
        }
        this.A.setSearcKey(str);
        g();
        d.b((Activity) this, cJRSearchCuration.getmAppUrl());
    }

    public final void a(String str, HashMap<String, String> hashMap) {
        this.V = hashMap;
        this.f15957h.setQuery(str, false);
        this.f15957h.requestFocus();
    }

    public final void c() {
        ArrayList<CJRSearchLayout> arrayList = f15950a;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.q.a(this.s);
        v.a().d(this, "recentSearchString");
    }

    public final void a(String str, String str2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration) {
        this.B = true;
        this.C = "autosuggest";
        this.U = str2;
        this.V = hashMap;
        if (this.F != null) {
            c(this.H, str);
        }
        a(str, cJRSearchCuration);
    }

    public final void b(String str) {
        this.V = null;
        this.f15957h.setQuery(str, false);
        this.f15957h.requestFocus();
    }

    private void c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BrandStore");
        hashMap.put("brandstore_site_id", t.c().c("CHILD_SITE_ID"));
        hashMap.put("brandstore_brandtag", str);
        hashMap.put("brandstore_search_term", str2);
        com.paytmmall.artifact.common.a.b.a("brandstore_search_performed", (Map<String, Object>) hashMap, (Context) this);
    }

    private String l(String str) {
        if (this.S.isChecked()) {
            return str;
        }
        boolean z2 = true;
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : this.I.entrySet()) {
                if (z2) {
                    if (!str.contains("?")) {
                        sb = new StringBuilder("?" + ((String) next.getKey()) + "=" + URLEncoder.encode((String) next.getValue(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                        z2 = false;
                    }
                }
                sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                z2 = false;
            }
        } catch (UnsupportedEncodingException e2) {
            q.c(e2.getMessage());
        }
        return str + sb;
    }

    private void d(String str, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put(h.f15721b, com.paytmmall.artifact.common.a.b.a((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/search");
        hashMap.put("event_label", str);
        hashMap.put("event_label3", this.U);
        hashMap.put(h.f15720a, "search");
        hashMap.put("event_category", "search");
        hashMap.put("event_action", "input_submitted");
        if ("organic".equalsIgnoreCase(this.C)) {
            str3 = "manual";
        } else {
            str3 = this.C;
        }
        hashMap.put("search_type", str3);
        hashMap.put("search_within_category", str2);
        hashMap.put("search_term", str);
        com.paytmmall.artifact.common.a.b.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private static void l() {
        t.e().setUTMData("search");
    }

    private static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            return parse.getHost() + parse.getPath();
        } catch (Exception e2) {
            e2.getMessage();
            boolean z2 = com.paytmmall.artifact.d.c.f15691a;
            return str;
        }
    }

    private void a(Map<String, String> map, String str) {
        String a2 = l.a((Context) this);
        if (!TextUtils.isEmpty(a2)) {
            map.put(str, a2);
        }
    }

    private void b(CJRGrid cJRGrid, String str) {
        CJRFrontEndFilter cJRFrontEndFilter;
        ArrayList<CJRFilterValue> appliedFrontEndFiltersList;
        String searchUrl = this.A.getSearchUrl();
        if (!TextUtils.isEmpty(searchUrl)) {
            Uri parse = Uri.parse(searchUrl);
            Uri.Builder builder = new Uri.Builder();
            if (cJRGrid != null) {
                CJRGridMeta gridMeta = cJRGrid.getGridMeta();
                if (gridMeta != null) {
                    if (!TextUtils.isEmpty(str)) {
                        this.A.setSearcKey(str);
                        Set<String> queryParameterNames = parse.getQueryParameterNames();
                        if (queryParameterNames != null) {
                            Uri.Builder authority = builder.scheme(parse.getScheme()).authority(parse.getAuthority());
                            try {
                                String decode = URLDecoder.decode(parse.getEncodedPath(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                                if (decode.startsWith("/")) {
                                    decode = decode.substring(1);
                                }
                                authority = authority.appendEncodedPath(decode);
                            } catch (UnsupportedEncodingException e2) {
                                q.c(e2.getMessage());
                            }
                            for (String next : queryParameterNames) {
                                if (next.equalsIgnoreCase(SearchCostants.SEARCH_URL_SUFFIX)) {
                                    builder = builder.appendQueryParameter(SearchCostants.SEARCH_URL_SUFFIX, str);
                                } else {
                                    builder = builder.appendQueryParameter(next, parse.getQueryParameter(next));
                                }
                            }
                        }
                    }
                    ArrayList<String> brand = gridMeta.getBrand();
                    if (brand != null && brand.size() > 0) {
                        int size = brand.size();
                        String str2 = "";
                        Uri.Builder builder2 = builder;
                        for (int i2 = 0; i2 < size; i2++) {
                            str2 = str2 + brand.get(i2);
                            if (i2 != size - 1) {
                                str2 = str2 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA;
                            }
                            builder2 = builder2.appendQueryParameter(CLPConstants.BRAND_PARAMS, str2);
                        }
                        builder = builder2;
                    }
                    ArrayList<CJRFrontEndFilter> frontEndFilterList = cJRGrid.getFrontEndFilterList();
                    if (!(frontEndFilterList == null || frontEndFilterList.size() <= 0 || (cJRFrontEndFilter = frontEndFilterList.get(0)) == null || (appliedFrontEndFiltersList = cJRFrontEndFilter.getAppliedFrontEndFiltersList()) == null || appliedFrontEndFiltersList.size() <= 0)) {
                        builder = a(builder, appliedFrontEndFiltersList);
                    }
                }
                this.A.setSearchUrl(builder.toString());
            }
        }
    }

    private static Uri.Builder a(Uri.Builder builder, ArrayList<CJRFilterValue> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<CJRFilterValue> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String id = it2.next().getID();
            if (id != null) {
                if (sb.length() == 0) {
                    sb.append(id);
                } else {
                    sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                    sb.append(id);
                }
            }
        }
        return builder.appendQueryParameter("category", sb.toString());
    }

    public final void a(String str, int i2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration, String str2) {
        boolean z2;
        boolean z3;
        if (!TextUtils.isEmpty(str2)) {
            if (str2 == null || !com.paytmmall.a.a.f() || !str2.contains("/search")) {
                z3 = false;
            } else {
                v.a();
                m.a().a((Context) this, "searchResponse");
                com.paytmmall.a.a.b(com.paytmmall.a.a.c(str2));
                z3 = true;
            }
            if (z3) {
                finish();
            } else {
                com.paytmmall.artifact.d.a.a().a((Activity) this, str2);
            }
            finish();
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.J = false;
            this.B = true;
            this.V = hashMap;
            this.C = i2 == b.f15905b ? "recent" : "popularsearch";
            a(str, cJRSearchCuration);
            try {
                com.paytmmall.artifact.common.a.b.a("search_hot_search_selected", "Search Screen", "HOT_SEARCH_TERM", str, (Context) this);
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void a(AJRSearchActivity aJRSearchActivity, CJRSearchPage cJRSearchPage) {
        if (!aJRSearchActivity.isFinishing()) {
            RelativeLayout relativeLayout = aJRSearchActivity.w;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (cJRSearchPage.getSearchUserId() != null) {
                aJRSearchActivity.i(cJRSearchPage.getSearchUserId());
            }
            aJRSearchActivity.s = cJRSearchPage;
            aJRSearchActivity.a(aJRSearchActivity.s, true);
        }
    }

    static /* synthetic */ void b(AJRSearchActivity aJRSearchActivity, CJRSearchPage cJRSearchPage) {
        if (!aJRSearchActivity.isFinishing()) {
            RelativeLayout relativeLayout = aJRSearchActivity.w;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (cJRSearchPage.getSearchUserId() != null) {
                aJRSearchActivity.i(cJRSearchPage.getSearchUserId());
            }
            aJRSearchActivity.r = cJRSearchPage;
            aJRSearchActivity.a(aJRSearchActivity.r, false);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2 = com.paytmmall.artifact.d.c.f15691a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00bc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.paytmmall.artifact.search.activity.AJRSearchActivity r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "search"
            java.lang.String r1 = "url="
            java.lang.String r2 = "meta_autosuggest_query"
            com.paytmmall.artifact.d.v.a()     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.d.v.e(r10, r11)     // Catch:{ Exception -> 0x0225 }
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0225 }
            r3.<init>()     // Catch:{ Exception -> 0x0225 }
            java.lang.Class<com.paytmmall.artifact.grid.entity.CJRGrid> r4 = com.paytmmall.artifact.grid.entity.CJRGrid.class
            java.lang.Object r11 = r3.a((java.lang.String) r11, r4)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.grid.entity.CJRGrid r11 = (com.paytmmall.artifact.grid.entity.CJRGrid) r11     // Catch:{ Exception -> 0x0225 }
            boolean r3 = r10.isFinishing()     // Catch:{ Exception -> 0x0225 }
            if (r3 != 0) goto L_0x0224
            r3 = 1
            com.paytmmall.artifact.common.entity.CJRHomePageItem r4 = r10.A     // Catch:{ Exception -> 0x00bc }
            com.paytmmall.artifact.grid.entity.CJRGridMeta r5 = r11.getGridMeta()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r5 = r5.getExperimentName()     // Catch:{ Exception -> 0x00bc }
            r4.setSearchABValue(r5)     // Catch:{ Exception -> 0x00bc }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r4 = r10.A     // Catch:{ Exception -> 0x00bc }
            com.paytmmall.artifact.grid.entity.CJRGridMeta r5 = r11.getGridMeta()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r5 = r5.getExperimentName()     // Catch:{ Exception -> 0x00bc }
            r4.setExperimentName(r5)     // Catch:{ Exception -> 0x00bc }
            r4 = 0
            java.util.HashMap r5 = com.paytmmall.artifact.d.v.b()     // Catch:{ Exception -> 0x00bc }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00bc }
            r6.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r7 = r10.U     // Catch:{ Exception -> 0x00bc }
            int r7 = r7.length()     // Catch:{ Exception -> 0x00bc }
            if (r7 == 0) goto L_0x004e
            r4 = 1
        L_0x004e:
            if (r5 != 0) goto L_0x0055
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00bc }
            r5.<init>()     // Catch:{ Exception -> 0x00bc }
        L_0x0055:
            com.paytmmall.artifact.grid.entity.CJRGridMeta r7 = r11.getGridMeta()     // Catch:{ Exception -> 0x00bc }
            java.util.HashMap r7 = r7.getTrackingObject()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r8 = "dimension124"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x00bc }
            r6.put(r8, r4)     // Catch:{ Exception -> 0x00bc }
            if (r7 == 0) goto L_0x0084
            java.util.Set r4 = r7.keySet()     // Catch:{ Exception -> 0x00bc }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00bc }
        L_0x0070:
            boolean r8 = r4.hasNext()     // Catch:{ Exception -> 0x00bc }
            if (r8 == 0) goto L_0x0084
            java.lang.Object r8 = r4.next()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00bc }
            java.lang.Object r9 = r7.get(r8)     // Catch:{ Exception -> 0x00bc }
            r6.put(r8, r9)     // Catch:{ Exception -> 0x00bc }
            goto L_0x0070
        L_0x0084:
            java.lang.String r4 = ""
            java.util.HashMap<java.lang.String, java.lang.String> r7 = r10.V     // Catch:{ Exception -> 0x00bc }
            if (r7 == 0) goto L_0x00a5
            boolean r7 = r10.B     // Catch:{ Exception -> 0x00bc }
            if (r7 != r3) goto L_0x00a5
            java.util.HashMap<java.lang.String, java.lang.String> r7 = r10.V     // Catch:{ Exception -> 0x00bc }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x00bc }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x00bc }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00bc }
            if (r7 != 0) goto L_0x00a5
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r10.V     // Catch:{ Exception -> 0x00bc }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x00bc }
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00bc }
        L_0x00a5:
            java.lang.String r2 = "dimension127"
            r6.put(r2, r4)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "searchObject"
            r5.put(r2, r6)     // Catch:{ Exception -> 0x00bc }
            com.paytmmall.artifact.d.v.a((android.content.Context) r10, (java.util.Map<java.lang.String, java.lang.Object>) r5)     // Catch:{ Exception -> 0x00bc }
            com.paytmmall.artifact.grid.entity.CJRGridMeta r2 = r11.getGridMeta()     // Catch:{ Exception -> 0x00bc }
            r2.getExperimentName()     // Catch:{ Exception -> 0x00bc }
            boolean r2 = com.paytmmall.artifact.d.c.f15691a     // Catch:{ Exception -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            boolean r2 = com.paytmmall.artifact.d.c.f15691a     // Catch:{ Exception -> 0x0225 }
        L_0x00be:
            java.lang.String r2 = r11.getSearchUserId()     // Catch:{ Exception -> 0x0225 }
            if (r2 == 0) goto L_0x00cb
            java.lang.String r2 = r11.getSearchUserId()     // Catch:{ Exception -> 0x0225 }
            r10.i((java.lang.String) r2)     // Catch:{ Exception -> 0x0225 }
        L_0x00cb:
            java.lang.String r2 = "curated"
            java.lang.String r4 = r11.getResultType()     // Catch:{ Exception -> 0x0225 }
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r4 = "manual"
            java.lang.String r5 = "organic"
            if (r2 == 0) goto L_0x0160
            java.lang.String r12 = r11.getAppUrl()     // Catch:{ Exception -> 0x0225 }
            if (r12 == 0) goto L_0x0152
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0225 }
            if (r0 != 0) goto L_0x0152
            java.lang.String r0 = r10.C     // Catch:{ Exception -> 0x0225 }
            boolean r0 = r5.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0225 }
            if (r0 == 0) goto L_0x00f1
            r10.C = r4     // Catch:{ Exception -> 0x0225 }
        L_0x00f1:
            com.paytmmall.artifact.common.entity.CJRHomePageItem r0 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r11.getResultType()     // Catch:{ Exception -> 0x0225 }
            r0.setSearchResultType(r2)     // Catch:{ Exception -> 0x0225 }
            r10.g()     // Catch:{ Exception -> 0x0225 }
            r10.i()     // Catch:{ Exception -> 0x0225 }
            l()     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.d.d.b((android.app.Activity) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r0 = r10.A     // Catch:{ Exception -> 0x0225 }
            if (r0 == 0) goto L_0x014d
            java.util.ArrayList<com.paytmmall.artifact.search.entity.CJRSearchLayout> r0 = f15950a     // Catch:{ Exception -> 0x0225 }
            if (r0 == 0) goto L_0x014d
            com.paytmmall.artifact.common.entity.CJRHomePageItem r0 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r0 = r0.getSearchKey()     // Catch:{ Exception -> 0x0225 }
            boolean r0 = r10.j(r0)     // Catch:{ Exception -> 0x0225 }
            if (r0 != 0) goto L_0x014d
            if (r12 == 0) goto L_0x012d
            boolean r0 = r12.contains(r1)     // Catch:{ Exception -> 0x0225 }
            if (r0 == 0) goto L_0x012d
            int r0 = r12.indexOf(r1)     // Catch:{ Exception -> 0x0225 }
            int r0 = r0 + 4
            java.lang.String r0 = r12.substring(r0)     // Catch:{ Exception -> 0x0225 }
            goto L_0x012e
        L_0x012d:
            r0 = r12
        L_0x012e:
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0225 }
            if (r1 != 0) goto L_0x0149
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = com.paytmmall.artifact.d.o.a((android.content.Context) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
            if (r12 == 0) goto L_0x0149
            java.lang.String r1 = r12.getURLType()     // Catch:{ Exception -> 0x0225 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0225 }
            if (r1 != 0) goto L_0x0149
            java.lang.String r12 = r12.getURLType()     // Catch:{ Exception -> 0x0225 }
            goto L_0x014a
        L_0x0149:
            r12 = 0
        L_0x014a:
            r10.b((java.lang.String) r0, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
        L_0x014d:
            r10.finish()     // Catch:{ Exception -> 0x0225 }
            goto L_0x0213
        L_0x0152:
            r10.a((com.paytmmall.artifact.grid.entity.CJRGrid) r11)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r12 = r12.getSearchKey()     // Catch:{ Exception -> 0x0225 }
            r10.a((com.paytmmall.artifact.grid.entity.CJRGrid) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
            goto L_0x0213
        L_0x0160:
            if (r11 == 0) goto L_0x0207
            java.util.ArrayList r1 = r11.getGridLayout()     // Catch:{ Exception -> 0x0225 }
            if (r1 == 0) goto L_0x0207
            java.util.ArrayList r1 = r11.getGridLayout()     // Catch:{ Exception -> 0x0225 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0225 }
            if (r1 == 0) goto L_0x0207
            java.lang.String r1 = r11.getResultType()     // Catch:{ Exception -> 0x0225 }
            if (r1 != 0) goto L_0x017a
            goto L_0x0207
        L_0x017a:
            com.paytmmall.artifact.common.entity.CJRHomePageItem r1 = r10.A     // Catch:{ Exception -> 0x0225 }
            if (r1 == 0) goto L_0x0213
            r10.b((com.paytmmall.artifact.grid.entity.CJRGrid) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = r10.C     // Catch:{ Exception -> 0x0225 }
            boolean r1 = r5.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0225 }
            if (r1 == 0) goto L_0x018b
            r10.C = r4     // Catch:{ Exception -> 0x0225 }
        L_0x018b:
            com.paytmmall.artifact.common.entity.CJRHomePageItem r1 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r10.C     // Catch:{ Exception -> 0x0225 }
            r1.setSearchType(r2)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r1 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r10.E     // Catch:{ Exception -> 0x0225 }
            r1.setSearchCategory(r2)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r1 = r10.A     // Catch:{ Exception -> 0x0225 }
            r1.setSearchTerm(r12)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = r11.getResultType()     // Catch:{ Exception -> 0x0225 }
            r12.setSearchResultType(r1)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = r10.U     // Catch:{ Exception -> 0x0225 }
            r12.setAutoSuggestMetaData(r1)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.util.HashMap r12 = com.paytmmall.artifact.common.b.a.a(r12)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = "search_term"
            com.paytmmall.artifact.common.entity.CJRHomePageItem r2 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r2.getSearchTerm()     // Catch:{ Exception -> 0x0225 }
            r12.put(r1, r2)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = "search_autosuggest_data"
            com.paytmmall.artifact.common.entity.CJRHomePageItem r2 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r2.getAutoSuggestMetaData()     // Catch:{ Exception -> 0x0225 }
            r12.put(r1, r2)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r1 = "experimentName"
            com.paytmmall.artifact.grid.entity.CJRGridMeta r2 = r11.getGridMeta()     // Catch:{ Exception -> 0x0225 }
            java.lang.String r2 = r2.getExperimentName()     // Catch:{ Exception -> 0x0225 }
            r12.put(r1, r2)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.a r1 = com.paytmmall.artifact.d.t.e()     // Catch:{ Exception -> 0x0225 }
            r1.setSearchMap(r12)     // Catch:{ Exception -> 0x0225 }
            r10.i()     // Catch:{ Exception -> 0x0225 }
            l()     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            r10.a((java.lang.String) r0, (com.paytm.network.model.IJRPaytmDataModel) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x0225 }
            java.util.ArrayList<com.paytmmall.artifact.search.entity.CJRSearchLayout> r12 = f15950a     // Catch:{ Exception -> 0x0225 }
            if (r12 == 0) goto L_0x0213
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r12 = r12.getSearchKey()     // Catch:{ Exception -> 0x0225 }
            boolean r12 = r10.j(r12)     // Catch:{ Exception -> 0x0225 }
            if (r12 != 0) goto L_0x0213
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r12 = r12.getSearchUrl()     // Catch:{ Exception -> 0x0225 }
            java.lang.String r0 = r11.getResultType()     // Catch:{ Exception -> 0x0225 }
            r10.b((java.lang.String) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x0225 }
            goto L_0x0213
        L_0x0207:
            r10.a((com.paytmmall.artifact.grid.entity.CJRGrid) r11)     // Catch:{ Exception -> 0x0225 }
            com.paytmmall.artifact.common.entity.CJRHomePageItem r12 = r10.A     // Catch:{ Exception -> 0x0225 }
            java.lang.String r12 = r12.getSearchKey()     // Catch:{ Exception -> 0x0225 }
            r10.a((com.paytmmall.artifact.grid.entity.CJRGrid) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0225 }
        L_0x0213:
            java.lang.String r11 = r11.getSearchCookie()     // Catch:{ Exception -> 0x0225 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x0225 }
            com.paytm.b.a.a r10 = com.paytmmall.artifact.d.u.a(r10)     // Catch:{ Exception -> 0x0225 }
            java.lang.String r12 = "search_cookie"
            r10.a((java.lang.String) r12, (java.lang.String) r11, (boolean) r3)     // Catch:{ Exception -> 0x0225 }
        L_0x0224:
            return
        L_0x0225:
            r10 = move-exception
            com.paytmmall.artifact.d.s.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.search.activity.AJRSearchActivity.a(com.paytmmall.artifact.search.activity.AJRSearchActivity, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void a(AJRSearchActivity aJRSearchActivity, CJRGrid cJRGrid) {
        if (cJRGrid != null && cJRGrid.getGridLayout() != null && cJRGrid.getGridLayout().size() != 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(aJRSearchActivity);
            linearLayoutManager.setOrientation(0);
            aJRSearchActivity.m.setVisibility(0);
            RecyclerView recyclerView = aJRSearchActivity.l;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
                if (aJRSearchActivity.l.getAdapter() == null) {
                    aJRSearchActivity.l.addItemDecoration(new RecyclerView.h() {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            rect.set(e.a(10.0f, AJRSearchActivity.this), 0, 0, e.a(10.0f, AJRSearchActivity.this));
                        }
                    });
                }
                aJRSearchActivity.l.setAdapter(new com.paytmmall.artifact.search.a.a(cJRGrid.getGridLayout(), aJRSearchActivity));
            }
        }
    }
}
