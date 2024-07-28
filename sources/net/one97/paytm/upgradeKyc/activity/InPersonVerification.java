package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.FetchCashPointRequestModal;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.aotp.a.a;
import net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.helper.f;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycDoorStepActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.videokyc.activity.AddPanVideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final class InPersonVerification extends UpgradeKycBaseActivity implements View.OnClickListener, a.C1294a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65286a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f65287b;

    /* renamed from: d  reason: collision with root package name */
    private PayTMPartnerListModal f65288d;

    /* renamed from: e  reason: collision with root package name */
    private ScreenTabModel f65289e;

    /* renamed from: f  reason: collision with root package name */
    private String f65290f;

    /* renamed from: g  reason: collision with root package name */
    private String f65291g;

    /* renamed from: h  reason: collision with root package name */
    private String f65292h;

    /* renamed from: i  reason: collision with root package name */
    private String f65293i;
    private String j;
    private double[] k = new double[2];
    private boolean l;
    private String m;
    private String n;
    private ArrayList<PayTMPartnerListModal.Response> o;
    private KYCDetail p;
    private boolean q;
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onClick(View view) {
        HashMap hashMap = new HashMap();
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.kyc_point;
        if (valueOf != null && valueOf.intValue() == i2) {
            b("visit_nearby_click", "/kyc/tab-screen");
            hashMap.put("event_label", "nearby kyc points");
            UpgradeKycBaseActivity.a(this, "/kyc/verification-screen", "verification_method_tab_clicked", hashMap, (String) null, 8);
            ArrayList arrayList = new ArrayList();
            e.a aVar = e.f66028b;
            Context context = this;
            e.a.b().a(context, "in_person_verification", "visit_nearby_points_clicked", arrayList, "", "/kyc-wallet-upgrade/in-person", "kyc");
            startActivity(new Intent(context, KycNearByActivity.class));
            return;
        }
        int i3 = R.id.door_step;
        boolean z = false;
        if (valueOf != null && valueOf.intValue() == i3) {
            b("kyc_doorstep_click", "/kyc/tab-screen");
            hashMap.put("event_label", "doorstep");
            UpgradeKycBaseActivity.a(this, "/kyc/verification-screen", "verification_method_tab_clicked", hashMap, (String) null, 8);
            KycDoorStepActivity.a aVar2 = KycDoorStepActivity.f66107b;
            KycDoorStepActivity.a.a(this, false);
            finish();
            return;
        }
        int i4 = R.id.payments_bank_info_btn_close;
        if (valueOf != null && valueOf.intValue() == i4) {
            b("go_back_clicked", "/kyc/tab-screen");
            onBackPressed();
            return;
        }
        int i5 = R.id.aotp_entry_lyt;
        if (valueOf != null && valueOf.intValue() == i5) {
            hashMap.put("event_label", "otp");
            UpgradeKycBaseActivity.a(this, "/kyc/verification-screen", "verification_method_tab_clicked", hashMap, (String) null, 8);
            Intent intent = new Intent(this, EnterAadhaarDetailsActivity.class);
            intent.putExtra("isVideoKYCFlow", false);
            startActivity(intent);
            finish();
            return;
        }
        int i6 = R.id.video_kyc_cl;
        if (valueOf != null && valueOf.intValue() == i6) {
            b("video_kyc_tab_click", "/kyc/tab-screen");
            e.a aVar3 = e.f66028b;
            String g2 = j.g(e.a.b().a());
            e.a aVar4 = e.f66028b;
            if (!j.m(e.a.b().a())) {
                d();
                return;
            }
            e.a aVar5 = e.f66028b;
            if (j.m(e.a.b().a())) {
                CharSequence charSequence = g2;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    Date b2 = net.one97.paytm.upgradeKyc.utils.c.b(g2);
                    if (b2 != null) {
                        z = b2.before(net.one97.paytm.upgradeKyc.utils.c.b("15 May 2021"));
                    }
                    if (z) {
                        getSupportFragmentManager().a().a(R.id.container, (Fragment) new net.one97.paytm.upgradeKyc.aotp.a.a()).a((String) null).c();
                        return;
                    }
                }
            }
            e.a aVar6 = e.f66028b;
            f fVar = e.a.a().f66030a;
            if (fVar == null) {
                k.a();
            }
            if (!j.e(fVar.a())) {
                startActivity(new Intent(this, AddPanVideoKycActivity.class));
                finish();
                return;
            }
            startActivity(new Intent(this, VideoKycActivity.class));
            finish();
        }
    }

    public final void onAttachFragment(Fragment fragment) {
        k.c(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof net.one97.paytm.upgradeKyc.aotp.a.a) {
            a.C1294a aVar = this;
            k.c(aVar, "<set-?>");
            ((net.one97.paytm.upgradeKyc.aotp.a.a) fragment).f65468a = aVar;
        }
    }

    private final void d() {
        Intent intent = new Intent(this, EnterAadhaarDetailsActivity.class);
        intent.putExtra("isVideoKYCFlow", true);
        startActivity(intent);
        finish();
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.in_person_verification_layout;
    }

    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        a("/kyc/verification-screen", "kyc_new", "signal");
        String str = "";
        this.f65290f = (getIntent() == null || !getIntent().hasExtra("doc_type")) ? str : getIntent().getStringExtra("doc_type");
        this.f65291g = (getIntent() == null || !getIntent().hasExtra("doc_number")) ? str : getIntent().getStringExtra("doc_number");
        if (getIntent() != null && getIntent().hasExtra("doc_expiry")) {
            str = getIntent().getStringExtra("doc_expiry");
        }
        this.f65292h = str;
        Intent intent = getIntent();
        this.q = intent != null ? intent.getBooleanExtra("ekyc_complete", false) : false;
        if (getIntent() != null && getIntent().hasExtra("hideAotpAadhaar")) {
            this.f65287b = getIntent().getBooleanExtra("hideAotpAadhaar", false);
        }
        Intent intent2 = getIntent();
        String str2 = null;
        if (!TextUtils.isEmpty(intent2 != null ? intent2.getStringExtra("inperson_verification_title") : null)) {
            TextView textView = (TextView) a(R.id.ipv_complete_kyc_tv);
            k.a((Object) textView, "ipv_complete_kyc_tv");
            Intent intent3 = getIntent();
            textView.setText(intent3 != null ? intent3.getStringExtra("inperson_verification_title") : null);
        }
        e.a aVar = e.f66028b;
        Context context = this;
        e.a.b().a("/kyc-wallet-upgrade/in-person", "kyc", context);
        if (getIntent() != null) {
            Intent intent4 = getIntent();
            k.a((Object) intent4, "intent");
            bundle2 = intent4.getExtras();
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.p = (KYCDetail) bundle2.getSerializable("kyc_additional_info");
            this.f65293i = bundle2.getString("vertical");
            this.j = bundle2.getString("call_back_url");
            KYCDetail kYCDetail = this.p;
            if (kYCDetail != null) {
                if ((kYCDetail != null ? kYCDetail.getPOIType() : null) != null) {
                    KYCDetail kYCDetail2 = this.p;
                    this.f65290f = kYCDetail2 != null ? kYCDetail2.getPOIType() : null;
                }
                KYCDetail kYCDetail3 = this.p;
                if ((kYCDetail3 != null ? kYCDetail3.getPoINumber() : null) != null) {
                    KYCDetail kYCDetail4 = this.p;
                    this.f65291g = kYCDetail4 != null ? kYCDetail4.getPoINumber() : null;
                }
            }
        }
        this.l = false;
        this.o = new ArrayList<>();
        this.k = new double[2];
        e.a aVar2 = e.f66028b;
        String s = com.paytm.utility.b.s(e.a.b().a());
        k.a((Object) s, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b2 = p.b(s);
        e.a aVar3 = e.f66028b;
        String t = com.paytm.utility.b.t(e.a.b().a());
        k.a((Object) t, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b3 = p.b(t);
        if (b2 == null || b3 == null) {
            double[] dArr = this.k;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        } else {
            this.k[0] = b2.doubleValue();
            this.k[1] = b3.doubleValue();
        }
        if (!com.paytm.utility.b.c(context)) {
            Toast.makeText(context, getString(R.string.no_internet), 1);
        } else {
            double[] dArr2 = this.k;
            double d2 = dArr2[0];
            double d3 = dArr2[1];
            String filterType = FetchCashPointRequestModal.FilterType.KYC_POINT.toString();
            FetchCashPointRequestModal fetchCashPointRequestModal = new FetchCashPointRequestModal();
            fetchCashPointRequestModal.request = new FetchCashPointRequestModal.Request();
            fetchCashPointRequestModal.request.searchFilter = new ArrayList(1);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(FetchCashPointRequestModal.SortByFilter.OPENING_TIME_SORT.toString(), FetchCashPointRequestModal.SortingType.ASC.toString());
            fetchCashPointRequestModal.request.sortBy = hashMap;
            fetchCashPointRequestModal.request.startLimit = 0;
            fetchCashPointRequestModal.request.endLimit = 20;
            FetchCashPointRequestModal.SearchFilter searchFilter = new FetchCashPointRequestModal.SearchFilter();
            searchFilter.filterType = "SERVICE";
            searchFilter.value = filterType;
            fetchCashPointRequestModal.request.searchFilter.add(0, searchFilter);
            fetchCashPointRequestModal.request.latitude = String.valueOf(d2);
            fetchCashPointRequestModal.request.longitude = String.valueOf(d3);
            try {
                if (!isFinishing()) {
                    d.a aVar4 = d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar5 = d.f66026a;
                        if (d.a.a() != null) {
                            str2 = d.a("nearbyMerchant");
                        }
                        this.m = str2;
                    }
                    if (this.m != null) {
                        if (URLUtil.isValidUrl(this.m)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("Content-Type", "application/json");
                            String a2 = com.paytm.utility.d.a(this);
                            k.a((Object) a2, "CJRNetUtility.getSSOToken(this)");
                            hashMap2.put("ssotoken", a2);
                            new StringBuilder("SSO Token :: ").append((String) hashMap2.get("ssotoken"));
                            com.paytm.utility.b.j();
                            JSONObject createNearByRequestBody = NearbyRequestCreator.getNearbyRequestCreatorInstance().createNearByRequestBody(fetchCashPointRequestModal);
                            a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            com.paytm.network.a l2 = a.C1317a.a().a((Context) this).a(a.C0715a.POST).a((Map<String, String>) hashMap2).a((IJRPaytmDataModel) new PayTMPartnerListModal()).a(this.m).c(InPersonVerification.class.getName()).b(createNearByRequestBody.toString()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c(this)).l();
                            if (com.paytm.utility.b.c((Context) this)) {
                                net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
                                l2.a();
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        View.OnClickListener onClickListener = this;
        ((ConstraintLayout) a(R.id.kyc_point)).setOnClickListener(onClickListener);
        ((ConstraintLayout) a(R.id.door_step)).setOnClickListener(onClickListener);
        ((ConstraintLayout) a(R.id.aotp_entry_lyt)).setOnClickListener(onClickListener);
        ((ConstraintLayout) a(R.id.video_kyc_cl)).setOnClickListener(onClickListener);
    }

    private final void e() {
        Intent intent;
        if (this.f65287b) {
            TextView textView = (TextView) a(R.id.tv_sub_header);
            k.a((Object) textView, "tv_sub_header");
            net.one97.paytm.upgradeKyc.kycV3.b.b(textView);
            TextView textView2 = (TextView) a(R.id.tv_sub_header);
            k.a((Object) textView2, "tv_sub_header");
            textView2.setText(getString(R.string.kyc_recommended_methods_after_error));
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.aotp_entry_lyt);
            k.a((Object) constraintLayout, "aotp_entry_lyt");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) constraintLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.video_kyc_cl);
            k.a((Object) constraintLayout2, "video_kyc_cl");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) constraintLayout2);
            TextView textView3 = (TextView) a(R.id.other_options_tv);
            k.a((Object) textView3, "other_options_tv");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) textView3);
        }
        TextView textView4 = (TextView) a(R.id.ipv_complete_kyc_tv);
        k.a((Object) textView4, "ipv_complete_kyc_tv");
        net.one97.paytm.upgradeKyc.kycV3.b.b(textView4);
        Context context = this;
        if (p.a(j.c(context), "otp", true)) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.aotp_entry_lyt);
            k.a((Object) constraintLayout3, "aotp_entry_lyt");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) constraintLayout3);
        } else if (!this.f65287b) {
            d.a aVar = d.f66026a;
            if (d.a.a() != null && d.a("isAOTPFlowActive", true) && (intent = getIntent()) != null && !intent.getBooleanExtra("ekyc_complete", false) && !l.a(context)) {
                ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.aotp_entry_lyt);
                k.a((Object) constraintLayout4, "aotp_entry_lyt");
                net.one97.paytm.upgradeKyc.kycV3.b.b(constraintLayout4);
            }
        }
        if (this.q) {
            View a2 = a(R.id.ekyc_success_separator);
            k.a((Object) a2, "ekyc_success_separator");
            net.one97.paytm.upgradeKyc.kycV3.b.b(a2);
            TextView textView5 = (TextView) a(R.id.your_ekyc_tv);
            k.a((Object) textView5, "your_ekyc_tv");
            net.one97.paytm.upgradeKyc.kycV3.b.b(textView5);
            Space space = (Space) a(R.id.space);
            k.a((Object) space, "space");
            net.one97.paytm.upgradeKyc.kycV3.b.b(space);
            return;
        }
        View a3 = a(R.id.ekyc_success_separator);
        k.a((Object) a3, "ekyc_success_separator");
        net.one97.paytm.upgradeKyc.kycV3.b.a(a3);
        TextView textView6 = (TextView) a(R.id.your_ekyc_tv);
        k.a((Object) textView6, "your_ekyc_tv");
        net.one97.paytm.upgradeKyc.kycV3.b.a((View) textView6);
        Space space2 = (Space) a(R.id.space);
        k.a((Object) space2, "space");
        net.one97.paytm.upgradeKyc.kycV3.b.a((View) space2);
    }

    private final void f() {
        if (TextUtils.isEmpty(this.f65293i) || !p.a(this.f65293i, CJRPGTransactionRequestUtils.PAYER_BANK_NAME, true)) {
            View a2 = a(R.id.lyt_bank_header);
            k.a((Object) a2, "lyt_bank_header");
            net.one97.paytm.upgradeKyc.kycV3.b.a(a2);
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        View a3 = a(R.id.lyt_bank_header);
        k.a((Object) a3, "lyt_bank_header");
        net.one97.paytm.upgradeKyc.kycV3.b.b(a3);
        ((ImageView) findViewById(R.id.payments_bank_info_btn_close)).setOnClickListener(this);
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InPersonVerification f65295a;

        c(InPersonVerification inPersonVerification) {
            this.f65295a = inPersonVerification;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            InPersonVerification.a(this.f65295a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            if (!l.a((Context) this.f65295a, networkCustomError)) {
                InPersonVerification.a(this.f65295a, networkCustomError);
            }
        }
    }

    private final void g() {
        try {
            if (com.paytm.utility.b.c((Context) this)) {
                d.a aVar = d.f66026a;
                Integer num = null;
                if (d.a.a() != null) {
                    d.a aVar2 = d.f66026a;
                    this.n = d.a.a() != null ? d.a("screen_tabs") : null;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                String a2 = com.paytm.utility.d.a(this);
                k.a((Object) a2, "CJRNetUtility.getSSOToken(this)");
                hashMap.put("session_token", a2);
                JSONObject jSONObject = new JSONObject();
                ArrayList<PayTMPartnerListModal.Response> arrayList = this.o;
                if (arrayList != null) {
                    num = Integer.valueOf(arrayList.size());
                }
                jSONObject.put("noOfNearbyCentres", num);
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a().a((Context) this).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new ScreenTabModel()).a(this.n).c(InPersonVerification.class.getName()).b(jSONObject.toString()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new b(this)).l().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InPersonVerification f65294a;

        b(InPersonVerification inPersonVerification) {
            this.f65294a = inPersonVerification;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            InPersonVerification.a(this.f65294a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            if (!l.a((Context) this.f65294a, networkCustomError)) {
                InPersonVerification.a(this.f65294a, networkCustomError);
            }
        }
    }

    public final void a(net.one97.paytm.upgradeKyc.aotp.a aVar) {
        k.c(aVar, "action");
        int i2 = a.f65438a[aVar.ordinal()];
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.video_kyc_cl);
            k.a((Object) constraintLayout, "video_kyc_cl");
            constraintLayout.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0240, code lost:
        if (kotlin.m.p.a(r2, "VideoKycRequest", true) == false) goto L_0x0242;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.InPersonVerification r6, com.paytm.network.model.IJRPaytmDataModel r7) {
        /*
            boolean r0 = r7 instanceof net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005e
            r6.l = r1
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = (net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal) r7
            r6.f65288d = r7
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = r6.f65288d
            if (r7 == 0) goto L_0x0013
            java.lang.String r7 = r7.status
            goto L_0x0014
        L_0x0013:
            r7 = r2
        L_0x0014:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x003f
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = r6.f65288d
            if (r7 == 0) goto L_0x0023
            java.lang.String r7 = r7.status
            goto L_0x0024
        L_0x0023:
            r7 = r2
        L_0x0024:
            java.lang.String r0 = "SUCCESS"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r1)
            if (r7 == 0) goto L_0x003f
            java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r7 = r6.o
            if (r7 == 0) goto L_0x005a
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r0 = r6.f65288d
            if (r0 != 0) goto L_0x0037
            kotlin.g.b.k.a()
        L_0x0037:
            java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r0 = r0.response
            java.util.Collection r0 = (java.util.Collection) r0
            r7.addAll(r0)
            goto L_0x005a
        L_0x003f:
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = r6.f65288d
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = r7.status
            goto L_0x0047
        L_0x0046:
            r7 = r2
        L_0x0047:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x005a
            net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = r6.f65288d
            if (r7 == 0) goto L_0x0055
            java.lang.String r2 = r7.status
        L_0x0055:
            java.lang.String r7 = "failure"
            kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r1)
        L_0x005a:
            r6.g()
            return
        L_0x005e:
            boolean r0 = r7 instanceof net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel
            if (r0 == 0) goto L_0x029f
            int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
            android.view.View r0 = r6.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            net.one97.paytm.common.widgets.a.b(r0)
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = (net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel) r7
            r6.f65289e = r7
            r6.f()
            r6.e()
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0080
            java.lang.String r7 = r7.getTab1()
            goto L_0x0081
        L_0x0080:
            r7 = r2
        L_0x0081:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r0 = "kyc_point"
            java.lang.String r3 = "door_step"
            if (r7 == 0) goto L_0x00c1
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0096
            java.lang.String r7 = r7.getTab2()
            goto L_0x0097
        L_0x0096:
            r7 = r2
        L_0x0097:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x00c1
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            goto L_0x0218
        L_0x00c1:
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x00ca
            java.lang.String r7 = r7.getTab1()
            goto L_0x00cb
        L_0x00ca:
            r7 = r2
        L_0x00cb:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0107
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x00dc
            java.lang.String r7 = r7.getTab2()
            goto L_0x00dd
        L_0x00dc:
            r7 = r2
        L_0x00dd:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0107
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            goto L_0x0218
        L_0x0107:
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0110
            java.lang.String r7 = r7.getTab1()
            goto L_0x0111
        L_0x0110:
            r7 = r2
        L_0x0111:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r4 = "request"
            if (r7 != 0) goto L_0x014d
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0124
            java.lang.String r7 = r7.getTab1()
            goto L_0x0125
        L_0x0124:
            r7 = r2
        L_0x0125:
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r1)
            if (r7 == 0) goto L_0x014d
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
            goto L_0x0218
        L_0x014d:
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0156
            java.lang.String r7 = r7.getTab2()
            goto L_0x0157
        L_0x0156:
            r7 = r2
        L_0x0157:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r5 = "dynamic"
            if (r7 != 0) goto L_0x0193
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x016a
            java.lang.String r7 = r7.getTab2()
            goto L_0x016b
        L_0x016a:
            r7 = r2
        L_0x016b:
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r5, (boolean) r1)
            if (r7 == 0) goto L_0x0193
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
            goto L_0x0218
        L_0x0193:
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x019c
            java.lang.String r7 = r7.getTab1()
            goto L_0x019d
        L_0x019c:
            r7 = r2
        L_0x019d:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01d6
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x01ae
            java.lang.String r7 = r7.getTab1()
            goto L_0x01af
        L_0x01ae:
            r7 = r2
        L_0x01af:
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r5, (boolean) r1)
            if (r7 == 0) goto L_0x01d6
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
            goto L_0x0218
        L_0x01d6:
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x01df
            java.lang.String r7 = r7.getTab2()
            goto L_0x01e0
        L_0x01df:
            r7 = r2
        L_0x01e0:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0218
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x01f1
            java.lang.String r7 = r7.getTab2()
            goto L_0x01f2
        L_0x01f1:
            r7 = r2
        L_0x01f2:
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r1)
            if (r7 == 0) goto L_0x0218
            int r7 = net.one97.paytm.upgradeKyc.R.id.door_step
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.kyc_point
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
        L_0x0218:
            boolean r7 = r6.f65287b
            java.lang.String r0 = "other_options_tv"
            java.lang.String r3 = "video_kyc_cl"
            if (r7 != 0) goto L_0x0242
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x0229
            java.lang.String r7 = r7.getTab3()
            goto L_0x022a
        L_0x0229:
            r7 = r2
        L_0x022a:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0242
            net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r7 = r6.f65289e
            if (r7 == 0) goto L_0x023a
            java.lang.String r2 = r7.getTab3()
        L_0x023a:
            java.lang.String r7 = "VideoKycRequest"
            boolean r7 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r1)
            if (r7 != 0) goto L_0x024c
        L_0x0242:
            boolean r7 = r6.f65287b
            if (r7 != 0) goto L_0x027f
            boolean r7 = net.one97.paytm.upgradeKyc.utils.l.b()
            if (r7 == 0) goto L_0x027f
        L_0x024c:
            int r7 = net.one97.paytm.upgradeKyc.R.id.video_kyc_cl
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.other_options_tv
            android.view.View r7 = r6.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.aotp_entry_lyt
            android.view.View r6 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            java.lang.String r7 = "aotp_entry_lyt"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.view.View r6 = (android.view.View) r6
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r6)
            return
        L_0x027f:
            int r7 = net.one97.paytm.upgradeKyc.R.id.video_kyc_cl
            android.view.View r7 = r6.a((int) r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
            int r7 = net.one97.paytm.upgradeKyc.R.id.other_options_tv
            android.view.View r6 = r6.a((int) r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            android.view.View r6 = (android.view.View) r6
            net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r6)
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.InPersonVerification.a(net.one97.paytm.upgradeKyc.activity.InPersonVerification, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public static final /* synthetic */ void a(InPersonVerification inPersonVerification, NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (p.a(networkCustomError.getFullUrl(), inPersonVerification.m, true)) {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) inPersonVerification.a(R.id.wallet_loader));
            inPersonVerification.g();
        } else if (p.a(networkCustomError.getFullUrl(), inPersonVerification.n, true)) {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) inPersonVerification.a(R.id.wallet_loader));
            inPersonVerification.f();
            inPersonVerification.e();
            ConstraintLayout constraintLayout = (ConstraintLayout) inPersonVerification.a(R.id.door_step);
            k.a((Object) constraintLayout, "door_step");
            net.one97.paytm.upgradeKyc.kycV3.b.b(constraintLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) inPersonVerification.a(R.id.kyc_point);
            k.a((Object) constraintLayout2, "kyc_point");
            net.one97.paytm.upgradeKyc.kycV3.b.b(constraintLayout2);
        }
    }
}
