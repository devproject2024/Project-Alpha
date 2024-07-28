package net.one97.paytm.appManager;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.t;
import kotlin.x;
import net.one97.paytm.appManager.b.b;
import net.one97.paytm.appManager.beans.Data;
import net.one97.paytm.appManager.beans.MetaInfo;
import net.one97.paytm.appManager.storage.db.AppManagerDb;
import net.one97.paytm.ups.constant.NetworkConstant;

public final class a extends net.one97.paytm.appManager.b.b {

    /* renamed from: b  reason: collision with root package name */
    public static final C0863a f49018b = new C0863a((byte) 0);
    /* access modifiers changed from: private */
    public static final g j = h.a(b.INSTANCE);
    /* access modifiers changed from: private */
    public static final g k = h.a(c.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final com.google.firebase.remoteconfig.a f49019a;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f49020g = "AppManager";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f49021h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final kotlin.g.a.a<x> f49022i;

    /* renamed from: net.one97.paytm.appManager.a$a  reason: collision with other inner class name */
    public static final class C0863a {
        static Map<String, Object> a() {
            g a2 = a.j;
            C0863a aVar = a.f49018b;
            return (Map) a2.getValue();
        }

        public static Map<String, Object> b() {
            g b2 = a.k;
            C0863a aVar = a.f49018b;
            return (Map) b2.getValue();
        }

        private C0863a() {
        }

        public /* synthetic */ C0863a(byte b2) {
            this();
        }
    }

    static final class b extends l implements kotlin.g.a.a<HashMap<String, Object>> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final HashMap<String, Object> invoke() {
            return ae.c(t.a(CLPConstants.KEY_HOME_URL, CLPConstants.HOME_BASE_URL), t.a("key_child_site_id", "1"), t.a("key_site_id", "1"), t.a("apiThrottleLimit", 100), t.a("leadAPIOnAppLaunch", "https://cart.paytm.com/v1/lead/launch"), t.a("flyoutCatalogUrl_v2", "https://storefront.paytm.com/v2/mobile/flyouts"), t.a("enable_branch_sdk", Boolean.FALSE), t.a("upi_enabled", Boolean.TRUE), t.a("notification_sdk_enabled", Boolean.TRUE), t.a("notification_sdk_mall_enabled", Boolean.FALSE), t.a("error_sdk_enabled", Boolean.TRUE), t.a("paytm_ga_enabled", Boolean.TRUE), t.a("paytm_ga_mall_enabled", Boolean.FALSE), t.a("paytm_location_enabled", Boolean.TRUE), t.a("paytm_call_logs_enabled", Boolean.FALSE));
        }
    }

