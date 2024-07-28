package com.travel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.a.a;
import com.travel.travelPreferences.CJRBusTpUserProfileContact;
import com.travel.travelPreferences.CJRBusUserDeleteProfile;
import com.travel.travelPreferences.CJRBusUserProfile;
import com.travel.travelPreferences.CJRViewFareAlerts;
import com.travel.travelPreferences.c;
import com.travel.travelPreferences.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRTravelPreferencesActivity extends CJRActionBarBaseActivity implements View.OnClickListener, d.b {
    private static String x = "AJRTravelPreferencesActivity";
    /* access modifiers changed from: private */
    public ArrayList<CJRBusTpUserProfileContact> A = new ArrayList<>();
    /* access modifiers changed from: private */
    public List<CJRViewFareAlerts.a> B = new ArrayList();
    private String C = "flight_dynamic";
    /* access modifiers changed from: private */
    public int D = 11;
    /* access modifiers changed from: private */
    public b E = new b() {
        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRBusUserProfile) {
                ArrayList unused = AJRTravelPreferencesActivity.this.y = ((CJRBusUserProfile) iJRPaytmDataModel).getBody().getContacts();
                AJRTravelPreferencesActivity.f(AJRTravelPreferencesActivity.this);
                if (AJRTravelPreferencesActivity.this.y != null && AJRTravelPreferencesActivity.this.y.size() > 0) {
                    AJRTravelPreferencesActivity.this.z.clear();
                    AJRTravelPreferencesActivity.this.z.addAll(AJRTravelPreferencesActivity.this.y);
                    AJRTravelPreferencesActivity aJRTravelPreferencesActivity = AJRTravelPreferencesActivity.this;
                    ArrayList<CJRBusTpUserProfileContact> c2 = aJRTravelPreferencesActivity.z;
                    aJRTravelPreferencesActivity.q = new ArrayList<>();
                    aJRTravelPreferencesActivity.q = c2;
                }
                AJRTravelPreferencesActivity.h(AJRTravelPreferencesActivity.this);
            } else if ((iJRPaytmDataModel instanceof CJRBusUserDeleteProfile) && AJRTravelPreferencesActivity.this.o != null) {
                AJRTravelPreferencesActivity.this.a();
                AJRTravelPreferencesActivity.this.z.remove(AJRTravelPreferencesActivity.this.o);
                AJRTravelPreferencesActivity.h(AJRTravelPreferencesActivity.this);
                AJRTravelPreferencesActivity.this.o = null;
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            AJRTravelPreferencesActivity.f(AJRTravelPreferencesActivity.this);
            AJRTravelPreferencesActivity.this.m.setVisibility(8);
            a.b(AJRTravelPreferencesActivity.this.m);
            if (i2 == 401 || i2 == 410) {
                d.a();
                d.b().a((Activity) AJRTravelPreferencesActivity.this);
            } else if (networkCustomError != null) {
                if (networkCustomError.getMessage() != null) {
                    networkCustomError.printStackTrace();
                }
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    d.a();
                    d.b().a((Activity) AJRTravelPreferencesActivity.this, networkCustomError);
                } else if (!TextUtils.isEmpty(networkCustomError.getAlertTitle()) && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                    com.paytm.utility.b.b((Context) AJRTravelPreferencesActivity.this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                } else if (networkCustomError.getMessage() != null) {
                    d.a();
                    if (d.b().a((Context) AJRTravelPreferencesActivity.this, networkCustomError, "error.trains@paytm.com")) {
                        return;
                    }
                    if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        AJRTravelPreferencesActivity aJRTravelPreferencesActivity = AJRTravelPreferencesActivity.this;
                        com.paytm.utility.b.b((Context) aJRTravelPreferencesActivity, aJRTravelPreferencesActivity.getResources().getString(R.string.network_error_heading), AJRTravelPreferencesActivity.this.getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                        return;
                    }
                    com.paytm.utility.b.b((Context) AJRTravelPreferencesActivity.this, AJRTravelPreferencesActivity.this.getResources().getString(R.string.error_data_display), AJRTravelPreferencesActivity.this.getResources().getString(R.string.trains_message_error_data_display));
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f21382a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f21383b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutManager f21384c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayoutManager f21385d;

    /* renamed from: e  reason: collision with root package name */
    com.travel.a.a f21386e;

    /* renamed from: f  reason: collision with root package name */
    d f21387f;

    /* renamed from: g  reason: collision with root package name */
    ConstraintLayout f21388g;

    /* renamed from: h  reason: collision with root package name */
    ConstraintLayout f21389h;

    /* renamed from: i  reason: collision with root package name */
    TextView f21390i;
    TextView j;
    TextView k;
    LottieAnimationView l;
    LottieAnimationView m;
    View n;
    CJRBusTpUserProfileContact o;
    boolean p = true;
    ArrayList<CJRBusTpUserProfileContact> q;
    a.C0423a r = new a.C0423a() {
        public final void a(CJRBusTpUserProfileContact cJRBusTpUserProfileContact) {
            AJRTravelPreferencesActivity aJRTravelPreferencesActivity = AJRTravelPreferencesActivity.this;
            aJRTravelPreferencesActivity.a(aJRTravelPreferencesActivity, aJRTravelPreferencesActivity.getString(R.string.please_wait));
            AJRTravelPreferencesActivity aJRTravelPreferencesActivity2 = AJRTravelPreferencesActivity.this;
            Context applicationContext = aJRTravelPreferencesActivity2.getApplicationContext();
            b a2 = AJRTravelPreferencesActivity.this.E;
            if (aJRTravelPreferencesActivity2.q != null && aJRTravelPreferencesActivity2.q.size() > 0) {
                aJRTravelPreferencesActivity2.q.remove(cJRBusTpUserProfileContact);
            }
            d.a();
            String s = com.paytm.utility.b.s(applicationContext, d.b().a("tpDeleteTraveler"));
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject a3 = AJRTravelPreferencesActivity.a(applicationContext, cJRBusTpUserProfileContact);
            if (URLUtil.isValidUrl(s)) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = applicationContext;
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = s;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = a3.toString();
                bVar.f42885i = new CJRBusUserDeleteProfile();
                bVar.j = a2;
                bVar.t = AJRTravelPreferencesActivity.b();
                bVar.n = a.b.SILENT;
                bVar.o = "bus-traveller-page";
                bVar.l().a();
            }
            AJRTravelPreferencesActivity.this.o = cJRBusTpUserProfileContact;
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<CJRBusTpUserProfileContact> y = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<CJRBusTpUserProfileContact> z = new ArrayList<>();

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pre_td_activity_ajrtravel_preferences);
        setTitle(getString(R.string.travel_preferences_heading));
        e();
        c();
        d();
        this.f21388g = (ConstraintLayout) findViewById(R.id.savedTravelCL);
        this.f21382a = (RecyclerView) findViewById(R.id.travellersRView);
        this.f21383b = (RecyclerView) findViewById(R.id.fareAlertsRView);
        this.f21390i = (TextView) findViewById(R.id.noTravellers);
        this.k = (TextView) findViewById(R.id.noSubsFareAlert);
        this.j = (TextView) findViewById(R.id.viewAll);
        this.f21389h = (ConstraintLayout) findViewById(R.id.createAlert);
        this.n = findViewById(R.id.sep);
        this.l = (LottieAnimationView) findViewById(R.id.travelProgress);
        this.m = (LottieAnimationView) findViewById(R.id.fareProgress);
        this.f21384c = new LinearLayoutManager(this, 1, false);
        this.f21382a.setLayoutManager(this.f21384c);
        this.f21386e = new com.travel.a.a(this, this.A, this.r);
        this.f21382a.setAdapter(this.f21386e);
        this.f21385d = new LinearLayoutManager(this, 1, false);
        this.f21383b.setLayoutManager(this.f21385d);
        this.f21387f = new d(this, this, this.B);
        this.f21383b.setAdapter(this.f21387f);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRTravelPreferencesActivity.this.p) {
                    AJRTravelPreferencesActivity.this.j.setText("View Less");
                    AJRTravelPreferencesActivity.this.A.clear();
                    AJRTravelPreferencesActivity.this.A.addAll(AJRTravelPreferencesActivity.this.z);
                    AJRTravelPreferencesActivity.this.f21386e.notifyDataSetChanged();
                } else {
                    AJRTravelPreferencesActivity.this.j.setText("View All");
                    AJRTravelPreferencesActivity.this.A.clear();
                    AJRTravelPreferencesActivity.this.A.add(AJRTravelPreferencesActivity.this.z.get(0));
                    AJRTravelPreferencesActivity.this.A.add(AJRTravelPreferencesActivity.this.z.get(1));
                    AJRTravelPreferencesActivity.this.f21386e.notifyDataSetChanged();
                }
                AJRTravelPreferencesActivity aJRTravelPreferencesActivity = AJRTravelPreferencesActivity.this;
                aJRTravelPreferencesActivity.p = true ^ aJRTravelPreferencesActivity.p;
            }
        });
        this.f21389h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                boolean z = false;
                try {
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    Class<?> cls = Class.forName("net.one97.paytm.deeplink.FlightUtils");
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    Method method = cls.getMethod("isFlightInstalled", new Class[0]);
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    z = ((Boolean) method.invoke((Object) null, new Object[0])).booleanValue();
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    if (z) {
                        AJRTravelPreferencesActivity.class.getSimpleName();
                        Intent intent = new Intent();
                        intent.setClassName("net.one97.paytm", "com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity");
                        AJRTravelPreferencesActivity.class.getSimpleName();
                        AJRTravelPreferencesActivity.this.startActivityForResult(intent, AJRTravelPreferencesActivity.this.D);
                        AJRTravelPreferencesActivity.class.getSimpleName();
                    }
                } catch (Exception e2) {
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    e2.getMessage();
                    AJRTravelPreferencesActivity.class.getSimpleName();
                    new StringBuilder("Exception is thrown").append(e2.getMessage());
                }
                if (!z) {
                    AJRTravelPreferencesActivity aJRTravelPreferencesActivity = AJRTravelPreferencesActivity.this;
                    com.paytm.utility.b.b((Context) aJRTravelPreferencesActivity, aJRTravelPreferencesActivity.getString(R.string.flight_info_title), aJRTravelPreferencesActivity.getString(R.string.flight_feature_downloading_message));
                }
            }
        });
        net.one97.paytm.common.widgets.a.a(this.l);
        this.l.setVisibility(0);
        com.travel.travelPreferences.a aVar = com.travel.travelPreferences.a.all;
        b bVar = this.E;
        d.a();
        String a2 = d.b().a("tpGetTravelers");
        if (aVar == com.travel.travelPreferences.a.all) {
            str = a2 + "?vertical=";
        } else {
            str = a2 + "?vertical=" + aVar;
        }
        String s = com.paytm.utility.b.s(this, str);
        if (aVar.name().equalsIgnoreCase("train") && s != null && URLUtil.isValidUrl(s)) {
            if (c.a(this) != null) {
                s = v.a(s, AppConstants.AND_SIGN, "user_email", "=", c.a(this));
            }
            if (c.b(this) != null) {
                s = v.a(s, AppConstants.AND_SIGN, "user_mobile", "=", c.b(this));
            }
        }
        HashMap hashMap = new HashMap();
        d.a();
        hashMap.put("sso-token", d.b().a((Context) this));
        if (URLUtil.isValidUrl(s)) {
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = this;
            bVar2.f42878b = a.c.BUS;
            bVar2.f42879c = a.C0715a.GET;
            bVar2.f42880d = s;
            bVar2.f42881e = null;
            bVar2.f42882f = hashMap;
            bVar2.f42883g = null;
            bVar2.f42884h = null;
            bVar2.f42885i = new CJRBusUserProfile();
            bVar2.j = bVar;
            bVar2.t = b();
            bVar2.n = a.b.SILENT;
            bVar2.o = "bus-traveller-page";
            com.paytm.network.a l2 = bVar2.l();
            l2.f42860d = true;
            l2.a();
        }
        f();
    }

    private void f() {
        net.one97.paytm.common.widgets.a.a(this.m);
        this.m.setVisibility(0);
        a(getApplicationContext(), new CJRViewFareAlerts(), new b() {
            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRViewFareAlerts) {
                    AJRTravelPreferencesActivity.this.B.clear();
                    AJRTravelPreferencesActivity.this.B.addAll(((CJRViewFareAlerts) iJRPaytmDataModel).getBody());
                    net.one97.paytm.common.widgets.a.b(AJRTravelPreferencesActivity.this.m);
                    AJRTravelPreferencesActivity.this.m.setVisibility(8);
                    if (AJRTravelPreferencesActivity.this.B.size() == 0) {
                        AJRTravelPreferencesActivity.this.f21383b.setVisibility(8);
                        AJRTravelPreferencesActivity.this.k.setVisibility(0);
                        AJRTravelPreferencesActivity.this.n.setVisibility(0);
                        return;
                    }
                    AJRTravelPreferencesActivity.this.n.setVisibility(8);
                    AJRTravelPreferencesActivity.this.k.setVisibility(8);
                    AJRTravelPreferencesActivity.this.f21383b.setVisibility(0);
                    AJRTravelPreferencesActivity.this.f21387f.notifyDataSetChanged();
                }
            }
        });
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        d();
        c();
        return super.onPrepareOptionsMenu(menu);
    }

    public void onClick(View view) {
        view.getId();
    }

    public final void a() {
        try {
            if (this.t != null && this.t.isShowing() && !isFinishing()) {
                this.t.dismiss();
                this.t = null;
            }
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        setResult(-1, new Intent());
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.D) {
            f();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusTravellersScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    private void a(Context context, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        if (context != null) {
            d.a();
            String a2 = d.b().a("flightViewFareAlertUrl");
            if (URLUtil.isValidUrl(a2)) {
                HashMap hashMap = new HashMap();
                hashMap.put("sso-token", com.paytm.utility.a.q(context));
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = getApplicationContext();
                bVar2.n = a.b.SILENT;
                bVar2.o = context.getClass().getSimpleName();
                bVar2.f42878b = a.c.FLIGHT;
                bVar2.f42879c = a.C0715a.GET;
                bVar2.f42880d = a2;
                bVar2.f42881e = null;
                bVar2.f42882f = hashMap;
                bVar2.f42883g = null;
                bVar2.f42884h = null;
                bVar2.f42885i = iJRPaytmDataModel;
                bVar2.j = bVar;
                bVar2.t = null;
                com.paytm.network.a l2 = bVar2.l();
                l2.f42860d = true;
                l2.a();
            }
        }
    }

    public static JSONObject a(Context context, CJRBusTpUserProfileContact cJRBusTpUserProfileContact) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(cJRBusTpUserProfileContact.getPerson_id())) {
                jSONObject.put("person_id", cJRBusTpUserProfileContact.getPerson_id());
            }
            jSONObject.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
            return jSONObject;
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    static /* synthetic */ void f(AJRTravelPreferencesActivity aJRTravelPreferencesActivity) {
        aJRTravelPreferencesActivity.l.setVisibility(8);
        net.one97.paytm.common.widgets.a.b(aJRTravelPreferencesActivity.l);
    }

    static /* synthetic */ void h(AJRTravelPreferencesActivity aJRTravelPreferencesActivity) {
        ArrayList<CJRBusTpUserProfileContact> arrayList = aJRTravelPreferencesActivity.z;
        if (arrayList == null || arrayList.size() == 0) {
            aJRTravelPreferencesActivity.j.setVisibility(8);
            aJRTravelPreferencesActivity.f21382a.setVisibility(8);
            aJRTravelPreferencesActivity.f21390i.setVisibility(0);
            return;
        }
        aJRTravelPreferencesActivity.A.clear();
        aJRTravelPreferencesActivity.f21390i.setVisibility(8);
        aJRTravelPreferencesActivity.f21382a.setVisibility(0);
        if (aJRTravelPreferencesActivity.z.size() < 3) {
            aJRTravelPreferencesActivity.j.setVisibility(8);
            aJRTravelPreferencesActivity.A.addAll(aJRTravelPreferencesActivity.z);
        } else {
            aJRTravelPreferencesActivity.j.setVisibility(0);
            if (aJRTravelPreferencesActivity.j.getText().equals("View All")) {
                aJRTravelPreferencesActivity.A.add(aJRTravelPreferencesActivity.z.get(0));
                aJRTravelPreferencesActivity.A.add(aJRTravelPreferencesActivity.z.get(1));
            } else {
                aJRTravelPreferencesActivity.A.addAll(aJRTravelPreferencesActivity.z);
            }
        }
        aJRTravelPreferencesActivity.f21386e.notifyDataSetChanged();
    }
}
