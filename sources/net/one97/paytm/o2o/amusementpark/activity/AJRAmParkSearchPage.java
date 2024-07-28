package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.amPark.CJRAmParkAutosuggestAmParkModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkAutosuggestEventItem;
import net.one97.paytm.common.entity.amPark.CJRAmParkAutosuggestModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkModel;
import net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.a.f;
import net.one97.paytm.o2o.amusementpark.utils.m;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRAmParkSearchPage extends PaytmActivity implements TextWatcher, View.OnClickListener, b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f73325b = AJRAmParkSearchPage.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRAmParkAutosuggestEventItem> f73326a;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f73327c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f73328d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f73329e;

    /* renamed from: f  reason: collision with root package name */
    private ListView f73330f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f73331g;

    /* renamed from: h  reason: collision with root package name */
    private f f73332h;

    /* renamed from: i  reason: collision with root package name */
    private CJRAmParkAutosuggestModel f73333i;
    private EditText j;
    /* access modifiers changed from: private */
    public CJRAmParkModel k = null;
    private View l = null;
    private boolean m = false;
    private String n = "";

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.park_search_layout);
        if (getIntent() != null && getIntent().hasExtra("userselectedcity")) {
            this.f73329e = getIntent().getStringExtra("userselectedcity");
        }
        this.f73327c = (ProgressBar) findViewById(R.id.progress_bar);
        this.f73331g = (ImageView) findViewById(R.id.back_arrow);
        this.f73331g.setOnClickListener(this);
        this.j = (EditText) findViewById(R.id.event_search_edit_txt);
        this.j.setHint(getResources().getString(R.string.search_park));
        this.j.addTextChangedListener(this);
        this.f73330f = (ListView) findViewById(R.id.event_search_list);
        this.f73330f.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                CJRAmParkAutosuggestEventItem a2 = ((f) adapterView.getAdapter()).getItem(i2);
                if (a2.getType() == 1) {
                    Intent intent = new Intent(AJRAmParkSearchPage.this, AJRAmParkDetailPage.class);
                    intent.putExtra("userselectedcity", AJRAmParkSearchPage.this.f73329e);
                    intent.putExtra("selectedcategoryname", a2.getCategory());
                    intent.putExtra("selectedevent", a2.getParkName());
                    intent.putExtra("selectedeventproviderid", a2.getProviderId());
                    intent.putExtra("selectedeventid", a2.getParkId());
                    AJRAmParkSearchPage.this.startActivity(intent);
                }
            }
        });
        try {
            this.f73328d = (LinearLayout) findViewById(R.id.no_network);
            findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    com.paytm.utility.b.c((Context) AJRAmParkSearchPage.this);
                }
            });
            if (com.paytm.utility.b.c((Context) this)) {
                this.f73328d.setVisibility(8);
            } else {
                this.f73328d.setVisibility(0);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
        this.l = findViewById(R.id.no_suggestion_lyt);
        try {
            if (com.paytm.utility.b.c((Context) this)) {
                b();
                a(false);
                String str = this.f73329e;
                String stringFromGTM = a.a().getStringFromGTM("ampark_autosuggest_url");
                String u = com.paytm.utility.b.u(this, c.b(stringFromGTM + str.replace(" ", "%20"), (Context) this));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.AM_PARK;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = u;
                bVar.f42881e = null;
                bVar.f42882f = null;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRAmParkAutosuggestAmParkModel();
                bVar.j = this;
                bVar.n = a.b.USER_FACING;
                bVar.o = "AmPark";
                bVar.t = f();
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
                return;
            }
            a(true);
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.c(e3.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.k == null || TextUtils.isEmpty(this.n) || this.n.length() <= 0) {
            ArrayList<CJRAmParkAutosuggestEventItem> arrayList = this.f73326a;
            if (arrayList == null || arrayList.size() <= 0) {
                e();
            } else {
                a(this.f73326a);
                d();
            }
        } else {
            ArrayList<CJRAmParkDetailModel> arrayList2 = this.k.getmParkDetailModelList();
            ArrayList arrayList3 = new ArrayList();
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<CJRAmParkDetailModel> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    CJRAmParkDetailModel next = it2.next();
                    CJRAmParkAutosuggestEventItem cJRAmParkAutosuggestEventItem = new CJRAmParkAutosuggestEventItem();
                    cJRAmParkAutosuggestEventItem.setProviderId(next.getProviderId());
                    cJRAmParkAutosuggestEventItem.setParkName(next.getName());
                    cJRAmParkAutosuggestEventItem.setParkId(next.getmId());
                    ArrayList<CJRCategoriesDetailModel> categories = next.getCategories();
                    if (categories != null && categories.size() > 0) {
                        cJRAmParkAutosuggestEventItem.setCategory(categories.get(0).getCategory());
                    }
                    arrayList3.add(cJRAmParkAutosuggestEventItem);
                }
            }
            if (arrayList3.size() > 0) {
                a((ArrayList<CJRAmParkAutosuggestEventItem>) arrayList3);
                d();
            } else {
                e();
            }
        }
        c();
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<CJRAmParkAutosuggestEventItem> arrayList) {
        f fVar = this.f73332h;
        if (fVar != null) {
            fVar.f73138a = arrayList;
            fVar.notifyDataSetChanged();
        }
    }

    private void b() {
        ProgressBar progressBar = this.f73327c;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f73327c.setVisibility(8);
    }

    private void a(boolean z) {
        LinearLayout linearLayout = this.f73328d;
        if (linearLayout == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
            c();
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back_arrow) {
            onBackPressed();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.n = charSequence.toString().trim();
        if (this.n.length() > 1) {
            String charSequence2 = charSequence.toString();
            try {
                if (com.paytm.utility.b.c((Context) this)) {
                    b();
                    a(false);
                    String str = this.f73329e + "?keyword=" + charSequence2;
                    String u = com.paytm.utility.b.u(this, c.b(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_search_url") + str.replace(" ", "%20"), (Context) this));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this;
                    bVar.f42878b = a.c.AM_PARK;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = u;
                    bVar.f42881e = null;
                    bVar.f42882f = null;
                    bVar.f42883g = null;
                    bVar.f42884h = null;
                    bVar.f42885i = new CJRAmParkModel();
                    bVar.n = a.b.USER_FACING;
                    bVar.o = "AmPark";
                    bVar.j = new b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof CJRAmParkModel) {
                                CJRAmParkModel unused = AJRAmParkSearchPage.this.k = (CJRAmParkModel) iJRPaytmDataModel;
                                AJRAmParkSearchPage.this.a();
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            AJRAmParkSearchPage.this.a((ArrayList<CJRAmParkAutosuggestEventItem>) new ArrayList());
                            AJRAmParkSearchPage.this.c();
                            AJRAmParkSearchPage.this.e();
                        }
                    };
                    bVar.t = f();
                    com.paytm.network.a l2 = bVar.l();
                    l2.f42859c = false;
                    l2.a();
                    return;
                }
                a(true);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        } else {
            this.k = null;
            a();
        }
    }

    private void d() {
        this.m = false;
        this.l.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void e() {
        String str = this.n;
        if (str == null || str.length() <= 0) {
            d();
            ArrayList<CJRAmParkAutosuggestEventItem> arrayList = this.f73326a;
            if (arrayList != null && arrayList.size() > 0) {
                a(this.f73326a);
                return;
            }
            return;
        }
        f fVar = this.f73332h;
        if (fVar != null) {
            fVar.f73138a = new ArrayList<>();
        }
        this.m = true;
        this.l.setVisibility(0);
        ((TextView) findViewById(R.id.error_text_quote)).setText(getString(R.string.movies_err_msg, new Object[]{this.n}));
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRAmParkAutosuggestModel cJRAmParkAutosuggestModel;
        if ((iJRPaytmDataModel instanceof CJRAmParkAutosuggestModel) && (cJRAmParkAutosuggestModel = (CJRAmParkAutosuggestModel) iJRPaytmDataModel) != null) {
            this.f73333i = cJRAmParkAutosuggestModel;
            try {
                ArrayList<CJRAmParkAutosuggestEventItem> arrayList = new ArrayList<>();
                if (this.f73333i != null) {
                    if (this.f73333i.getThemeParkList() != null && this.f73333i.getThemeParkList().size() > 0) {
                        CJRAmParkAutosuggestEventItem cJRAmParkAutosuggestEventItem = new CJRAmParkAutosuggestEventItem();
                        cJRAmParkAutosuggestEventItem.setParkName("THEME PARKS");
                        cJRAmParkAutosuggestEventItem.setType(2);
                        arrayList.add(cJRAmParkAutosuggestEventItem);
                        arrayList.addAll(this.f73333i.getThemeParkList());
                    }
                    if (this.f73333i.getWaterParkList() != null && this.f73333i.getWaterParkList().size() > 0) {
                        CJRAmParkAutosuggestEventItem cJRAmParkAutosuggestEventItem2 = new CJRAmParkAutosuggestEventItem();
                        cJRAmParkAutosuggestEventItem2.setParkName("WATER PARKS");
                        cJRAmParkAutosuggestEventItem2.setType(2);
                        arrayList.add(cJRAmParkAutosuggestEventItem2);
                        arrayList.addAll(this.f73333i.getWaterParkList());
                    }
                    if (this.f73333i.getFeaturedParkList() != null && this.f73333i.getFeaturedParkList().size() > 0) {
                        CJRAmParkAutosuggestEventItem cJRAmParkAutosuggestEventItem3 = new CJRAmParkAutosuggestEventItem();
                        cJRAmParkAutosuggestEventItem3.setParkName("FEATURED PARK");
                        cJRAmParkAutosuggestEventItem3.setType(2);
                        arrayList.add(cJRAmParkAutosuggestEventItem3);
                        arrayList.addAll(this.f73333i.getFeaturedParkList());
                    }
                }
                this.f73326a = arrayList;
                this.f73332h = new f(this, this.f73326a);
                this.f73330f.setAdapter(this.f73332h);
                c();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c();
        if (networkCustomError != null) {
            try {
                String message = networkCustomError.getMessage();
                if (message != null && message.equalsIgnoreCase("417")) {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
                } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                } else {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private static JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AJRAmParkSearchPage");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
