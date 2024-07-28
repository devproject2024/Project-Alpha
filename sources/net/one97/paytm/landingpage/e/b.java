package net.one97.paytm.landingpage.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRContingency;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.entity.HomeICAStatusResponse;
import net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse;
import net.one97.paytm.landingpage.utils.d;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f52754a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52755b;

    /* renamed from: c  reason: collision with root package name */
    public AJRMainActivity f52756c;

    /* renamed from: d  reason: collision with root package name */
    CustProductList f52757d;

    /* renamed from: e  reason: collision with root package name */
    HomeICAStatusResponse f52758e;

    /* renamed from: f  reason: collision with root package name */
    ICACustProductResponse f52759f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52760g = false;

    /* renamed from: h  reason: collision with root package name */
    private d f52761h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52762i;
    private final int j = 1;
    private int k = 1;

    static /* synthetic */ int a(b bVar) {
        int i2 = bVar.k;
        bVar.k = i2 - 1;
        return i2;
    }

    public b(AJRMainActivity aJRMainActivity, d dVar) {
        this.f52756c = aJRMainActivity;
        this.f52754a = this.f52756c;
        this.f52755b = this.f52754a.getApplicationContext();
        this.f52761h = dVar;
    }

    public final void a() {
        String a2 = net.one97.paytm.common.b.d.b().a("leadAPIOnAppLaunch");
        if (URLUtil.isValidUrl(a2)) {
            String c2 = a.c(this.f52755b, a2);
            HashMap<String, String> a3 = a.a((HashMap<String, String>) new HashMap(), this.f52755b);
            String d2 = net.one97.paytm.common.b.d.b().d(this.f52755b);
            if (!TextUtils.isEmpty(d2)) {
                c2 = c2 + "&cart_id=" + d2;
            }
            net.one97.paytm.common.b.d.a(this.f52755b, c2, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (b.this.f52754a instanceof AJRMainActivity) {
                        ((AJRMainActivity) b.this.f52754a).a(iJRPaytmDataModel);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(networkCustomError.getStatusCode());
                    if (sb.toString().equalsIgnoreCase("503")) {
                        String string = b.this.f52755b.getResources().getString(R.string.contingency_503_message);
                        com.paytm.utility.b.b((Context) b.this.f52754a, b.this.f52755b.getResources().getString(R.string.contingency_503_title), string);
                    }
                }
            }, a3, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRContingency(), a.c.HOME, a.b.SILENT).a();
        }
    }

    public final void a(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra("bundle_to_load_banner_from_order_summary")) {
                    Bundle bundleExtra = intent.getBundleExtra("bundle_to_load_banner_from_order_summary");
                    if (bundleExtra != null) {
                        boolean z = bundleExtra.getBoolean("launched_from_catalog");
                        String string = bundleExtra.getString("origin");
                        this.f52756c.a(bundleExtra.getString("url_type"), (IJRDataModel) bundleExtra.getSerializable("load_page_datamodel"), bundleExtra.getString("parent_activity"), bundleExtra.getInt("extra_intent_item_position"), (ArrayList) bundleExtra.getSerializable("extra_intent_item_list"), z, string);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (intent != null && intent.hasExtra("intent_extra_start_login") && intent.getBooleanExtra("intent_extra_start_login", false)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
            bundle.putString("previous_screen_name", intent.getStringExtra("previous_screen_name"));
            bundle.putBoolean("is_forgot_password", intent.getBooleanExtra("is_forgot_password", false));
            d.a(bundle, this.f52754a);
        }
    }

    public final void b() {
        this.k = 1;
        net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
        net.one97.paytm.common.b.d.b().a();
        this.f52762i = b2.a("icaEnabled", false);
        if (this.f52762i) {
            this.k = 2;
            f();
        }
        e();
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", net.one97.paytm.common.b.d.a().b((Context) this.f52754a));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        String a2 = net.one97.paytm.common.b.d.b().a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT);
        final Context a3 = net.one97.paytm.common.b.d.b().a();
        Context context = this.f52755b;
        AnonymousClass4 r5 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                b.a(b.this);
                if (com.paytm.utility.a.p(a3)) {
                    b bVar = b.this;
                    bVar.f52757d = (CustProductList) iJRPaytmDataModel;
                    bVar.c();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                b.a(b.this);
                if (b.this.f52759f != null) {
                    b.this.c();
                } else if (b.this.f52754a instanceof AJRMainActivity) {
                    ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                }
            }
        };
        com.paytm.network.a a4 = net.one97.paytm.common.b.d.a(context, a2, r5, hashMap2, hashMap, a.C0715a.GET, (String) null, new CustProductList(), a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(this.f52755b)) {
            Context context2 = this.f52755b;
            ((AJRMainActivity) this.f52754a).b(context2, context2.getString(R.string.please_wait));
            a4.a();
        }
    }

    private void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", net.one97.paytm.common.b.d.a().b((Context) this.f52754a));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        String a2 = net.one97.paytm.common.b.d.b().a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT);
        net.one97.paytm.landingpage.utils.bankutil.a aVar = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
        String a3 = net.one97.paytm.landingpage.utils.bankutil.a.a(a2, true);
        final Context a4 = net.one97.paytm.common.b.d.b().a();
        Context context = this.f52755b;
        AnonymousClass5 r5 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                b.a(b.this);
                if (com.paytm.utility.a.p(a4)) {
                    b bVar = b.this;
                    bVar.f52759f = (ICACustProductResponse) iJRPaytmDataModel;
                    bVar.c();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                b.a(b.this);
                if (b.this.f52757d != null) {
                    b.this.c();
                } else if (b.this.f52754a instanceof AJRMainActivity) {
                    ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                }
            }
        };
        com.paytm.network.a a5 = net.one97.paytm.common.b.d.a(context, a3, r5, hashMap2, hashMap, a.C0715a.GET, (String) null, new ICACustProductResponse(), a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(this.f52755b)) {
            Context context2 = this.f52755b;
            ((AJRMainActivity) this.f52754a).b(context2, context2.getString(R.string.please_wait));
            a5.a();
        }
    }

    private void g() {
        Context a2 = net.one97.paytm.common.b.d.b().a();
        String a3 = net.one97.paytm.common.b.d.b().a("passcodeExistsURL");
        String str = "https://goldengate.paytmbank.com/MerchantService/v1/getLeadStatus";
        if (TextUtils.isEmpty(net.one97.paytm.common.b.d.b().a("getICALeadStatus")) && !TextUtils.isEmpty(a3) && a3.contains("origin-ite")) {
            str = "https://goldengate-staging.paytmbank.com/MerchantService/v1/getLeadStatus";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("applanguage", "en");
        hashMap.put("X-SRC", UpiConstants.B2C_ANDROID);
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        hashMap.put("session_token", com.paytm.utility.a.q(a2));
        hashMap.put("deviceIdentifier", com.paytm.utility.a.d(a2));
        HomeICAStatusResponse homeICAStatusResponse = new HomeICAStatusResponse();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        com.paytm.network.a a4 = net.one97.paytm.common.b.d.a(this.f52755b, str + "?entityType=INDIVIDUAL&solutionType=limited_ca", new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                b bVar = b.this;
                bVar.f52758e = (HomeICAStatusResponse) iJRPaytmDataModel;
                b.b(bVar);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (b.this.f52757d != null) {
                    b.b(b.this);
                } else if (b.this.f52754a instanceof AJRMainActivity) {
                    ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                }
            }
        }, hashMap, hashMap2, a.C0715a.GET, (String) null, homeICAStatusResponse, a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(this.f52755b)) {
            Context context = this.f52755b;
            ((AJRMainActivity) this.f52754a).b(context, context.getString(R.string.please_wait));
            a4.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0179, code lost:
        return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x0175=Splitter:B:109:0x0175, B:37:0x00b6=Splitter:B:37:0x00b6, B:41:0x00cc=Splitter:B:41:0x00cc, B:73:0x011e=Splitter:B:73:0x011e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c() {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r3.k     // Catch:{ all -> 0x017a }
            if (r0 <= 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            android.app.Activity r0 = r3.f52754a     // Catch:{ all -> 0x017a }
            boolean r0 = r0 instanceof net.one97.paytm.landingpage.activity.AJRMainActivity     // Catch:{ all -> 0x017a }
            if (r0 == 0) goto L_0x0014
            android.app.Activity r0 = r3.f52754a     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.activity.AJRMainActivity r0 = (net.one97.paytm.landingpage.activity.AJRMainActivity) r0     // Catch:{ all -> 0x017a }
            r0.h()     // Catch:{ all -> 0x017a }
        L_0x0014:
            r0 = 2
            r3.k = r0     // Catch:{ all -> 0x017a }
            net.one97.paytm.common.b.a r0 = net.one97.paytm.common.b.d.b()     // Catch:{ all -> 0x017a }
            android.content.Context r0 = r0.a()     // Catch:{ all -> 0x017a }
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0178
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0178
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0123
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "NOT_APPLIED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x00cc
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "LEAD"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0055
            goto L_0x00cc
        L_0x0055:
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "FAILED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x00b6
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "IN_PROGRESS"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x00b6
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "INITIATED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x00b6
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "PENDING"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x008e
            goto L_0x00b6
        L_0x008e:
            net.one97.paytm.common.entity.paymentsbank.CustProductList r1 = r3.f52757d     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIsaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "ISSUED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0178
            net.one97.paytm.landingpage.utils.bankutil.a r1 = net.one97.paytm.landingpage.utils.bankutil.a.f52901a     // Catch:{ all -> 0x017a }
            net.one97.paytm.utils.a r1 = net.one97.paytm.utils.a.ISSUED     // Catch:{ all -> 0x017a }
            int r1 = r1.getNumVal()     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.a.a((android.content.Context) r0, (int) r1)     // Catch:{ all -> 0x017a }
            android.app.Activity r0 = r3.f52754a     // Catch:{ all -> 0x017a }
            boolean r0 = r0 instanceof net.one97.paytm.landingpage.activity.AJRMainActivity     // Catch:{ all -> 0x017a }
            if (r0 == 0) goto L_0x0178
            android.app.Activity r0 = r3.f52754a     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.activity.AJRMainActivity r0 = (net.one97.paytm.landingpage.activity.AJRMainActivity) r0     // Catch:{ all -> 0x017a }
            r0.d()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x00b6:
            net.one97.paytm.landingpage.utils.bankutil.a r1 = net.one97.paytm.landingpage.utils.bankutil.a.f52901a     // Catch:{ all -> 0x017a }
            net.one97.paytm.utils.a r1 = net.one97.paytm.utils.a.PROCESSING     // Catch:{ all -> 0x017a }
            int r1 = r1.getNumVal()     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.a.a((android.content.Context) r0, (int) r1)     // Catch:{ all -> 0x017a }
            java.lang.String r1 = "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=6"
            net.one97.paytm.common.b.a r2 = net.one97.paytm.common.b.d.b()     // Catch:{ all -> 0x017a }
            r2.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x00cc:
            net.one97.paytm.landingpage.utils.bankutil.a r1 = net.one97.paytm.landingpage.utils.bankutil.a.f52901a     // Catch:{ all -> 0x017a }
            net.one97.paytm.utils.a r1 = net.one97.paytm.utils.a.NOT_APPLIED     // Catch:{ all -> 0x017a }
            int r1 = r1.getNumVal()     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.a.a((android.content.Context) r0, (int) r1)     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x011e
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x011e
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0119
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "ISSUED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x010b
            boolean r1 = r3.f52762i     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0106
            r3.a((android.content.Context) r0)     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0106:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x010b:
            boolean r0 = r3.f52762i     // Catch:{ all -> 0x017a }
            if (r0 == 0) goto L_0x0114
            r3.g()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0114:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0119:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x011e:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0123:
            net.one97.paytm.landingpage.utils.bankutil.a r1 = net.one97.paytm.landingpage.utils.bankutil.a.f52901a     // Catch:{ all -> 0x017a }
            net.one97.paytm.utils.a r1 = net.one97.paytm.utils.a.NOT_APPLIED     // Catch:{ all -> 0x017a }
            int r1 = r1.getNumVal()     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.a.a((android.content.Context) r0, (int) r1)     // Catch:{ all -> 0x017a }
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0175
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0175
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0170
            net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse r1 = r3.f52759f     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.getIcaStatus()     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "ISSUED"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0162
            boolean r1 = r3.f52762i     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x015d
            r3.a((android.content.Context) r0)     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x015d:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0162:
            boolean r0 = r3.f52762i     // Catch:{ all -> 0x017a }
            if (r0 == 0) goto L_0x016b
            r3.g()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x016b:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0170:
            h()     // Catch:{ all -> 0x017a }
            monitor-exit(r3)
            return
        L_0x0175:
            h()     // Catch:{ all -> 0x017a }
        L_0x0178:
            monitor-exit(r3)
            return
        L_0x017a:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.e.b.c():void");
    }

    private void a(Context context) {
        net.one97.paytm.landingpage.utils.bankutil.a aVar = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
        net.one97.paytm.landingpage.utils.bankutil.a.b(context);
        net.one97.paytm.landingpage.utils.bankutil.a aVar2 = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
        net.one97.paytm.landingpage.utils.bankutil.a.a(context, "ICA");
        Activity activity = this.f52754a;
        if (activity instanceof AJRMainActivity) {
            ((AJRMainActivity) activity).d();
        }
    }

    private static void h() {
        net.one97.paytm.common.b.d.b().a(net.one97.paytm.common.b.d.b().a(), "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=3");
    }

    public final void d() {
        String n = net.one97.paytm.common.b.d.a().n();
        if (!TextUtils.isEmpty(net.one97.paytm.common.b.d.a().b((Context) this.f52754a)) && URLUtil.isValidUrl(n)) {
            String e2 = com.paytm.utility.b.e(this.f52754a.getApplicationContext(), n);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", net.one97.paytm.common.b.d.a().b(this.f52754a.getApplicationContext()));
            KYCStatusV2 kYCStatusV2 = new KYCStatusV2();
            if (com.paytm.utility.a.m(this.f52754a.getApplicationContext())) {
                net.one97.paytm.common.b.d.a(this.f52755b, e2, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (b.this.f52754a instanceof AJRMainActivity) {
                            ((AJRMainActivity) b.this.f52754a).a(iJRPaytmDataModel);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (b.this.f52754a instanceof AJRMainActivity) {
                            ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                        }
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, kYCStatusV2, a.c.HOME, a.b.SILENT).a();
            }
        }
    }

    static /* synthetic */ void b(b bVar) {
        Activity activity = bVar.f52754a;
        if (activity instanceof AJRMainActivity) {
            ((AJRMainActivity) activity).h();
        }
        Context a2 = net.one97.paytm.common.b.d.b().a();
        HomeICAStatusResponse homeICAStatusResponse = bVar.f52758e;
        if (homeICAStatusResponse != null && !"NOT_APPLIED".equalsIgnoreCase(homeICAStatusResponse.getLeadStatus())) {
            if ("LEAD".equalsIgnoreCase(bVar.f52758e.getLeadStatus()) || "TRACK".equalsIgnoreCase(bVar.f52758e.getLeadStatus())) {
                if (bVar.f52762i) {
                    String leadStatus = bVar.f52758e.getLeadStatus();
                    Context a3 = net.one97.paytm.common.b.d.b().a();
                    Intent intent = new Intent();
                    intent.setAction("open_ica_acc_opening");
                    intent.putExtra("icastatus", leadStatus);
                    net.one97.paytm.common.b.d.a().a(a3, intent);
                    return;
                }
                h();
                return;
            } else if (!"NOT_ALLOWED".equalsIgnoreCase(bVar.f52758e.getLeadStatus())) {
                if (!"ACTIVE".equalsIgnoreCase(bVar.f52758e.getLeadStatus())) {
                    return;
                }
                if (bVar.f52762i) {
                    bVar.a(a2);
                    return;
                } else {
                    h();
                    return;
                }
            }
        }
        h();
    }
}