    static final class c extends l implements kotlin.g.a.a<HashMap<String, Object>> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        public final HashMap<String, Object> invoke() {
            return ae.c(t.a("signalSdkUrl", "https://sig.paytm.com"), t.a("location_night_mode_start_hour", 22), t.a("location_night_mode_end_hour", 6), t.a("same_location_iteration_threshold", 3), t.a("location_scheduling_time_sec", 300), t.a("signal_batch_freq", Integer.valueOf(AppConstants.READ_TIME_OUT)), t.a("errorSdkUrl", "https://accounts-analyticsapp.paytm.com"), t.a("error_sdk_event_scheduling_time_sec", 300), t.a("show_error_analytics_logs", Boolean.FALSE), t.a("key_sync_threshold_time", 900000L), t.a("enableOauthCryptography", Boolean.TRUE), t.a("localisationDigitalproxyUrl", "https://digitalapiproxy.paytm.com/localisation/v1/getMessages?service=AndroidProd"), t.a("isGASDKEnabledAndroid", Boolean.TRUE), t.a("firebaseMinimumFetchIntervalInSeconds", 3600), t.a("should_scan_for_fraud_apps", Boolean.TRUE), t.a("safety_net_api_key_core", "AIzaSyBZiorINohoPIUj0dbUN-WhRPcRd9nAaIE"), t.a("sslPinningConfigV2", "[{\"domain\":\"*.paytm.com\",\"value\":\"sha256/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=\",\"isEnabled\":true},{\"domain\":\"*.paytmbank.com\",\"value\":\"sha256/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=\",\"isEnabled\":true}]"), t.a("pref_logging", Boolean.TRUE), t.a("is_promotion_enabled", Boolean.FALSE), t.a("oauthVerifyLockOnAppLaunch", Boolean.TRUE), t.a("sms_sdk_throttle_limit", 10368000), t.a("sms_body_regex", "otp|one time password|verification code"), t.a("is_sms_sdk_on", Boolean.TRUE), t.a("sms_ingest_url", "https://digitalapiproxy.paytm.com/sms/data/v1/ingest/"), t.a("ups_url", NetworkConstant.UPS_URL), t.a("sms_upload_frequency", 86400), t.a("sms_regex", "hdfc|sbi|citi|icic|axis|rbl|kotak|amex|hsbc|yes|pnb|fromsc|idbi|canbnk|paytm|fedbnk|scbank|idfcbk|airbnk"), t.a(CLPConstants.KEY_NEW_HOME_URL, CLPConstants.NEW_HOME_BASE_URL), t.a("home_banner_url", "https://storefront.paytm.com/v2/h/flyout"), t.a("allRemoteAppPackageList", "{  \"remote_apps\": [ { \"pckg_name\": \"com.anydesk.anydeskandroid\", \"Appname\": \"Anydesk\" },    {      \"pckg_name\": \"com.anydesk.adcontrol.intel1\",    \"Appname\": \"Anydesk\" },{ \"pckg_name\": \"com.anydesk.adcontrol.ugoos1\",\"Appname\": \"Anydesk\" },    { \"pckg_name\": \"com.anydesk.adcontrol.savortex1\", \"Appname\": \"Anydesk\"}, {   \"pckg_name\": \"com.teamviewer.teamviewer.market.mobile\",      \"Appname\": \"Team Viewer\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.market\",      \"Appname\": \"Quick Support\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.addon.aosp7\",      \"Appname\": \"Quick Support\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.addon.allview\",     \"Appname\": \"Quick Support\"    },    {   \"pckg_name\": \"com.teamviewer.meeting.market.mobile\",     \"Appname\": \"Team Viewer\"    },    {      \"pckg_name\": \"com.teamviewer.host.market\",      \"Appname\": \"Team Viewer\"    }  ]}"), t.a("whiteListedDeeplinkUrls", "[\"http://m.p-y.tm\",\"https://m.p-y.tm\",\"https://p-y.tm\",\"http://p-y.tm\",\"landing\",\"linkCard\",\"verification\",\"passbook\",\"tncDetail\",\"paytm.com/digitalgold\",\"https://gamepind.com\",\"https://spin.gamepind.com/iday\",\"https://www.paytmmoney.com\",\"paytmmp://paytm-postpaid?url=landing\",\"http://ptblive.gamepind.com\",\"http://trivialive.gamepind.com\",\"https://trivialive.gamepind.com\",\"https://ptb.gamepind.com\",\"paytmmp://\",\"https://bnc.lt\",\"http://pytm.my\",\"https://dg-static1.paytm.com\",\"addMoney\",\"paytmmp://paytm-postpaid?url=addMoney\",\"https://dg-static1.paytm.com/weex/creditScore.js\",\"mobilePrepaid\",\"mobileRecharge\",\"dthRecharge\",\"datacardRecharge\",\"landlineRecharge\",\"broadbandRecharge\",\"cableRecharge\",\"play.google\",\"homePageSplash\",\"lendermigration\",\"paytm.com/flight-ticket\",\"https://paytmstores.com\",\"https://beta.paytmstores.com\"]"), t.a("sms_sdk_consent_list", "[\"ocl.permission.creditcard.sms_read_consent\",\"ocl.permission.lending.sms_read_consent\"]"), t.a("networkThreadCount", 8), t.a("networkEnableOldThreadPool", Boolean.TRUE));
        }
    }

    public static final class d<TResult> implements com.google.android.gms.tasks.c<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49023a;

        public d(a aVar) {
            this.f49023a = aVar;
        }

        public final void a(Task<Boolean> task) {
            k.c(task, "task");
            if (task.b()) {
                Context a2 = this.f49023a.f49021h;
                a.C0708a aVar = com.paytm.b.a.a.f42641a;
                com.paytm.b.a.a a3 = a.C0708a.a(a2, a.c.APP_MANAGER);
                a3.a("should_scan_for_fraud_apps", this.f49023a.f49019a.b("should_scan_for_fraud_apps"), true);
                String a4 = this.f49023a.f49019a.a("sslPinningConfigV2");
                k.a((Object) a4, "mFirebaseRemoteConfig.ge…ing(\"sslPinningConfigV2\")");
                boolean z = false;
                if (a4.length() > 0) {
                    a3.a("sslPinningConfigV2", a4, true);
                }
                a3.a("isGASDKEnabledAndroid", this.f49023a.f49019a.b("isGASDKEnabledAndroid"), true);
                long c2 = this.f49023a.f49019a.c("firebaseMinimumFetchIntervalInSeconds");
                if (c2 > 0) {
                    a3.a("firebaseMinimumFetchIntervalInSeconds", c2, true);
                }
                String a5 = this.f49023a.f49019a.a("safety_net_api_key_core");
                k.a((Object) a5, "mFirebaseRemoteConfig.ge…safety_net_api_key_core\")");
                if (a5.length() > 0) {
                    a3.a("safety_net_api_key_core", a5, true);
                }
                a3.a("is_promotion_enabled", this.f49023a.f49019a.b("is_promotion_enabled"), true);
                a3.a("oauthVerifyLockOnAppLaunch", this.f49023a.f49019a.b("oauthVerifyLockOnAppLaunch"), true);
                a3.a("sms_sdk_throttle_limit", this.f49023a.f49019a.c("sms_sdk_throttle_limit"), true);
                String a6 = this.f49023a.f49019a.a("sms_body_regex");
                k.a((Object) a6, "mFirebaseRemoteConfig.getString(\"sms_body_regex\")");
                if (a6.length() > 0) {
                    a3.a("sms_body_regex", a6, true);
                }
                a3.a("is_sms_sdk_on", this.f49023a.f49019a.b("is_sms_sdk_on"), true);
                String a7 = this.f49023a.f49019a.a("sms_ingest_url");
                k.a((Object) a7, "mFirebaseRemoteConfig.getString(\"sms_ingest_url\")");
                if (a7.length() > 0) {
                    a3.a("sms_ingest_url", a7, true);
                }
                String a8 = this.f49023a.f49019a.a("ups_url");
                k.a((Object) a8, "mFirebaseRemoteConfig.getString(\"ups_url\")");
                if (a8.length() > 0) {
                    a3.a("ups_url", a8, true);
                }
                a3.a("sms_upload_frequency", this.f49023a.f49019a.c("sms_upload_frequency"), true);
                String a9 = this.f49023a.f49019a.a("sms_regex");
                k.a((Object) a9, "mFirebaseRemoteConfig.getString(\"sms_regex\")");
                if (a9.length() > 0) {
                    a3.a("sms_regex", a9, true);
                }
                String a10 = this.f49023a.f49019a.a(CLPConstants.KEY_NEW_HOME_URL);
                k.a((Object) a10, "mFirebaseRemoteConfig.ge…E_STORE_FRONT_V2_URL_KEY)");
                if (a10.length() > 0) {
                    a3.a(CLPConstants.KEY_NEW_HOME_URL, a10, true);
                }
                String a11 = this.f49023a.f49019a.a("home_banner_url");
                k.a((Object) a11, "mFirebaseRemoteConfig.ge…ring(HOME_BANNER_URL_KEY)");
                if (a11.length() > 0) {
                    a3.a("home_banner_url", a11, true);
                }
                String a12 = this.f49023a.f49019a.a("allRemoteAppPackageList");
                k.a((Object) a12, "mFirebaseRemoteConfig.ge…OTE_APP_PACKAGE_LIST_KEY)");
                if (a12.length() > 0) {
                    a3.a("allRemoteAppPackageList", a12, true);
                }
                String a13 = this.f49023a.f49019a.a("whiteListedDeeplinkUrls");
                k.a((Object) a13, "mFirebaseRemoteConfig.ge…TELIST_DEEPLINK_URLS_KEY)");
                if (a13.length() > 0) {
                    a3.a("whiteListedDeeplinkUrls", a13, true);
                }
                String a14 = this.f49023a.f49019a.a("sms_sdk_consent_list");
                k.a((Object) a14, "mFirebaseRemoteConfig.ge…g(\"sms_sdk_consent_list\")");
                if (a14.length() > 0) {
                    z = true;
                }
                if (z) {
                    a3.a("sms_sdk_consent_list", a14, true);
                }
                a3.a("networkThreadCount", (int) this.f49023a.f49019a.c("networkThreadCount"), true);
                a3.a("networkEnableOldThreadPool", this.f49023a.f49019a.b("networkEnableOldThreadPool"), true);
                this.f49023a.f49022i.invoke();
                return;
            }
            String unused = this.f49023a.f49020g;
            q.b("Firebase Remote Config ACTIVATION FAILED");
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49024a;

        public e(a aVar) {
            this.f49024a = aVar;
        }

        public final void run() {
            a aVar = this.f49024a;
            AppManagerDb a2 = AppManagerDb.a(aVar.f49038e);
            k.a((Object) a2, "AppManagerDb.getInstance(context)");
            aVar.f49037d = a2;
            AppManagerDb appManagerDb = aVar.f49037d;
            if (appManagerDb == null) {
                k.a("appDbManager");
            }
            net.one97.paytm.appManager.storage.db.a a3 = appManagerDb.a();
            k.a((Object) a3, "appDbManager.appManagerDao()");
            aVar.f49036c = a3;
            net.one97.paytm.appManager.b.a c2 = aVar.c();
            net.one97.paytm.appManager.storage.db.a aVar2 = aVar.f49036c;
            if (aVar2 == null) {
                k.a("appDao");
            }
            k.c(aVar2, "appManagerDao");
            c2.f49028d = aVar2;
            net.one97.paytm.appManager.storage.b.a aVar3 = net.one97.paytm.appManager.storage.b.a.f49053c;
            net.one97.paytm.appManager.storage.b.a.a(false);
            net.one97.paytm.appManager.d.c cVar = net.one97.paytm.appManager.d.c.f49045a;
            net.one97.paytm.appManager.d.c.a("release");
            net.one97.paytm.appManager.b.a c3 = this.f49024a.c();
            Context a4 = this.f49024a.f49021h;
            k.c(a4, "context");
            StringBuilder sb = new StringBuilder();
            sb.append(c3.f49026b);
            sb.append(" initiallyLoadDataIntoDB STARTED");
            Data a5 = net.one97.paytm.appManager.b.a.a(a4);
            b.a aVar4 = net.one97.paytm.appManager.b.b.f49032f;
            boolean z = true;
            b.a.a(true);
            net.one97.paytm.appManager.storage.b.a aVar5 = net.one97.paytm.appManager.storage.b.a.f49053c;
            long a6 = net.one97.paytm.appManager.storage.b.a.a(c3.f49027c);
            MetaInfo metaData = a5.getMetaData();
            net.one97.paytm.appManager.storage.db.c[] cVarArr = null;
            Long valueOf = metaData != null ? Long.valueOf(metaData.getVersion()) : null;
            net.one97.paytm.appManager.storage.db.a aVar6 = c3.f49028d;
            if ((aVar6 == null || aVar6.a() != 0) && a6 != -1 && valueOf != null && valueOf.longValue() <= a6) {
                z = false;
            }
            if (z) {
                net.one97.paytm.appManager.storage.db.a aVar7 = c3.f49028d;
                if (aVar7 != null) {
                    if (a5 != null) {
                        cVarArr = a5.getList();
                    }
                    if (cVarArr == null) {
                        k.a();
                    }
                    aVar7.c((net.one97.paytm.appManager.storage.db.c[]) Arrays.copyOf(cVarArr, cVarArr.length));
                }
                net.one97.paytm.appManager.storage.b.a aVar8 = net.one97.paytm.appManager.storage.b.a.f49053c;
                MetaInfo metaData2 = a5.getMetaData();
                if (metaData2 == null) {
                    k.a();
                }
                net.one97.paytm.appManager.storage.b.a.a(a4, metaData2.getVersion());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c3.f49026b);
            sb2.append(" initiallyLoadDataIntoDB END");
            b.a aVar9 = net.one97.paytm.appManager.b.b.f49032f;
            b.a.a(false);
            this.f49024a.f49019a.b();
        }
    }

    public final void a(Context context) {
        k.c(context, "applicationContext");
        net.one97.paytm.appManager.d.c cVar = net.one97.paytm.appManager.d.c.f49045a;
        net.one97.paytm.appManager.sync.a.f49082a.a(context, a("key_sync_threshold_time", Long.valueOf(net.one97.paytm.appManager.d.c.b())));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, com.google.firebase.remoteconfig.a aVar, kotlin.g.a.a<x> aVar2) {
        super(context, aVar, C0863a.a());
        k.c(context, "applicationContext");
        k.c(aVar, "mFirebaseRemoteConfig");
        k.c(aVar2, "firebaseConfigActivated");
        this.f49021h = context;
        this.f49019a = aVar;
        this.f49022i = aVar2;
        a.C0708a aVar3 = com.paytm.b.a.a.f42641a;
        com.paytm.b.a.a a2 = a.C0708a.a(this.f49021h, a.c.APP_MANAGER);
        C0863a.b().put("should_scan_for_fraud_apps", Boolean.valueOf(a2.b("should_scan_for_fraud_apps", true, false)));
        String b2 = a2.b("sslPinningConfigV2", "", true);
        CharSequence charSequence = b2;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            C0863a.b().put("sslPinningConfigV2", b2);
        }
        C0863a.b().put("isGASDKEnabledAndroid", Boolean.valueOf(a2.b("isGASDKEnabledAndroid", true, false)));
        C0863a.b().put("firebaseMinimumFetchIntervalInSeconds", Long.valueOf(a2.b("firebaseMinimumFetchIntervalInSeconds", 3600, false)));
        String b3 = a2.b("safety_net_api_key_core", "", true);
        CharSequence charSequence2 = b3;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            C0863a.b().put("safety_net_api_key_core", b3);
        }
        C0863a.b().put("is_promotion_enabled", Boolean.valueOf(a2.b("is_promotion_enabled", false, true)));
        C0863a.b().put("oauthVerifyLockOnAppLaunch", Boolean.valueOf(a2.b("oauthVerifyLockOnAppLaunch", true, true)));
        C0863a.b().put("sms_sdk_throttle_limit", Integer.valueOf(a2.b("sms_sdk_throttle_limit", 10368000, true)));
        String b4 = a2.b("sms_body_regex", "otp|one time password|verification code", true);
        CharSequence charSequence3 = b4;
        if (!(charSequence3 == null || charSequence3.length() == 0)) {
            C0863a.b().put("sms_body_regex", b4);
        }
        C0863a.b().put("is_sms_sdk_on", Boolean.valueOf(a2.b("is_sms_sdk_on", true, true)));
        String b5 = a2.b("sms_ingest_url", "https://digitalapiproxy.paytm.com/sms/data/v1/ingest/", true);
        CharSequence charSequence4 = b5;
        if (!(charSequence4 == null || charSequence4.length() == 0)) {
            C0863a.b().put("sms_ingest_url", b5);
        }
        String b6 = a2.b("ups_url", NetworkConstant.UPS_URL, true);
        CharSequence charSequence5 = b6;
        if (!(charSequence5 == null || charSequence5.length() == 0)) {
            C0863a.b().put("ups_url", b6);
        }
        C0863a.b().put("sms_upload_frequency", Integer.valueOf(a2.b("sms_upload_frequency", 86400, true)));
        String b7 = a2.b("sms_regex", "hdfc|sbi|citi|icic|axis|rbl|kotak|amex|hsbc|yes|pnb|fromsc|idbi|canbnk|paytm|fedbnk|scbank|idfcbk|airbnk", true);
        CharSequence charSequence6 = b7;
        if (!(charSequence6 == null || charSequence6.length() == 0)) {
            C0863a.b().put("sms_regex", b7);
        }
        String b8 = a2.b(CLPConstants.KEY_NEW_HOME_URL, CLPConstants.NEW_HOME_BASE_URL, true);
        CharSequence charSequence7 = b8;
        if (!(charSequence7 == null || charSequence7.length() == 0)) {
            C0863a.b().put(CLPConstants.KEY_NEW_HOME_URL, b8);
        }
        String b9 = a2.b("home_banner_url", "https://storefront.paytm.com/v2/h/flyout", true);
        CharSequence charSequence8 = b9;
        if (!(charSequence8 == null || charSequence8.length() == 0)) {
            C0863a.b().put("home_banner_url", b9);
        }
        String b10 = a2.b("allRemoteAppPackageList", "{  \"remote_apps\": [ { \"pckg_name\": \"com.anydesk.anydeskandroid\", \"Appname\": \"Anydesk\" },    {      \"pckg_name\": \"com.anydesk.adcontrol.intel1\",    \"Appname\": \"Anydesk\" },{ \"pckg_name\": \"com.anydesk.adcontrol.ugoos1\",\"Appname\": \"Anydesk\" },    { \"pckg_name\": \"com.anydesk.adcontrol.savortex1\", \"Appname\": \"Anydesk\"}, {   \"pckg_name\": \"com.teamviewer.teamviewer.market.mobile\",      \"Appname\": \"Team Viewer\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.market\",      \"Appname\": \"Quick Support\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.addon.aosp7\",      \"Appname\": \"Quick Support\"    },    {      \"pckg_name\": \"com.teamviewer.quicksupport.addon.allview\",     \"Appname\": \"Quick Support\"    },    {   \"pckg_name\": \"com.teamviewer.meeting.market.mobile\",     \"Appname\": \"Team Viewer\"    },    {      \"pckg_name\": \"com.teamviewer.host.market\",      \"Appname\": \"Team Viewer\"    }  ]}", true);
        CharSequence charSequence9 = b10;
        if (!(charSequence9 == null || charSequence9.length() == 0)) {
            C0863a.b().put("allRemoteAppPackageList", b10);
        }
        String b11 = a2.b("whiteListedDeeplinkUrls", "[\"http://m.p-y.tm\",\"https://m.p-y.tm\",\"https://p-y.tm\",\"http://p-y.tm\",\"landing\",\"linkCard\",\"verification\",\"passbook\",\"tncDetail\",\"paytm.com/digitalgold\",\"https://gamepind.com\",\"https://spin.gamepind.com/iday\",\"https://www.paytmmoney.com\",\"paytmmp://paytm-postpaid?url=landing\",\"http://ptblive.gamepind.com\",\"http://trivialive.gamepind.com\",\"https://trivialive.gamepind.com\",\"https://ptb.gamepind.com\",\"paytmmp://\",\"https://bnc.lt\",\"http://pytm.my\",\"https://dg-static1.paytm.com\",\"addMoney\",\"paytmmp://paytm-postpaid?url=addMoney\",\"https://dg-static1.paytm.com/weex/creditScore.js\",\"mobilePrepaid\",\"mobileRecharge\",\"dthRecharge\",\"datacardRecharge\",\"landlineRecharge\",\"broadbandRecharge\",\"cableRecharge\",\"play.google\",\"homePageSplash\",\"lendermigration\",\"paytm.com/flight-ticket\",\"https://paytmstores.com\",\"https://beta.paytmstores.com\"]", true);
        CharSequence charSequence10 = b11;
        if (!(charSequence10 == null || charSequence10.length() == 0)) {
            C0863a.b().put("whiteListedDeeplinkUrls", b11);
        }
        String b12 = a2.b("sms_sdk_consent_list", "[\"ocl.permission.creditcard.sms_read_consent\",\"ocl.permission.lending.sms_read_consent\"]", true);
        CharSequence charSequence11 = b12;
        if (!((charSequence11 == null || charSequence11.length() == 0) ? true : z)) {
            C0863a.b().put("sms_sdk_consent_list", b12);
        }
        C0863a.b().put("networkThreadCount", Integer.valueOf(a2.b("networkThreadCount", 8, true)));
        C0863a.b().put("networkEnableOldThreadPool", Boolean.valueOf(a2.b("networkEnableOldThreadPool", true, true)));
        C0863a.a().putAll(C0863a.b());
    }
}
