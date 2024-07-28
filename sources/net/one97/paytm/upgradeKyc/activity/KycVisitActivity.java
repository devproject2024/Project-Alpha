package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.FetchCashPointRequestModal;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.a.c;
import net.one97.paytm.upgradeKyc.d.p;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class KycVisitActivity extends UpgradeKycBaseActivity implements View.OnClickListener, e.b, e.c, com.google.android.gms.location.e, l.a {

    /* renamed from: a  reason: collision with root package name */
    public static long f65359a = 10000;

    /* renamed from: b  reason: collision with root package name */
    public static long f65360b = 1000;

    /* renamed from: d  reason: collision with root package name */
    private String f65361d;

    /* renamed from: e  reason: collision with root package name */
    private String f65362e;

    /* renamed from: f  reason: collision with root package name */
    private e f65363f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f65364g;

    /* renamed from: h  reason: collision with root package name */
    private LocationManager f65365h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f65366i;
    private Toast j;
    private String k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private double[] p;
    private ArrayList<PayTMPartnerListModal.Response> q;
    private String r;
    private String s;
    private String t;

    public void onConnectionSuspended(int i2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.q = (ArrayList) extras.getSerializable("kyc_center_list");
                this.f65361d = extras.getString("doc_type");
                this.t = extras.getString("vertical");
                this.f65362e = extras.getString("doc_number");
            } else {
                this.q = new ArrayList<>();
            }
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = "kyc";
        }
        if (this.t.equalsIgnoreCase("kyc")) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().a(0.0f);
            }
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a("/kyc-wallet-upgrade/choose-kyc-option", this.t, (Context) this);
        } else if (this.t.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().f();
            }
            findViewById(R.id.activity_kyc_visit_lyt_bank_header).setVisibility(0);
            findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(this);
        }
        this.f65365h = (LocationManager) getSystemService("location");
        this.f65366i = (RelativeLayout) findViewById(R.id.rl_progress_bar);
        this.p = new double[2];
        this.r = "Request";
        this.s = "Dynamic";
        d.a aVar2 = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar3 = d.f66026a;
            d.a.a();
            this.n = d.a("courier_tab_visible", false);
        }
        this.o = false;
        l.a();
        if (l.a((Context) this, (l.a) this)) {
            this.f65363f = new e.a(this).a((a<? extends a.d.C0127d>) f.f11372a).a((e.b) this).a((e.c) this).a();
        }
        this.f65364g = new LocationRequest();
        this.f65364g.a(f65359a);
        this.f65364g.b(f65360b);
        this.f65364g.a(100);
        LocationSettingsRequest.a aVar4 = new LocationSettingsRequest.a();
        aVar4.a(this.f65364g);
        aVar4.f11355a = true;
        if (this.f65363f != null) {
            f.f11375d.a(this.f65363f, aVar4.b()).a(new m() {
                public final void onResult(com.google.android.gms.common.api.l lVar) {
                    KycVisitActivity.this.a((LocationSettingsResult) lVar);
                }
            });
        }
        if (Build.VERSION.SDK_INT < 23) {
            e();
        } else if (b.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 109);
        } else {
            e();
        }
        f();
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        if (this.m) {
            l.a();
            l.a((Context) this, (l.a) this);
        }
        this.m = false;
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        com.google.android.gms.common.api.e eVar = this.f65363f;
        if (eVar != null && eVar.f()) {
            this.f65363f.e();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 102 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 3) {
            l.a();
            if (!l.a(this.f65365h)) {
                Toast.makeText(this, getString(R.string.error_msg_locationadapter_not_working), 1).show();
                finish();
                return;
            }
            g();
        } else if (i2 != 105) {
        } else {
            if (i3 == -1) {
                e();
            } else if (i3 == 0) {
                h();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 109) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                h();
            } else {
                e();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private void e() {
        com.google.android.gms.common.api.e eVar = this.f65363f;
        if (eVar != null && !eVar.f()) {
            this.f65363f.d();
            this.f65363f.a((e.b) this);
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f65366i.setVisibility(0);
        } else {
            this.f65366i.setVisibility(8);
        }
    }

    private void f() {
        ((ViewPager) findViewById(R.id.activity_kyc_visit_pager)).setAdapter(new c(this, getSupportFragmentManager(), this.f65362e, this.f65361d, this.n, this.r, this.s, this.q));
        if (!com.paytm.utility.b.c((Context) this)) {
            ((RelativeLayout) LayoutInflater.from(this).inflate(R.layout.kyc_error_network_off, (ViewGroup) null).findViewById(R.id.error_toolbar)).setVisibility(8);
        }
    }

    private void g() {
        com.google.android.gms.common.api.e eVar = this.f65363f;
        if (eVar != null && eVar.f()) {
            if (androidx.core.app.a.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a((Context) this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                f.f11373b.a(this.f65363f, this.f65364g, this);
            }
        }
    }

    public void openLocationSetting(View view) {
        startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 3);
    }

    public void onConnected(Bundle bundle) {
        g();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Could not connect to Google API Client: Error " + connectionResult.f8334b, 0).show();
    }

    public final void a(Location location) {
        this.p[0] = location.getLatitude();
        this.p[1] = location.getLongitude();
        if (!this.o) {
            h();
        }
        if (this.f65363f != null) {
            f.f11373b.a(this.f65363f, this);
        }
    }

    public final void d() {
        this.m = true;
    }

    public final int a() {
        return R.layout.activity_kyc_visit;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    private void h() {
        if (!com.paytm.utility.b.c((Context) this)) {
            Toast toast = this.j;
            if (toast == null) {
                this.j = Toast.makeText(this, getString(R.string.no_internet), 0);
                this.j.show();
                return;
            }
            toast.cancel();
            this.j = Toast.makeText(this, getString(R.string.no_internet), 0);
            this.j.show();
            return;
        }
        double[] dArr = this.p;
        a(a(dArr[0], dArr[1], "SERVICE", FetchCashPointRequestModal.FilterType.KYC_POINT.toString()));
    }

    private static FetchCashPointRequestModal a(double d2, double d3, String str, String str2) {
        FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
        fetchCashPointRequestModal.getClass();
        fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
        fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
        fetchCashPointRequestModal.request.sortBy = hashMap;
        fetchCashPointRequestModal.request.startLimit = 0;
        fetchCashPointRequestModal.request.endLimit = 20;
        fetchCashPointRequestModal.getClass();
        FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
        searchFilter.filterType = str;
        searchFilter.value = str2;
        fetchCashPointRequestModal.request.searchFilter.add(0, searchFilter);
        fetchCashPointRequestModal.request.latitude = String.valueOf(d2);
        fetchCashPointRequestModal.request.longitude = String.valueOf(d3);
        return fetchCashPointRequestModal;
    }

    private void a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            if (!isFinishing()) {
                d.a aVar = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar2 = d.f66026a;
                    d.a.a();
                    this.k = d.a("nearbyMerchant");
                }
                if (this.k == null) {
                    return;
                }
                if (URLUtil.isValidUrl(this.k)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this));
                    new StringBuilder("SSO Token :: ").append((String) hashMap.get("ssotoken"));
                    com.paytm.utility.b.j();
                    JSONObject createNearByRequestBody = NearbyRequestCreator.getNearbyRequestCreatorInstance().createNearByRequestBody(fetchCashPointRequestModal);
                    a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a2 = a.C1317a.a();
                    a2.f42877a = this;
                    a2.f42879c = a.C0715a.POST;
                    a2.f42882f = hashMap;
                    a2.f42885i = new PayTMPartnerListModal();
                    a2.f42884h = createNearByRequestBody.toString();
                    a2.o = KycVisitActivity.class.getName();
                    a2.f42880d = this.k;
                    a2.n = a.b.USER_FACING;
                    a2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            KycVisitActivity.a(KycVisitActivity.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            l.a();
                            l.a((Context) KycVisitActivity.this, networkCustomError);
                        }
                    };
                    com.paytm.network.a l2 = a2.l();
                    if (com.paytm.utility.b.c((Context) this)) {
                        a(true);
                        l2.a();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.payments_bank_info_btn_close) {
            finish();
        }
    }

    private void i() {
        findViewById(R.id.error_fragment_container).setVisibility(0);
        findViewById(R.id.kyc_center_parent_layout).setVisibility(8);
        q a2 = getSupportFragmentManager().a();
        a2.a(R.id.error_fragment_container, (Fragment) new p());
        a2.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(LocationSettingsResult locationSettingsResult) {
        Status status = locationSettingsResult.f11359a;
        int i2 = status.f8360g;
        if (i2 != 0 && i2 == 6) {
            try {
                status.a(this, 105);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    static /* synthetic */ void a(KycVisitActivity kycVisitActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        kycVisitActivity.a(false);
        if (iJRPaytmDataModel instanceof PayTMPartnerListModal) {
            kycVisitActivity.o = true;
            PayTMPartnerListModal payTMPartnerListModal = (PayTMPartnerListModal) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase("SUCCESS")) {
                kycVisitActivity.q.addAll(payTMPartnerListModal.response);
                if (kycVisitActivity.q.size() == 0) {
                    kycVisitActivity.i();
                }
            } else if (!TextUtils.isEmpty(payTMPartnerListModal.status) && payTMPartnerListModal.status.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                kycVisitActivity.i();
            }
            try {
                if (com.paytm.utility.b.c((Context) kycVisitActivity)) {
                    kycVisitActivity.a(true);
                    d.a aVar = d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar2 = d.f66026a;
                        d.a.a();
                        kycVisitActivity.l = d.a("screen_tabs");
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("session_token", com.paytm.utility.a.q(kycVisitActivity));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("noOfNearbyCentres", kycVisitActivity.q.size());
                    a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a2 = a.C1317a.a();
                    a2.f42877a = kycVisitActivity;
                    a2.f42879c = a.C0715a.POST;
                    a2.f42882f = hashMap;
                    a2.f42885i = new ScreenTabModel();
                    a2.f42884h = jSONObject.toString();
                    a2.o = KycVisitActivity.class.getName();
                    a2.f42880d = kycVisitActivity.l;
                    a2.n = a.b.USER_FACING;
                    a2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            KycVisitActivity.a(KycVisitActivity.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            l.a();
                            if (!l.a((Context) KycVisitActivity.this, networkCustomError)) {
                                a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                                a.C1317a.a((Context) KycVisitActivity.this, networkCustomError);
                            }
                        }
                    };
                    a2.l().a();
                }
            } catch (JSONException unused) {
            }
        } else if (iJRPaytmDataModel instanceof ScreenTabModel) {
            ScreenTabModel screenTabModel = (ScreenTabModel) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(screenTabModel.getTab1()) || !TextUtils.isEmpty(screenTabModel.getTab2())) {
                kycVisitActivity.r = screenTabModel.getTab1();
                kycVisitActivity.s = screenTabModel.getTab2();
            }
            kycVisitActivity.f();
        }
    }
}
