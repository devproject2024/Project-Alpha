package net.one97.paytm.wifi.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.k;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.common.entity.shopping.CJRServiceOptions;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.wifi.R;
import net.one97.paytm.wifi.a.a;
import net.one97.paytm.wifi.models.WifiActivePlan;
import net.one97.paytm.wifi.models.WifiConnection;
import net.one97.paytm.wifi.models.WifiDataPlansModel;
import net.one97.paytm.wifi.models.WifiTempLogin;
import net.one97.paytm.wifi.models.WifiTimeData;
import net.one97.paytm.wifi.ui.b.a;

public final class WifiDashboardActivity extends WifiBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21207a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private String f21208c;

    /* renamed from: d  reason: collision with root package name */
    private WifiActivePlan f21209d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f21210e = WifiDashboardActivity.class.getName();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f21211f;

    private View a(int i2) {
        if (this.f21211f == null) {
            this.f21211f = new HashMap();
        }
        View view = (View) this.f21211f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f21211f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int a() {
        return R.layout.activity_wifi_dashboard;
    }

    public final int b() {
        return R.layout.wifi_empty_toolbar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "application");
        a.C0409a.a(application, new net.one97.paytm.wifi.a.b((byte) 0));
        a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
        a.C0409a.a().a(true);
        a.C0409a aVar3 = net.one97.paytm.wifi.a.a.f21069c;
        net.one97.paytm.wifi.background.wifi.e eVar = a.C0409a.a().f21070a;
        if (!eVar.b()) {
            String string = getString(R.string.enabling_wifi);
            kotlin.g.b.k.a((Object) string, "getString(R.string.enabling_wifi)");
            net.one97.paytm.wifi.ui.b.b.a(this, string, 0);
            eVar.c();
            a.C0409a aVar4 = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.g();
        }
        ((RoboButton) a(R.id.btnExtendPlan)).setOnClickListener(new d(this));
        ((RoboTextView) a(R.id.btnConnectNewHotspot)).setOnClickListener(new e(this));
        ((RoboTextView) a(R.id.btnDisconnect)).setOnClickListener(new f(this));
        Intent intent = getIntent();
        kotlin.g.b.k.a((Object) intent, "intent");
        if (intent.getExtras() != null) {
            Intent intent2 = getIntent();
            kotlin.g.b.k.a((Object) intent2, "intent");
            Bundle extras = intent2.getExtras();
            String str = null;
            this.f21209d = extras != null ? (WifiActivePlan) extras.getParcelable("key_wifi_plan_status") : null;
            Intent intent3 = getIntent();
            kotlin.g.b.k.a((Object) intent3, "intent");
            Bundle extras2 = intent3.getExtras();
            if (extras2 != null) {
                str = extras2.getString("ssid");
            }
            this.f21208c = str;
        }
        a(false);
        a(true);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21226a;

        d(WifiDashboardActivity wifiDashboardActivity) {
            this.f21226a = wifiDashboardActivity;
        }

        public final void onClick(View view) {
            WifiDashboardActivity.a(this.f21226a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21227a;

        e(WifiDashboardActivity wifiDashboardActivity) {
            this.f21227a = wifiDashboardActivity;
        }

        public final void onClick(View view) {
            this.f21227a.finish();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21228a;

        f(WifiDashboardActivity wifiDashboardActivity) {
            this.f21228a = wifiDashboardActivity;
        }

        public final void onClick(View view) {
            a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.h();
            this.f21228a.finish();
        }
    }

    public final void onResume() {
        super.onResume();
        q.d("onResume Called");
        c();
    }

    private final void c() {
        q.d("setDashboard called");
        if (this.f21209d == null || this.f21208c == null) {
            q.d("ssid is null trying to get wifiConnection");
            a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
            WifiConnection value = a.C0409a.a().f21070a.e().getValue();
            if (value != null) {
                q.d("wifiConnection not null \n matching ssid obtain in our database");
                String ssid = value.getSSID();
                a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
                if (a.C0409a.a().f21070a.d(ssid)) {
                    q.d("ssid matched");
                    String bssid = value.getBSSID();
                    a.C0409a aVar3 = net.one97.paytm.wifi.a.a.f21069c;
                    String b2 = a.C0409a.a().f21070a.b(ssid);
                    if (b2 != null) {
                        a(b2, bssid, ssid, false);
                    } else {
                        return;
                    }
                } else {
                    q.d("ssid not matched");
                    String string = getString(R.string.could_not_connect_title);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                    String string2 = getString(R.string.not_connected_to_wifi_issue);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.not_connected_to_wifi_issue)");
                    String string3 = getString(R.string.connect_to_new_internet);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.connect_to_new_internet)");
                    String string4 = getString(R.string.dismiss);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                    a("no-wifi-connection", string, string2, string3, string4).a(new h(this));
                }
            } else {
                q.d("wifiConnection null showing error");
                String string5 = getString(R.string.could_not_connect_title);
                kotlin.g.b.k.a((Object) string5, "getString(R.string.could_not_connect_title)");
                String string6 = getString(R.string.not_connected_to_wifi_issue);
                kotlin.g.b.k.a((Object) string6, "getString(R.string.not_connected_to_wifi_issue)");
                String string7 = getString(R.string.connect_to_new_internet);
                kotlin.g.b.k.a((Object) string7, "getString(R.string.connect_to_new_internet)");
                String string8 = getString(R.string.dismiss);
                kotlin.g.b.k.a((Object) string8, "getString(R.string.dismiss)");
                a("no-wifi-connection", string5, string6, string7, string8).a(new i(this));
            }
            k();
            return;
        }
        q.d("ssid not null");
        d();
        k();
    }

    public static final class h implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21236a;

        h(WifiDashboardActivity wifiDashboardActivity) {
            this.f21236a = wifiDashboardActivity;
        }

        public final void a() {
            this.f21236a.finish();
        }

        public final void b() {
            this.f21236a.finish();
        }
    }

    public static final class i implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21237a;

        i(WifiDashboardActivity wifiDashboardActivity) {
            this.f21237a = wifiDashboardActivity;
        }

        public final void a() {
            this.f21237a.finish();
        }

        public final void b() {
            this.f21237a.finish();
        }
    }

    /* access modifiers changed from: private */
    public final net.one97.paytm.wifi.ui.b.a a(String str, String str2, String str3, String str4, String str5) {
        net.one97.paytm.wifi.ui.b.a aVar = new net.one97.paytm.wifi.ui.b.a(str2, str3, str4, str5);
        aVar.setCancelable(true);
        aVar.show(getSupportFragmentManager(), str);
        return aVar;
    }

    private final void d() {
        if (this.f21208c == null || this.f21209d == null) {
            q.d("error though ssid is not null showing pop-up");
            String string = getString(R.string.could_not_connect_title);
            kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
            String string2 = getString(R.string.not_connected_to_wifi_issue);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.not_connected_to_wifi_issue)");
            String string3 = getString(R.string.connect_to_new_internet);
            kotlin.g.b.k.a((Object) string3, "getString(R.string.connect_to_new_internet)");
            String string4 = getString(R.string.dismiss);
            kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
            a("no-wifi-connection", string, string2, string3, string4).a(new k(this));
            return;
        }
        q.d("updating UI");
        String str = this.f21208c;
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        net.one97.paytm.wifi.background.wifi.e eVar = a.C0409a.a().f21070a;
        if (str == null) {
            kotlin.g.b.k.a();
        }
        String c2 = eVar.c(str);
        if (c2 != null) {
            w.a().a(c2).a((ImageView) a(R.id.iv_wifi_vendor));
            LinearLayout linearLayout = (LinearLayout) a(R.id.rootContentLayout);
            kotlin.g.b.k.a((Object) linearLayout, "rootContentLayout");
            linearLayout.setVisibility(0);
            RoboTextView roboTextView = (RoboTextView) a(R.id.tvTitle);
            kotlin.g.b.k.a((Object) roboTextView, "tvTitle");
            roboTextView.setText(this.f21208c);
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.averageSpeedTv);
            kotlin.g.b.k.a((Object) roboTextView2, "averageSpeedTv");
            WifiActivePlan wifiActivePlan = this.f21209d;
            if (wifiActivePlan == null) {
                kotlin.g.b.k.a();
            }
            roboTextView2.setText(net.one97.paytm.wifi.ui.b.c.b(wifiActivePlan));
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.timingTv);
            kotlin.g.b.k.a((Object) roboTextView3, "timingTv");
            roboTextView3.setText(net.one97.paytm.wifi.ui.b.c.d(str));
            WifiActivePlan wifiActivePlan2 = this.f21209d;
            if (wifiActivePlan2 == null) {
                kotlin.g.b.k.a();
            }
            String a2 = net.one97.paytm.wifi.ui.b.c.a(wifiActivePlan2);
            if (a2.equals("Unlimited Data")) {
                RoboTextView roboTextView4 = (RoboTextView) a(R.id.remainingDataTv);
                kotlin.g.b.k.a((Object) roboTextView4, "remainingDataTv");
                roboTextView4.setVisibility(8);
                RoboTextView roboTextView5 = (RoboTextView) a(R.id.timeRemainingTv);
                kotlin.g.b.k.a((Object) roboTextView5, "timeRemainingTv");
                roboTextView5.setGravity(17);
                ProgressBar progressBar = (ProgressBar) a(R.id.progress_bar);
                kotlin.g.b.k.a((Object) progressBar, "progress_bar");
                progressBar.setVisibility(8);
            } else {
                RoboTextView roboTextView6 = (RoboTextView) a(R.id.remainingDataTv);
                kotlin.g.b.k.a((Object) roboTextView6, "remainingDataTv");
                roboTextView6.setVisibility(0);
                RoboTextView roboTextView7 = (RoboTextView) a(R.id.timeRemainingTv);
                kotlin.g.b.k.a((Object) roboTextView7, "timeRemainingTv");
                roboTextView7.setGravity(8388613);
                ProgressBar progressBar2 = (ProgressBar) a(R.id.progress_bar);
                kotlin.g.b.k.a((Object) progressBar2, "progress_bar");
                progressBar2.setVisibility(0);
            }
            RoboTextView roboTextView8 = (RoboTextView) a(R.id.totalDataTv);
            kotlin.g.b.k.a((Object) roboTextView8, "totalDataTv");
            roboTextView8.setText(a2);
            f();
            e();
        }
    }

    public static final class k implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21239a;

        k(WifiDashboardActivity wifiDashboardActivity) {
            this.f21239a = wifiDashboardActivity;
        }

        public final void a() {
            this.f21239a.finish();
        }

        public final void b() {
            this.f21239a.finish();
        }
    }

    private final void e() {
        WifiActivePlan wifiActivePlan = this.f21209d;
        if (wifiActivePlan == null) {
            kotlin.g.b.k.a();
        }
        WifiTimeData c2 = net.one97.paytm.wifi.ui.b.c.c(wifiActivePlan.getExpiryTime());
        String str = c2.getDay() > 1 ? "days" : "day";
        String str2 = c2.getHour() > 1 ? "hours" : "hour";
        String str3 = c2.getMinute() > 1 ? "minutes" : "minute";
        if (c2.getDay() > 0) {
            if (c2.getHour() > 0) {
                RoboTextView roboTextView = (RoboTextView) a(R.id.timeRemainingTv);
                kotlin.g.b.k.a((Object) roboTextView, "timeRemainingTv");
                roboTextView.setText("Expires in " + c2.getDay() + ' ' + str + ' ' + c2.getHour() + ' ' + str2);
                return;
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.timeRemainingTv);
            kotlin.g.b.k.a((Object) roboTextView2, "timeRemainingTv");
            roboTextView2.setText("Expires in " + c2.getDay() + ' ' + str);
        } else if (c2.getHour() > 0) {
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.timeRemainingTv);
            kotlin.g.b.k.a((Object) roboTextView3, "timeRemainingTv");
            roboTextView3.setText("Expires in " + c2.getHour() + ' ' + str2 + ' ' + c2.getMinute() + ' ' + str3);
        } else {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.timeRemainingTv);
            kotlin.g.b.k.a((Object) roboTextView4, "timeRemainingTv");
            roboTextView4.setText("Expires in " + c2.getMinute() + ' ' + str3);
        }
    }

    private final void f() {
        WifiActivePlan wifiActivePlan = this.f21209d;
        if (wifiActivePlan == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.wifi.ui.b.c.b(wifiActivePlan.getDataRemaining());
        RoboTextView roboTextView = (RoboTextView) a(R.id.remainingDataTv);
        kotlin.g.b.k.a((Object) roboTextView, "remainingDataTv");
        roboTextView.setText(b2 + " left");
        WifiActivePlan wifiActivePlan2 = this.f21209d;
        if (wifiActivePlan2 == null) {
            kotlin.g.b.k.a();
        }
        String data = wifiActivePlan2.getData();
        WifiActivePlan wifiActivePlan3 = this.f21209d;
        if (wifiActivePlan3 == null) {
            kotlin.g.b.k.a();
        }
        int a2 = net.one97.paytm.wifi.ui.b.c.a(data, wifiActivePlan3.getDataRemaining());
        ProgressBar progressBar = (ProgressBar) a(R.id.progress_bar);
        kotlin.g.b.k.a((Object) progressBar, "progress_bar");
        progressBar.setProgress(a2);
    }

    public static final class j implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21238a;

        public final void b() {
        }

        j(WifiDashboardActivity wifiDashboardActivity) {
            this.f21238a = wifiDashboardActivity;
        }

        public final void a() {
            this.f21238a.h();
        }
    }

    private final void g() {
        String string = getString(R.string.extend_plan);
        kotlin.g.b.k.a((Object) string, "getString(R.string.extend_plan)");
        String string2 = getString(R.string.extend_plan_text);
        kotlin.g.b.k.a((Object) string2, "getString(R.string.extend_plan_text)");
        String string3 = getString(R.string.wifi_extend_plan);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.wifi_extend_plan)");
        String string4 = getString(R.string.dismiss);
        kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
        a("extend-plan", string, string2, string3, string4).a(new j(this));
    }

    /* access modifiers changed from: private */
    public final void h() {
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        WifiConnection value = a.C0409a.a().f21070a.e().getValue();
        if (value != null) {
            String ssid = value.getSSID();
            String bssid = value.getBSSID();
            a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
            String b2 = a.C0409a.a().f21070a.b(ssid);
            if (b2 != null) {
                a(b2, bssid, ssid, true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, String str3, boolean z) {
        q.d("Doing verify connection call");
        b(z);
        String l2 = com.paytm.utility.b.l((Context) this);
        if (l2 == null) {
            l2 = "";
        }
        String str4 = l2;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        String str5 = str;
        new net.one97.paytm.wifi.b.a(applicationContext).a(str4, net.one97.paytm.wifi.background.wifi.g.a(), str3, str2, str5, new l(this, str5, str2, str3, z));
    }

    public static final class l implements net.one97.paytm.wifi.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21241b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21242c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21243d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f21244e;

        l(WifiDashboardActivity wifiDashboardActivity, String str, String str2, String str3, boolean z) {
            this.f21240a = wifiDashboardActivity;
            this.f21241b = str;
            this.f21242c = str2;
            this.f21243d = str3;
            this.f21244e = z;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            androidx.lifecycle.k lifecycle = this.f21240a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21240a.f21210e;
                q.d("On Success Called ValidateUserConnection");
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRRechargeCart)) {
                    String unused2 = this.f21240a.f21210e;
                    q.d("CJRRechargeCart response model empty - ValidateUserConnection");
                    WifiDashboardActivity wifiDashboardActivity = this.f21240a;
                    String string = wifiDashboardActivity.getString(R.string.could_not_connect_title);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                    String string2 = this.f21240a.getString(R.string.some_issue_in_connecting);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.some_issue_in_connecting)");
                    String string3 = this.f21240a.getString(R.string.retry);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                    String string4 = this.f21240a.getString(R.string.dismiss);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                    wifiDashboardActivity.a("verification-failure", string, string2, string3, string4).a(new b(this));
                    this.f21240a.a(this.f21244e);
                    return;
                }
                WifiDashboardActivity.a(this.f21240a, (CJRRechargeCart) iJRPaytmDataModel, this.f21243d, this.f21242c, this.f21241b, this.f21244e);
            }
        }

        public static final class b implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f21246a;

            public final void b() {
            }

            b(l lVar) {
                this.f21246a = lVar;
            }

            public final void a() {
                this.f21246a.f21240a.a(this.f21246a.f21241b, this.f21246a.f21242c, this.f21246a.f21243d, this.f21246a.f21244e);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            androidx.lifecycle.k lifecycle = this.f21240a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21240a.f21210e;
                q.d("On Error Called ValidateUserConnection");
                this.f21240a.a(this.f21244e);
                WifiDashboardActivity wifiDashboardActivity = this.f21240a;
                String string = wifiDashboardActivity.getString(R.string.could_not_connect_title);
                kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                String string2 = this.f21240a.getString(R.string.some_issue_in_connecting);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.some_issue_in_connecting)");
                String string3 = this.f21240a.getString(R.string.retry);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                String string4 = this.f21240a.getString(R.string.dismiss);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                wifiDashboardActivity.a("verification-failure", string, string2, string3, string4).a(new a(this));
            }
        }

        public static final class a implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f21245a;

            public final void b() {
            }

            a(l lVar) {
                this.f21245a = lVar;
            }

            public final void a() {
                this.f21245a.f21240a.a(this.f21245a.f21241b, this.f21245a.f21242c, this.f21245a.f21243d, this.f21245a.f21244e);
            }
        }
    }

    public static final class c implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21221a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21222b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21223c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21224d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f21225e;

        public final void b() {
        }

        c(WifiDashboardActivity wifiDashboardActivity, String str, String str2, String str3, boolean z) {
            this.f21221a = wifiDashboardActivity;
            this.f21222b = str;
            this.f21223c = str2;
            this.f21224d = str3;
            this.f21225e = z;
        }

        public final void a() {
            this.f21221a.a(this.f21222b, this.f21223c, this.f21224d, this.f21225e);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, String str3, boolean z, WifiActivePlan wifiActivePlan, CJRRechargeCart cJRRechargeCart) {
        q.d("fetching user data plans");
        b(z);
        String l2 = com.paytm.utility.b.l((Context) this);
        if (l2 == null) {
            l2 = "";
        }
        String str4 = l2;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        net.one97.paytm.wifi.b.a aVar = new net.one97.paytm.wifi.b.a(applicationContext);
        aVar.b(str4, net.one97.paytm.wifi.background.wifi.g.a(), str, str3, str2, new b(this, z, str2, str3, str, wifiActivePlan, cJRRechargeCart));
    }

    public static final class b implements net.one97.paytm.wifi.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f21213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21214c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21215d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f21216e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ WifiActivePlan f21217f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CJRRechargeCart f21218g;

        b(WifiDashboardActivity wifiDashboardActivity, boolean z, String str, String str2, String str3, WifiActivePlan wifiActivePlan, CJRRechargeCart cJRRechargeCart) {
            this.f21212a = wifiDashboardActivity;
            this.f21213b = z;
            this.f21214c = str;
            this.f21215d = str2;
            this.f21216e = str3;
            this.f21217f = wifiActivePlan;
            this.f21218g = cJRRechargeCart;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            androidx.lifecycle.k lifecycle = this.f21212a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21212a.f21210e;
                q.d("On Error called FetchUserPlanResponse");
                this.f21212a.a(this.f21213b);
                WifiDashboardActivity wifiDashboardActivity = this.f21212a;
                String string = wifiDashboardActivity.getString(R.string.could_not_connect_title);
                kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                String string2 = this.f21212a.getString(R.string.fetch_data_plans_error);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.fetch_data_plans_error)");
                String string3 = this.f21212a.getString(R.string.retry);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                String string4 = this.f21212a.getString(R.string.dismiss);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                wifiDashboardActivity.a("fetch-plan-failure", string, string2, string3, string4).a(new a(this));
            }
        }

        public static final class a implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f21219a;

            public final void b() {
            }

            a(b bVar) {
                this.f21219a = bVar;
            }

            public final void a() {
                this.f21219a.f21212a.a(this.f21219a.f21214c, this.f21219a.f21215d, this.f21219a.f21216e, this.f21219a.f21213b, this.f21219a.f21217f, this.f21219a.f21218g);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            androidx.lifecycle.k lifecycle = this.f21212a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21212a.f21210e;
                q.d("On Success called FetchUserPlanResponse");
                this.f21212a.a(this.f21213b);
                if (iJRPaytmDataModel == null) {
                    String unused2 = this.f21212a.f21210e;
                    q.d("On Success called FetchUserPlanResponse \n WifiDataPlansModel is null");
                    WifiDashboardActivity wifiDashboardActivity = this.f21212a;
                    String string = wifiDashboardActivity.getString(R.string.could_not_connect_title);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                    String string2 = this.f21212a.getString(R.string.fetch_data_plans_error);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.fetch_data_plans_error)");
                    String string3 = this.f21212a.getString(R.string.retry);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                    String string4 = this.f21212a.getString(R.string.dismiss);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                    wifiDashboardActivity.a("fetch-plan-failure", string, string2, string3, string4).a(new C0416b(this));
                    return;
                }
                WifiDashboardActivity.a(this.f21212a, (WifiDataPlansModel) iJRPaytmDataModel, this.f21216e, this.f21215d, this.f21214c, this.f21213b, this.f21217f, this.f21218g);
            }
        }

        /* renamed from: net.one97.paytm.wifi.ui.WifiDashboardActivity$b$b  reason: collision with other inner class name */
        public static final class C0416b implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f21220a;

            public final void b() {
            }

            C0416b(b bVar) {
                this.f21220a = bVar;
            }

            public final void a() {
                this.f21220a.f21212a.a(this.f21220a.f21214c, this.f21220a.f21215d, this.f21220a.f21216e, this.f21220a.f21213b, this.f21220a.f21217f, this.f21220a.f21218g);
            }
        }
    }

    public static final class g implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiDashboardActivity f21229a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21230b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21231c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21232d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f21233e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ WifiActivePlan f21234f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CJRRechargeCart f21235g;

        public final void b() {
        }

        g(WifiDashboardActivity wifiDashboardActivity, String str, String str2, String str3, boolean z, WifiActivePlan wifiActivePlan, CJRRechargeCart cJRRechargeCart) {
            this.f21229a = wifiDashboardActivity;
            this.f21230b = str;
            this.f21231c = str2;
            this.f21232d = str3;
            this.f21233e = z;
            this.f21234f = wifiActivePlan;
            this.f21235g = cJRRechargeCart;
        }

        public final void a() {
            this.f21229a.a(this.f21230b, this.f21231c, this.f21232d, this.f21233e, this.f21234f, this.f21235g);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (!z) {
            i();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.progressRootLayout);
        kotlin.g.b.k.a((Object) frameLayout, "progressRootLayout");
        net.one97.paytm.wifi.ui.b.b.b(frameLayout);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loaderView));
    }

    private final void b(boolean z) {
        if (!z) {
            j();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.progressRootLayout);
        kotlin.g.b.k.a((Object) frameLayout, "progressRootLayout");
        net.one97.paytm.wifi.ui.b.b.a(frameLayout);
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loaderView));
    }

    private final void i() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.mainProgressLayout);
        kotlin.g.b.k.a((Object) frameLayout, "mainProgressLayout");
        net.one97.paytm.wifi.ui.b.b.b(frameLayout);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.mainLoaderView));
    }

    private final void j() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.mainProgressLayout);
        kotlin.g.b.k.a((Object) frameLayout, "mainProgressLayout");
        net.one97.paytm.wifi.ui.b.b.a(frameLayout);
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.mainLoaderView));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void k() {
        WifiActivePlan wifiActivePlan = this.f21209d;
        if (wifiActivePlan != null) {
            if (wifiActivePlan == null) {
                kotlin.g.b.k.a();
            }
            if (!TextUtils.isEmpty(wifiActivePlan.getBtnlabel())) {
                WifiActivePlan wifiActivePlan2 = this.f21209d;
                if (wifiActivePlan2 == null) {
                    kotlin.g.b.k.a();
                }
                CharSequence btnlabel = wifiActivePlan2.getBtnlabel();
                if (!(btnlabel == null || p.a(btnlabel))) {
                    RoboButton roboButton = (RoboButton) a(R.id.btnExtendPlan);
                    kotlin.g.b.k.a((Object) roboButton, "btnExtendPlan");
                    roboButton.setText(btnlabel);
                }
            }
        }
    }

    public static final /* synthetic */ void a(WifiDashboardActivity wifiDashboardActivity) {
        WifiActivePlan wifiActivePlan = wifiDashboardActivity.f21209d;
        if (wifiActivePlan == null) {
            wifiDashboardActivity.g();
            return;
        }
        if (wifiActivePlan == null) {
            kotlin.g.b.k.a();
        }
        String isbtmsheetshow = wifiActivePlan.getIsbtmsheetshow();
        CharSequence charSequence = isbtmsheetshow;
        if ((charSequence == null || p.a(charSequence)) || !"true".equals(isbtmsheetshow)) {
            wifiDashboardActivity.h();
        } else {
            wifiDashboardActivity.g();
        }
    }

    public static final /* synthetic */ void a(WifiDashboardActivity wifiDashboardActivity, CJRRechargeCart cJRRechargeCart, String str, String str2, String str3, boolean z) {
        CJRCart cart = cJRRechargeCart.getCart();
        if (TextUtils.isEmpty(cart != null ? cart.getError() : null)) {
            CJRCart cart2 = cJRRechargeCart.getCart();
            kotlin.g.b.k.a((Object) cart2, "model.cart");
            if (cart2.getCartItems() != null) {
                CJRCart cart3 = cJRRechargeCart.getCart();
                kotlin.g.b.k.a((Object) cart3, "model.cart");
                if (cart3.getCartItems().size() != 0) {
                    CJRCart cart4 = cJRRechargeCart.getCart();
                    kotlin.g.b.k.a((Object) cart4, "model.cart");
                    boolean z2 = false;
                    if (cart4.getCartItems().get(0) != null) {
                        CJRCart cart5 = cJRRechargeCart.getCart();
                        kotlin.g.b.k.a((Object) cart5, "model.cart");
                        CJRCartProduct cJRCartProduct = cart5.getCartItems().get(0);
                        kotlin.g.b.k.a((Object) cJRCartProduct, "model.cart.cartItems[0]");
                        if (cJRCartProduct.getServiceOptions() != null) {
                            CJRCart cart6 = cJRRechargeCart.getCart();
                            kotlin.g.b.k.a((Object) cart6, "model.cart");
                            CJRCartProduct cJRCartProduct2 = cart6.getCartItems().get(0);
                            kotlin.g.b.k.a((Object) cJRCartProduct2, "model.cart.cartItems[0]");
                            CJRServiceOptions serviceOptions = cJRCartProduct2.getServiceOptions();
                            kotlin.g.b.k.a((Object) serviceOptions, "model.cart.cartItems[0].serviceOptions");
                            if (serviceOptions.getActions() != null) {
                                CJRCart cart7 = cJRRechargeCart.getCart();
                                kotlin.g.b.k.a((Object) cart7, "model.cart");
                                CJRCartProduct cJRCartProduct3 = cart7.getCartItems().get(0);
                                kotlin.g.b.k.a((Object) cJRCartProduct3, "model.cart.cartItems[0]");
                                CJRServiceOptions serviceOptions2 = cJRCartProduct3.getServiceOptions();
                                kotlin.g.b.k.a((Object) serviceOptions2, "model.cart.cartItems[0].serviceOptions");
                                if (serviceOptions2.getActions().size() != 0) {
                                    CJRCart cart8 = cJRRechargeCart.getCart();
                                    kotlin.g.b.k.a((Object) cart8, "model.cart");
                                    CJRCartProduct cJRCartProduct4 = cart8.getCartItems().get(0);
                                    kotlin.g.b.k.a((Object) cJRCartProduct4, "model.cart.cartItems[0]");
                                    CJRServiceOptions serviceOptions3 = cJRCartProduct4.getServiceOptions();
                                    kotlin.g.b.k.a((Object) serviceOptions3, "model.cart.cartItems[0].serviceOptions");
                                    if (serviceOptions3.getActions().get(0) != null) {
                                        CJRCart cart9 = cJRRechargeCart.getCart();
                                        kotlin.g.b.k.a((Object) cart9, "model.cart");
                                        CJRCartProduct cJRCartProduct5 = cart9.getCartItems().get(0);
                                        kotlin.g.b.k.a((Object) cJRCartProduct5, "model.cart.cartItems[0]");
                                        CJRServiceOptions serviceOptions4 = cJRCartProduct5.getServiceOptions();
                                        kotlin.g.b.k.a((Object) serviceOptions4, "model.cart.cartItems[0].serviceOptions");
                                        CJRServiceActions cJRServiceActions = serviceOptions4.getActions().get(0);
                                        kotlin.g.b.k.a((Object) cJRServiceActions, "model.cart.cartItems[0].serviceOptions.actions[0]");
                                        if (cJRServiceActions.getDisplayValues() != null) {
                                            CJRCart cart10 = cJRRechargeCart.getCart();
                                            kotlin.g.b.k.a((Object) cart10, "model.cart");
                                            CJRCartProduct cJRCartProduct6 = cart10.getCartItems().get(0);
                                            kotlin.g.b.k.a((Object) cJRCartProduct6, "model.cart.cartItems[0]");
                                            CJRServiceOptions serviceOptions5 = cJRCartProduct6.getServiceOptions();
                                            kotlin.g.b.k.a((Object) serviceOptions5, "model.cart.cartItems[0].serviceOptions");
                                            CJRServiceActions cJRServiceActions2 = serviceOptions5.getActions().get(0);
                                            kotlin.g.b.k.a((Object) cJRServiceActions2, "model.cart.cartItems[0].serviceOptions.actions[0]");
                                            if (cJRServiceActions2.getDisplayValues().size() != 0) {
                                                CJRCart cart11 = cJRRechargeCart.getCart();
                                                kotlin.g.b.k.a((Object) cart11, "model.cart");
                                                CJRCartProduct cJRCartProduct7 = cart11.getCartItems().get(0);
                                                kotlin.g.b.k.a((Object) cJRCartProduct7, "model.cart.cartItems[0]");
                                                CJRServiceOptions serviceOptions6 = cJRCartProduct7.getServiceOptions();
                                                kotlin.g.b.k.a((Object) serviceOptions6, "model.cart.cartItems[0].serviceOptions");
                                                CJRServiceActions cJRServiceActions3 = serviceOptions6.getActions().get(0);
                                                kotlin.g.b.k.a((Object) cJRServiceActions3, "model.cart.cartItems[0].serviceOptions.actions[0]");
                                                ArrayList<CJRDisplayValues> displayValues = cJRServiceActions3.getDisplayValues();
                                                WifiTempLogin wifiTempLogin = new WifiTempLogin();
                                                WifiActivePlan wifiActivePlan = new WifiActivePlan();
                                                Iterator<CJRDisplayValues> it2 = displayValues.iterator();
                                                while (it2.hasNext()) {
                                                    CJRDisplayValues next = it2.next();
                                                    kotlin.g.b.k.a((Object) next, "displayVal");
                                                    String label = next.getLabel();
                                                    if (label != null) {
                                                        switch (label.hashCode()) {
                                                            case -2090584503:
                                                                if (!label.equals("ga_error_code")) {
                                                                    break;
                                                                } else {
                                                                    String value = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value, "displayVal.value");
                                                                    wifiTempLogin.setmGaErorCode(value);
                                                                    break;
                                                                }
                                                            case -1992012396:
                                                                if (!label.equals(AppConstants.DURATION)) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setDuration(next.getValue());
                                                                    break;
                                                                }
                                                            case -1800019579:
                                                                if (!label.equals("c_timeout")) {
                                                                    break;
                                                                } else {
                                                                    String value2 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value2, "displayVal.value");
                                                                    wifiTempLogin.setmCTimeout(value2);
                                                                    break;
                                                                }
                                                            case -1782937845:
                                                                if (!label.equals("isbtmsheetshow")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setIsbtmsheetshow(next.getValue());
                                                                    break;
                                                                }
                                                            case -985764316:
                                                                if (!label.equals(PayUtility.PLAN_ID)) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setPlanId(next.getValue());
                                                                    break;
                                                                }
                                                            case -935469716:
                                                                if (!label.equals("dataRemaining")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setDataRemaining(next.getValue());
                                                                    break;
                                                                }
                                                            case -816254304:
                                                                if (!label.equals("expiryTime")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setExpiryTime(next.getValue());
                                                                    break;
                                                                }
                                                            case -815066058:
                                                                if (!label.equals("ga_orig_url")) {
                                                                    break;
                                                                } else {
                                                                    String value3 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value3, "displayVal.value");
                                                                    wifiTempLogin.setmGaOrigUrl(value3);
                                                                    break;
                                                                }
                                                            case -243145087:
                                                                if (!label.equals("uploadRate")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setUploadRate(next.getValue());
                                                                    break;
                                                                }
                                                            case -208582063:
                                                                if (!label.equals("ga_cmac")) {
                                                                    break;
                                                                } else {
                                                                    String value4 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value4, "displayVal.value");
                                                                    wifiTempLogin.setmGaCmac(value4);
                                                                    break;
                                                                }
                                                            case -208205738:
                                                                if (!label.equals("ga_pass")) {
                                                                    break;
                                                                } else {
                                                                    wifiTempLogin.setGaPass(next.getValue());
                                                                    break;
                                                                }
                                                            case -208099936:
                                                                if (!label.equals("ga_srvr")) {
                                                                    break;
                                                                } else {
                                                                    String value5 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value5, "displayVal.value");
                                                                    wifiTempLogin.setmGaSrvr(value5);
                                                                    break;
                                                                }
                                                            case -208039920:
                                                                if (!label.equals("ga_user")) {
                                                                    break;
                                                                } else {
                                                                    wifiTempLogin.setGaUser(next.getValue());
                                                                    break;
                                                                }
                                                            case -79853543:
                                                                if (!label.equals("isActivePlan")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setActivePlan(next.getValue());
                                                                    break;
                                                                }
                                                            case 3076010:
                                                                if (!label.equals("data")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setData(next.getValue());
                                                                    break;
                                                                }
                                                            case 3575610:
                                                                if (!label.equals("type")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setType(next.getValue());
                                                                    break;
                                                                }
                                                            case 98106314:
                                                                if (!label.equals("ga_Qv")) {
                                                                    break;
                                                                } else {
                                                                    String value6 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value6, "displayVal.value");
                                                                    wifiTempLogin.setmGaQv(value6);
                                                                    break;
                                                                }
                                                            case 106934601:
                                                                if (!label.equals("price")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setPrice(next.getValue());
                                                                    break;
                                                                }
                                                            case 1109001608:
                                                                if (!label.equals("downloadRate")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setDownloadRate(next.getValue());
                                                                    break;
                                                                }
                                                            case 1361565764:
                                                                if (!label.equals("ga_ap_mac")) {
                                                                    break;
                                                                } else {
                                                                    String value7 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value7, "displayVal.value");
                                                                    wifiTempLogin.setmGaApMac(value7);
                                                                    break;
                                                                }
                                                            case 1720474527:
                                                                if (!label.equals("ga_nas_id")) {
                                                                    break;
                                                                } else {
                                                                    String value8 = next.getValue();
                                                                    kotlin.g.b.k.a((Object) value8, "displayVal.value");
                                                                    wifiTempLogin.setmGaNasId(value8);
                                                                    break;
                                                                }
                                                            case 1789094535:
                                                                if (!label.equals("dataUsed")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setDataUsed(next.getValue());
                                                                    break;
                                                                }
                                                            case 1868414292:
                                                                if (!label.equals("planName")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setPlanName(next.getValue());
                                                                    break;
                                                                }
                                                            case 2119866904:
                                                                if (!label.equals("btnlabel")) {
                                                                    break;
                                                                } else {
                                                                    wifiActivePlan.setBtnlabel(next.getValue());
                                                                    break;
                                                                }
                                                        }
                                                    }
                                                }
                                                CharSequence gaUser = wifiTempLogin.getGaUser();
                                                if (gaUser == null || gaUser.length() == 0) {
                                                    z2 = true;
                                                }
                                                if (z2) {
                                                    q.d("GA_USER null handleValidationResponse");
                                                    if (wifiActivePlan.isActivePlan() == null || kotlin.g.b.k.a((Object) "false", (Object) wifiActivePlan.isActivePlan())) {
                                                        q.d("IS_ACTIVE == null/false -  handleValidationResponse \n moving to data-plan fetch");
                                                        wifiDashboardActivity.a(str, str3, str2, true, wifiActivePlan, cJRRechargeCart);
                                                        return;
                                                    }
                                                    q.d("IS_ACTIVE not null/false -  handleValidationResponse \n moving to data-plan fetch");
                                                    wifiDashboardActivity.a(str, str3, str2, z, wifiActivePlan, cJRRechargeCart);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        q.d("response incorrect CJRRechargeCart Model");
        String string = wifiDashboardActivity.getString(R.string.could_not_connect_title);
        kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
        String string2 = wifiDashboardActivity.getString(R.string.some_issue_in_connecting);
        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_issue_in_connecting)");
        String string3 = wifiDashboardActivity.getString(R.string.retry);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
        String string4 = wifiDashboardActivity.getString(R.string.dismiss);
        kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
        wifiDashboardActivity.a("verification-failure", string, string2, string3, string4).a(new c(wifiDashboardActivity, str3, str2, str, z));
        wifiDashboardActivity.a(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: net.one97.paytm.wifi.models.WifiPlanArray} */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v35 */
    /* JADX WARNING: type inference failed for: r0v36 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.wifi.ui.WifiDashboardActivity r12, net.one97.paytm.wifi.models.WifiDataPlansModel r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, net.one97.paytm.wifi.models.WifiActivePlan r18, net.one97.paytm.common.entity.CJRRechargeCart r19) {
        /*
            r6 = r12
            r7 = r14
            r8 = r17
            java.lang.String r0 = "onLoadDataPlanComplete handle response"
            com.paytm.utility.q.d(r0)
            r12.a((boolean) r8)
            boolean r0 = r13.getPlanFetchSuccessful()
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r13.getUserplansGwResponse()
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r13.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0021
            kotlin.g.b.k.a()
        L_0x0021:
            boolean r0 = r0.getDeducedStatus()
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r13.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0030
            kotlin.g.b.k.a()
        L_0x0030:
            java.util.List r0 = r0.getPlansArray()
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r13.getUserplansGwResponse()
            if (r0 != 0) goto L_0x003f
            kotlin.g.b.k.a()
        L_0x003f:
            java.util.List r0 = r0.getPlansArray()
            if (r0 != 0) goto L_0x0048
            kotlin.g.b.k.a()
        L_0x0048:
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00d9
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r13.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0057
            kotlin.g.b.k.a()
        L_0x0057:
            java.util.List r0 = r0.getPlansArray()
            if (r0 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.wifi.models.WifiPlanArray r0 = (net.one97.paytm.wifi.models.WifiPlanArray) r0
            java.util.ArrayList r0 = r0.getData()
            if (r0 != 0) goto L_0x006e
            goto L_0x00d9
        L_0x006e:
            r0 = 0
            if (r8 != 0) goto L_0x0098
            net.one97.paytm.wifi.models.WifiUserPlanResponse r2 = r13.getUserplansGwResponse()
            if (r2 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.util.List r2 = r2.getPlansArray()
            if (r2 == 0) goto L_0x0086
            java.lang.Object r0 = r2.get(r1)
            net.one97.paytm.wifi.models.WifiPlanArray r0 = (net.one97.paytm.wifi.models.WifiPlanArray) r0
        L_0x0086:
            if (r0 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            r0.getData()
            r9 = r18
            r6.f21209d = r9
            r6.f21208c = r7
            r12.c()
            return
        L_0x0098:
            java.lang.String r2 = "moving to data-plan activity"
            com.paytm.utility.q.d(r2)
            android.content.Intent r2 = new android.content.Intent
            r3 = r6
            android.content.Context r3 = (android.content.Context) r3
            java.lang.Class<net.one97.paytm.wifi.ui.WifiDataPlansActivity> r4 = net.one97.paytm.wifi.ui.WifiDataPlansActivity.class
            r2.<init>(r3, r4)
            net.one97.paytm.wifi.models.WifiUserPlanResponse r3 = r13.getUserplansGwResponse()
            if (r3 != 0) goto L_0x00b0
            kotlin.g.b.k.a()
        L_0x00b0:
            java.util.List r3 = r3.getPlansArray()
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r1 = r3.get(r1)
            net.one97.paytm.wifi.models.WifiPlanArray r1 = (net.one97.paytm.wifi.models.WifiPlanArray) r1
            if (r1 == 0) goto L_0x00c2
            java.util.ArrayList r0 = r1.getData()
        L_0x00c2:
            java.lang.String r1 = "key_wifi_plans"
            r2.putParcelableArrayListExtra(r1, r0)
            java.lang.String r0 = "key_wifi_ssid"
            r2.putExtra(r0, r14)
            r0 = r19
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r1 = "key_cart_item"
            r2.putExtra(r1, r0)
            r12.startActivity(r2)
            return
        L_0x00d9:
            r9 = r18
            java.lang.String r0 = "response incorrect WifiDataPlansModel"
            com.paytm.utility.q.d(r0)
            int r0 = net.one97.paytm.wifi.R.string.could_not_connect_title
            java.lang.String r2 = r12.getString(r0)
            java.lang.String r0 = "getString(R.string.could_not_connect_title)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            int r0 = net.one97.paytm.wifi.R.string.fetch_data_plans_error
            java.lang.String r3 = r12.getString(r0)
            java.lang.String r0 = "getString(R.string.fetch_data_plans_error)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            int r0 = net.one97.paytm.wifi.R.string.retry
            java.lang.String r4 = r12.getString(r0)
            java.lang.String r0 = "getString(R.string.retry)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            int r0 = net.one97.paytm.wifi.R.string.dismiss
            java.lang.String r5 = r12.getString(r0)
            java.lang.String r0 = "getString(R.string.dismiss)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            java.lang.String r1 = "fetch-plan-failure"
            r0 = r12
            net.one97.paytm.wifi.ui.b.a r10 = r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            net.one97.paytm.wifi.ui.WifiDashboardActivity$g r11 = new net.one97.paytm.wifi.ui.WifiDashboardActivity$g
            r0 = r11
            r1 = r12
            r2 = r16
            r3 = r15
            r4 = r14
            r5 = r17
            r6 = r18
            r7 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            net.one97.paytm.wifi.ui.b.a$a r11 = (net.one97.paytm.wifi.ui.b.a.C0419a) r11
            r10.a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.ui.WifiDashboardActivity.a(net.one97.paytm.wifi.ui.WifiDashboardActivity, net.one97.paytm.wifi.models.WifiDataPlansModel, java.lang.String, java.lang.String, java.lang.String, boolean, net.one97.paytm.wifi.models.WifiActivePlan, net.one97.paytm.common.entity.CJRRechargeCart):void");
    }
}
