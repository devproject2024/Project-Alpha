package net.one97.paytm.wifi.ui;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.k;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.x;
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
import net.one97.paytm.wifi.models.ConnectionStatus;
import net.one97.paytm.wifi.models.InternetStatus;
import net.one97.paytm.wifi.models.WifiAccessPoint;
import net.one97.paytm.wifi.models.WifiActivePlan;
import net.one97.paytm.wifi.models.WifiAdditional;
import net.one97.paytm.wifi.models.WifiConnection;
import net.one97.paytm.wifi.models.WifiConnectionStatus;
import net.one97.paytm.wifi.models.WifiDataPlansModel;
import net.one97.paytm.wifi.models.WifiTempLogin;
import net.one97.paytm.wifi.ui.b.a;

public final class WiFiHomeActivity extends WifiBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    final int f21157a = 234;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WifiAccessPoint f21158c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f21159d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f21160e = WiFiHomeActivity.class.getName();

    /* renamed from: f  reason: collision with root package name */
    private Context f21161f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f21162g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<WifiAccessPoint> f21163h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.wifi.ui.a.a f21164i;
    /* access modifiers changed from: private */
    public WifiConnection j;
    /* access modifiers changed from: private */
    public boolean k = true;
    /* access modifiers changed from: private */
    public boolean l = true;
    private final WiFiHomeActivity$wifiStateReceiver$1 m = new WiFiHomeActivity$wifiStateReceiver$1(this);
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<WifiConnectionStatus> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21165a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WifiAccessPoint f21166b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LiveData f21167c;

        a(WiFiHomeActivity wiFiHomeActivity, WifiAccessPoint wifiAccessPoint, LiveData liveData) {
            this.f21165a = wiFiHomeActivity;
            this.f21166b = wifiAccessPoint;
            this.f21167c = liveData;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            WifiConnectionStatus wifiConnectionStatus = (WifiConnectionStatus) obj;
            if (wifiConnectionStatus != null) {
                this.f21165a.l = true;
                StringBuilder sb = new StringBuilder();
                sb.append(wifiConnectionStatus.getMessage());
                sb.append(" with status ");
                sb.append(wifiConnectionStatus.getStatus());
                sb.append(' ');
                InternetStatus internetStatus = wifiConnectionStatus.getInternetStatus();
                sb.append(internetStatus != null ? internetStatus.toString() : null);
                q.d(sb.toString());
                this.f21166b.setConnectionStatus(wifiConnectionStatus.getMessage());
                if (wifiConnectionStatus.getStatus() == ConnectionStatus.INTERNET_CONNECTION) {
                    WifiAccessPoint wifiAccessPoint = this.f21166b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(wifiConnectionStatus.getMessage());
                    sb2.append(' ');
                    Object internetStatus2 = wifiConnectionStatus.getInternetStatus();
                    if (internetStatus2 == null) {
                        internetStatus2 = "";
                    }
                    sb2.append(internetStatus2);
                    wifiAccessPoint.setConnectionStatus(sb2.toString());
                }
                WiFiHomeActivity.c(this.f21165a).notifyDataSetChanged();
                if (wifiConnectionStatus.getStatus() == ConnectionStatus.DISCONNECTED || wifiConnectionStatus.getStatus() == ConnectionStatus.CONNECTED) {
                    this.f21167c.removeObservers(this.f21165a);
                    if (wifiConnectionStatus.getStatus() == ConnectionStatus.CONNECTED) {
                        this.f21165a.f21158c = this.f21166b;
                    }
                }
            }
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.b<WifiAccessPoint, x> {
        final /* synthetic */ WiFiHomeActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(WiFiHomeActivity wiFiHomeActivity) {
            super(1);
            this.this$0 = wiFiHomeActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((WifiAccessPoint) obj);
            return x.f47997a;
        }

        public final void invoke(final WifiAccessPoint wifiAccessPoint) {
            kotlin.g.b.k.c(wifiAccessPoint, "accessPoint");
            if (this.this$0.j == null) {
                WiFiHomeActivity.b(this.this$0, wifiAccessPoint);
                return;
            }
            WiFiHomeActivity wiFiHomeActivity = this.this$0;
            String string = wiFiHomeActivity.getString(R.string.are_you_sure);
            kotlin.g.b.k.a((Object) string, "getString(R.string.are_you_sure)");
            WiFiHomeActivity wiFiHomeActivity2 = this.this$0;
            int i2 = R.string.already_subscribed;
            Object[] objArr = new Object[1];
            WifiConnection d2 = this.this$0.j;
            if (d2 == null) {
                kotlin.g.b.k.a();
            }
            objArr[0] = d2.getSSID();
            String string2 = wiFiHomeActivity2.getString(i2, objArr);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.alrea…tActiveConnection!!.SSID)");
            String string3 = this.this$0.getString(R.string.connect_to_new_internet);
            kotlin.g.b.k.a((Object) string3, "getString(R.string.connect_to_new_internet)");
            String string4 = this.this$0.getString(R.string.dismiss);
            kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
            wiFiHomeActivity.a("connect_another_wifi", string, string2, string3, string4).a(new a.C0419a(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ f f21181a;

                public final void b() {
                }

                {
                    this.f21181a = r1;
                }

                public final void a() {
                    WiFiHomeActivity.b(this.f21181a.this$0, wifiAccessPoint);
                }
            });
        }
    }

    static final class j<T> implements z<List<? extends WifiAccessPoint>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21189a;

        j(WiFiHomeActivity wiFiHomeActivity) {
            this.f21189a = wiFiHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                FrameLayout frameLayout = (FrameLayout) this.f21189a.a(R.id.noWifiFrame);
                kotlin.g.b.k.a((Object) frameLayout, "noWifiFrame");
                net.one97.paytm.wifi.ui.b.b.b(frameLayout);
                if (list.isEmpty()) {
                    RecyclerView recyclerView = (RecyclerView) this.f21189a.a(R.id.wifiList);
                    kotlin.g.b.k.a((Object) recyclerView, "wifiList");
                    recyclerView.setVisibility(8);
                    FrameLayout frameLayout2 = (FrameLayout) this.f21189a.a(R.id.refreshFeedback);
                    kotlin.g.b.k.a((Object) frameLayout2, "refreshFeedback");
                    frameLayout2.setVisibility(0);
                } else {
                    FrameLayout frameLayout3 = (FrameLayout) this.f21189a.a(R.id.refreshFeedback);
                    kotlin.g.b.k.a((Object) frameLayout3, "refreshFeedback");
                    frameLayout3.setVisibility(8);
                    RecyclerView recyclerView2 = (RecyclerView) this.f21189a.a(R.id.wifiList);
                    kotlin.g.b.k.a((Object) recyclerView2, "wifiList");
                    recyclerView2.setVisibility(0);
                }
                if (list.isEmpty() && this.f21189a.f21159d) {
                    LinearLayout linearLayout = (LinearLayout) this.f21189a.a(R.id.connectedConnection);
                    kotlin.g.b.k.a((Object) linearLayout, "connectedConnection");
                    if (linearLayout.getVisibility() == 8) {
                        FrameLayout frameLayout4 = (FrameLayout) this.f21189a.a(R.id.noWifiFrame);
                        kotlin.g.b.k.a((Object) frameLayout4, "noWifiFrame");
                        net.one97.paytm.wifi.ui.b.b.a(frameLayout4);
                    } else {
                        FrameLayout frameLayout5 = (FrameLayout) this.f21189a.a(R.id.noWifiFrame);
                        kotlin.g.b.k.a((Object) frameLayout5, "noWifiFrame");
                        net.one97.paytm.wifi.ui.b.b.b(frameLayout5);
                    }
                }
                q.d("received " + list.size() + " access points.");
                this.f21189a.f21163h.clear();
                this.f21189a.f21163h.addAll(list);
                WiFiHomeActivity.c(this.f21189a).notifyDataSetChanged();
            }
        }
    }

    static final class k<T> implements z<WifiConnection> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21190a;

        k(WiFiHomeActivity wiFiHomeActivity) {
            this.f21190a = wiFiHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            WifiConnection wifiConnection = (WifiConnection) obj;
            if (wifiConnection != null) {
                this.f21190a.j = wifiConnection;
                LinearLayout linearLayout = (LinearLayout) this.f21190a.a(R.id.connectedConnection);
                kotlin.g.b.k.a((Object) linearLayout, "connectedConnection");
                net.one97.paytm.wifi.ui.b.b.a(linearLayout);
                FrameLayout frameLayout = (FrameLayout) this.f21190a.a(R.id.noWifiFrame);
                kotlin.g.b.k.a((Object) frameLayout, "noWifiFrame");
                net.one97.paytm.wifi.ui.b.b.b(frameLayout);
                LinearLayout linearLayout2 = (LinearLayout) this.f21190a.a(R.id.connectedConnection);
                kotlin.g.b.k.a((Object) linearLayout2, "connectedConnection");
                RoboTextView roboTextView = (RoboTextView) linearLayout2.findViewById(R.id.name);
                kotlin.g.b.k.a((Object) roboTextView, "connectedConnection.name");
                roboTextView.setText(wifiConnection.getSSID());
                if (this.f21190a.f21158c != null) {
                    WiFiHomeActivity wiFiHomeActivity = this.f21190a;
                    WifiAccessPoint e2 = wiFiHomeActivity.f21158c;
                    if (e2 == null) {
                        kotlin.g.b.k.a();
                    }
                    WifiAdditional wifiAdditional = e2.getWifiAdditional();
                    if (wifiAdditional == null || (str = wifiAdditional.getPId()) == null) {
                        str = "";
                    }
                    WiFiHomeActivity.a(wiFiHomeActivity, str, wifiConnection.getBSSID(), wifiConnection.getSSID());
                    this.f21190a.f21158c = null;
                }
                this.f21190a.f21159d = false;
                return;
            }
            this.f21190a.j = null;
            this.f21190a.f21159d = true;
            LinearLayout linearLayout3 = (LinearLayout) this.f21190a.a(R.id.connectedConnection);
            kotlin.g.b.k.a((Object) linearLayout3, "connectedConnection");
            net.one97.paytm.wifi.ui.b.b.b(linearLayout3);
        }
    }

    public static final /* synthetic */ net.one97.paytm.wifi.ui.a.a c(WiFiHomeActivity wiFiHomeActivity) {
        net.one97.paytm.wifi.ui.a.a aVar = wiFiHomeActivity.f21164i;
        if (aVar == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        return aVar;
    }

    public final int a() {
        return R.layout.activity_wifi_home;
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
        Context context = this;
        if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 100);
        } else if (!f()) {
            e();
        }
        this.f21161f = context;
        c();
        a.C0409a aVar5 = net.one97.paytm.wifi.a.a.f21069c;
        a.C0409a.a().f21070a.g();
        View findViewById = findViewById(R.id.title);
        kotlin.g.b.k.a((Object) findViewById, "findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setVisibility(8);
        ((RoboButton) a(R.id.btnRefresh)).setOnClickListener(new g(this, eVar));
        ((RoboButton) a(R.id.btnTryAgain)).setOnClickListener(new h(this, eVar));
        ((RoboButton) a(R.id.btnTurnOnWifi)).setOnClickListener(new i(this, eVar));
        FrameLayout frameLayout = (FrameLayout) a(R.id.wifiTurnOffFrame);
        kotlin.g.b.k.a((Object) frameLayout, "wifiTurnOffFrame");
        frameLayout.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) a(R.id.wifiList);
        kotlin.g.b.k.a((Object) recyclerView, "wifiList");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f21164i = new net.one97.paytm.wifi.ui.a.a(context, this.f21163h, new f(this));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.wifiList);
        kotlin.g.b.k.a((Object) recyclerView2, "wifiList");
        net.one97.paytm.wifi.ui.a.a aVar6 = this.f21164i;
        if (aVar6 == null) {
            kotlin.g.b.k.a("mAdapter");
        }
        recyclerView2.setAdapter(aVar6);
        if (getIntent().getBooleanExtra("IS_DASHBOARD_NAVIGATION", false)) {
            startActivity(new Intent(context, WifiDashboardActivity.class));
        }
        a.C0409a aVar7 = net.one97.paytm.wifi.a.a.f21069c;
        androidx.lifecycle.q qVar = this;
        a.C0409a.a().f21070a.d().observe(qVar, new j(this));
        a.C0409a aVar8 = net.one97.paytm.wifi.a.a.f21069c;
        a.C0409a.a().f21070a.e().observe(qVar, new k(this));
        ((RelativeLayout) a(R.id.activeConnectionView)).setOnClickListener(new l(this, eVar));
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21183a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wifi.background.wifi.e f21184b;

        g(WiFiHomeActivity wiFiHomeActivity, net.one97.paytm.wifi.background.wifi.e eVar) {
            this.f21183a = wiFiHomeActivity;
            this.f21184b = eVar;
        }

        public final void onClick(View view) {
            if (!this.f21184b.b()) {
                WiFiHomeActivity wiFiHomeActivity = this.f21183a;
                String string = wiFiHomeActivity.getString(R.string.enabling_wifi);
                kotlin.g.b.k.a((Object) string, "getString(R.string.enabling_wifi)");
                net.one97.paytm.wifi.ui.b.b.a(wiFiHomeActivity, string, 0);
                this.f21184b.c();
                a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
                a.C0409a.a().f21070a.g();
            }
            a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.g();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wifi.background.wifi.e f21186b;

        h(WiFiHomeActivity wiFiHomeActivity, net.one97.paytm.wifi.background.wifi.e eVar) {
            this.f21185a = wiFiHomeActivity;
            this.f21186b = eVar;
        }

        public final void onClick(View view) {
            if (!this.f21186b.b()) {
                WiFiHomeActivity wiFiHomeActivity = this.f21185a;
                String string = wiFiHomeActivity.getString(R.string.enabling_wifi);
                kotlin.g.b.k.a((Object) string, "getString(R.string.enabling_wifi)");
                net.one97.paytm.wifi.ui.b.b.a(wiFiHomeActivity, string, 0);
                this.f21186b.c();
                a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
                a.C0409a.a().f21070a.g();
            }
            a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.g();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wifi.background.wifi.e f21188b;

        i(WiFiHomeActivity wiFiHomeActivity, net.one97.paytm.wifi.background.wifi.e eVar) {
            this.f21187a = wiFiHomeActivity;
            this.f21188b = eVar;
        }

        public final void onClick(View view) {
            if (!this.f21188b.b()) {
                WiFiHomeActivity wiFiHomeActivity = this.f21187a;
                String string = wiFiHomeActivity.getString(R.string.enabling_wifi);
                kotlin.g.b.k.a((Object) string, "getString(R.string.enabling_wifi)");
                net.one97.paytm.wifi.ui.b.b.a(wiFiHomeActivity, string, 0);
                this.f21188b.c();
                a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
                a.C0409a.a().f21070a.g();
            }
            a.C0409a aVar2 = net.one97.paytm.wifi.a.a.f21069c;
            a.C0409a.a().f21070a.g();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wifi.background.wifi.e f21192b;

        l(WiFiHomeActivity wiFiHomeActivity, net.one97.paytm.wifi.background.wifi.e eVar) {
            this.f21191a = wiFiHomeActivity;
            this.f21192b = eVar;
        }

        public final void onClick(View view) {
            if (this.f21191a.j != null) {
                net.one97.paytm.wifi.background.wifi.e eVar = this.f21192b;
                WifiConnection d2 = this.f21191a.j;
                if (d2 == null) {
                    kotlin.g.b.k.a();
                }
                String b2 = eVar.b(d2.getSSID());
                if (b2 == null) {
                    net.one97.paytm.wifi.ui.b.b.a(this.f21191a, "Not a Paytm Partner Wifi", 0);
                } else if (this.f21191a.k) {
                    this.f21191a.k = false;
                    WiFiHomeActivity wiFiHomeActivity = this.f21191a;
                    WifiConnection d3 = wiFiHomeActivity.j;
                    if (d3 == null) {
                        kotlin.g.b.k.a();
                    }
                    String bssid = d3.getBSSID();
                    WifiConnection d4 = this.f21191a.j;
                    if (d4 == null) {
                        kotlin.g.b.k.a();
                    }
                    WiFiHomeActivity.a(wiFiHomeActivity, b2, bssid, d4.getSSID());
                }
            }
        }
    }

    public final void onResume() {
        super.onResume();
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        a.C0409a.a().f21070a.g();
        this.k = true;
    }

    public static final class n implements net.one97.paytm.wifi.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21199b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21200c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21201d;

        n(WiFiHomeActivity wiFiHomeActivity, String str, String str2, String str3) {
            this.f21198a = wiFiHomeActivity;
            this.f21199b = str;
            this.f21200c = str2;
            this.f21201d = str3;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            androidx.lifecycle.k lifecycle = this.f21198a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                this.f21198a.k = true;
                String unused = this.f21198a.f21160e;
                q.d("On Error Called ValidateUserConnection");
                this.f21198a.c();
                WiFiHomeActivity wiFiHomeActivity = this.f21198a;
                String string = wiFiHomeActivity.getString(R.string.could_not_connect_title);
                kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                String string2 = this.f21198a.getString(R.string.could_not_connect);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.could_not_connect)");
                String string3 = this.f21198a.getString(R.string.retry);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                String string4 = this.f21198a.getString(R.string.dismiss);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                wiFiHomeActivity.a("validation-failed", string, string2, string3, string4).a(new a(this));
            }
        }

        public static final class a implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f21202a;

            public final void b() {
            }

            a(n nVar) {
                this.f21202a = nVar;
            }

            public final void a() {
                WiFiHomeActivity.a(this.f21202a.f21198a, this.f21202a.f21199b, this.f21202a.f21200c, this.f21202a.f21201d);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            androidx.lifecycle.k lifecycle = this.f21198a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21198a.f21160e;
                q.d("On Success Called ValidateUserConnection");
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRRechargeCart)) {
                    String unused2 = this.f21198a.f21160e;
                    q.d("CJRRechargeCart response model empty - ValidateUserConnection");
                    WiFiHomeActivity wiFiHomeActivity = this.f21198a;
                    String string = wiFiHomeActivity.getString(R.string.could_not_connect_title);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                    String string2 = this.f21198a.getString(R.string.could_not_connect);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.could_not_connect)");
                    String string3 = this.f21198a.getString(R.string.retry);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                    String string4 = this.f21198a.getString(R.string.dismiss);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                    wiFiHomeActivity.a("validation-failed", string, string2, string3, string4).a(new b(this));
                    this.f21198a.c();
                    this.f21198a.k = true;
                    return;
                }
                WiFiHomeActivity.a(this.f21198a, (CJRRechargeCart) iJRPaytmDataModel, this.f21201d, this.f21200c, this.f21199b);
            }
        }

        public static final class b implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f21203a;

            public final void b() {
            }

            b(n nVar) {
                this.f21203a = nVar;
            }

            public final void a() {
                WiFiHomeActivity.a(this.f21203a.f21198a, this.f21203a.f21199b, this.f21203a.f21200c, this.f21203a.f21201d);
            }
        }
    }

    public static final class e implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21177a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21178b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21179c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21180d;

        public final void b() {
        }

        e(WiFiHomeActivity wiFiHomeActivity, String str, String str2, String str3) {
            this.f21177a = wiFiHomeActivity;
            this.f21178b = str;
            this.f21179c = str2;
            this.f21180d = str3;
        }

        public final void a() {
            WiFiHomeActivity.a(this.f21177a, this.f21178b, this.f21179c, this.f21180d);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, String str3, CJRRechargeCart cJRRechargeCart) {
        q.d("fetching user data plans.");
        d();
        this.k = false;
        String l2 = com.paytm.utility.b.l((Context) this);
        if (l2 == null) {
            l2 = "";
        }
        String str4 = l2;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        new net.one97.paytm.wifi.b.a(applicationContext).b(str4, net.one97.paytm.wifi.background.wifi.g.a(), str, str3, str2, new d(this, str, str2, str3, cJRRechargeCart));
    }

    public static final class d implements net.one97.paytm.wifi.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21172c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21173d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRRechargeCart f21174e;

        d(WiFiHomeActivity wiFiHomeActivity, String str, String str2, String str3, CJRRechargeCart cJRRechargeCart) {
            this.f21170a = wiFiHomeActivity;
            this.f21171b = str;
            this.f21172c = str2;
            this.f21173d = str3;
            this.f21174e = cJRRechargeCart;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            androidx.lifecycle.k lifecycle = this.f21170a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21170a.f21160e;
                q.d("On Error called FetchUserPlanResponse");
                this.f21170a.k = true;
                this.f21170a.c();
                WiFiHomeActivity wiFiHomeActivity = this.f21170a;
                String string = wiFiHomeActivity.getString(R.string.could_not_connect_title);
                kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                String string2 = this.f21170a.getString(R.string.fetch_data_plans_error);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.fetch_data_plans_error)");
                String string3 = this.f21170a.getString(R.string.retry);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                String string4 = this.f21170a.getString(R.string.dismiss);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                wiFiHomeActivity.a("fetch-plan-failed", string, string2, string3, string4).a(new a(this));
            }
        }

        public static final class a implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f21175a;

            public final void b() {
            }

            a(d dVar) {
                this.f21175a = dVar;
            }

            public final void a() {
                this.f21175a.f21170a.a(this.f21175a.f21171b, this.f21175a.f21172c, this.f21175a.f21173d, this.f21175a.f21174e);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            androidx.lifecycle.k lifecycle = this.f21170a.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "lifecycle");
            if (lifecycle.a().isAtLeast(k.b.STARTED)) {
                String unused = this.f21170a.f21160e;
                q.d("On Success called FetchUserPlanResponse");
                this.f21170a.c();
                if (iJRPaytmDataModel == null) {
                    String unused2 = this.f21170a.f21160e;
                    q.d("On Success called FetchUserPlanResponse \n WifiDataPlansModel is null");
                    this.f21170a.k = true;
                    this.f21170a.c();
                    WiFiHomeActivity wiFiHomeActivity = this.f21170a;
                    String string = wiFiHomeActivity.getString(R.string.could_not_connect_title);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
                    String string2 = this.f21170a.getString(R.string.fetch_data_plans_error);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.fetch_data_plans_error)");
                    String string3 = this.f21170a.getString(R.string.retry);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
                    String string4 = this.f21170a.getString(R.string.dismiss);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
                    wiFiHomeActivity.a("fetch-plan-failed", string, string2, string3, string4).a(new b(this));
                    return;
                }
                WiFiHomeActivity.a(this.f21170a, (WifiDataPlansModel) iJRPaytmDataModel, this.f21171b, this.f21173d, this.f21172c, this.f21174e);
            }
        }

        public static final class b implements a.C0419a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f21176a;

            public final void b() {
            }

            b(d dVar) {
                this.f21176a = dVar;
            }

            public final void a() {
                this.f21176a.f21170a.a(this.f21176a.f21171b, this.f21176a.f21172c, this.f21176a.f21173d, this.f21176a.f21174e);
            }
        }
    }

    public static final class m implements a.C0419a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21194b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21195c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21196d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRRechargeCart f21197e;

        public final void b() {
        }

        m(WiFiHomeActivity wiFiHomeActivity, String str, String str2, String str3, CJRRechargeCart cJRRechargeCart) {
            this.f21193a = wiFiHomeActivity;
            this.f21194b = str;
            this.f21195c = str2;
            this.f21196d = str3;
            this.f21197e = cJRRechargeCart;
        }

        public final void a() {
            this.f21193a.a(this.f21194b, this.f21195c, this.f21196d, this.f21197e);
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.progressBarLayout);
        kotlin.g.b.k.a((Object) relativeLayout, "progressBarLayout");
        net.one97.paytm.wifi.ui.b.b.b(relativeLayout);
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loaderView));
    }

    private final void d() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.progressBarLayout);
        kotlin.g.b.k.a((Object) relativeLayout, "progressBarLayout");
        net.one97.paytm.wifi.ui.b.b.a(relativeLayout);
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loaderView));
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 100) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                q.d("Permissions denied");
                net.one97.paytm.wifi.ui.b.b.a(this, "location permission needed to use Paytm Wifi", 1);
                onBackPressed();
            } else if (androidx.core.content.b.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                if (!f()) {
                    e();
                }
                q.d("Location permisssion granted");
            }
        }
    }

    private final void e() {
        if (!f()) {
            new c.a(this).a((CharSequence) "Enable Location").b((CharSequence) "Enable Location to use this feature").a((CharSequence) Payload.RESPONSE_OK, (DialogInterface.OnClickListener) new b(this)).b((CharSequence) "Cancel", (DialogInterface.OnClickListener) new c(this)).a().show();
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21168a;

        b(WiFiHomeActivity wiFiHomeActivity) {
            this.f21168a = wiFiHomeActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f21168a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), this.f21168a.f21157a);
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WiFiHomeActivity f21169a;

        c(WiFiHomeActivity wiFiHomeActivity) {
            this.f21169a = wiFiHomeActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.wifi.ui.b.b.a(this.f21169a, "location permission needed to use Paytm Wifi", 1);
            this.f21169a.onBackPressed();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f21157a && !f()) {
            e();
        }
    }

    /* access modifiers changed from: private */
    public final net.one97.paytm.wifi.ui.b.a a(String str, String str2, String str3, String str4, String str5) {
        net.one97.paytm.wifi.ui.b.a aVar = new net.one97.paytm.wifi.ui.b.a(str2, str3, str4, str5);
        aVar.setCancelable(true);
        aVar.show(getSupportFragmentManager(), str);
        return aVar;
    }

    private final boolean f() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(getContentResolver(), "location_mode") != 0;
            } catch (Settings.SettingNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } else {
            String string = Settings.Secure.getString(getContentResolver(), "location_providers_allowed");
            kotlin.g.b.k.a((Object) string, "Settings.Secure.getStrin…CATION_PROVIDERS_ALLOWED)");
            return !TextUtils.isEmpty(string);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        a.C0409a.a().a(false);
    }

    public final void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        registerReceiver(this.m, intentFilter);
    }

    public final void onStop() {
        super.onStop();
        unregisterReceiver(this.m);
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        kotlin.g.b.k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (i2 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        net.one97.paytm.wifi.a.b();
        if (net.one97.paytm.wifi.a.a() == null) {
            new net.one97.paytm.wifi.c.a();
            net.one97.paytm.wifi.c.a.a();
        }
        kotlin.g.b.k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
        net.one97.paytm.wifi.a.c().startMainActivity(this, intent);
        super.onBackPressed();
    }

    public static final /* synthetic */ void a(WiFiHomeActivity wiFiHomeActivity, String str, String str2, String str3) {
        q.d("Doing verify connection call");
        wiFiHomeActivity.k = false;
        wiFiHomeActivity.d();
        String l2 = com.paytm.utility.b.l((Context) wiFiHomeActivity);
        if (l2 == null) {
            l2 = "";
        }
        String str4 = l2;
        Context applicationContext = wiFiHomeActivity.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        new net.one97.paytm.wifi.b.a(applicationContext).a(str4, net.one97.paytm.wifi.background.wifi.g.a(), str3, str2, str, new n(wiFiHomeActivity, str, str2, str3));
    }

    public static final /* synthetic */ void b(WiFiHomeActivity wiFiHomeActivity, WifiAccessPoint wifiAccessPoint) {
        if (wiFiHomeActivity.l) {
            wiFiHomeActivity.l = false;
            a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
            LiveData<WifiConnectionStatus> a2 = a.C0409a.a().f21070a.a(wifiAccessPoint);
            a2.observe(wiFiHomeActivity, new a(wiFiHomeActivity, wifiAccessPoint, a2));
        }
    }

    public static final /* synthetic */ void a(WiFiHomeActivity wiFiHomeActivity, CJRRechargeCart cJRRechargeCart, String str, String str2, String str3) {
        boolean z = false;
        wiFiHomeActivity.k = false;
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
                                                    z = true;
                                                }
                                                if (z) {
                                                    q.d("GA_USER null handleValidationResponse");
                                                    if (wifiActivePlan.isActivePlan() == null || kotlin.g.b.k.a((Object) "false", (Object) wifiActivePlan.isActivePlan())) {
                                                        q.d("IS_ACTIVE == null/false -  handleValidationResponse \n moving to data-plan fetch \n forDashboard == false");
                                                        wiFiHomeActivity.a(str, str3, str2, cJRRechargeCart);
                                                        return;
                                                    }
                                                    wiFiHomeActivity.c();
                                                    Intent intent = new Intent(wiFiHomeActivity, WifiDashboardActivity.class);
                                                    intent.putExtra("ssid", str);
                                                    intent.putExtra("key_wifi_plan_status", wifiActivePlan);
                                                    wiFiHomeActivity.startActivity(intent);
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
        String string = wiFiHomeActivity.getString(R.string.could_not_connect_title);
        kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_connect_title)");
        String string2 = wiFiHomeActivity.getString(R.string.could_not_connect);
        kotlin.g.b.k.a((Object) string2, "getString(R.string.could_not_connect)");
        String string3 = wiFiHomeActivity.getString(R.string.retry);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.retry)");
        String string4 = wiFiHomeActivity.getString(R.string.dismiss);
        kotlin.g.b.k.a((Object) string4, "getString(R.string.dismiss)");
        wiFiHomeActivity.a("validation-failed", string, string2, string3, string4).a(new e(wiFiHomeActivity, str3, str2, str));
        wiFiHomeActivity.c();
        wiFiHomeActivity.k = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        r8 = r8.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.wifi.ui.WiFiHomeActivity r7, net.one97.paytm.wifi.models.WifiDataPlansModel r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, net.one97.paytm.common.entity.CJRRechargeCart r12) {
        /*
            java.lang.String r0 = "onLoadDataPlanComplete handle response"
            com.paytm.utility.q.d(r0)
            boolean r0 = r8.getPlanFetchSuccessful()
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r8.getUserplansGwResponse()
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r8.getUserplansGwResponse()
            if (r0 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            boolean r0 = r0.getDeducedStatus()
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r8.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            java.util.List r0 = r0.getPlansArray()
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r8.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0038
            kotlin.g.b.k.a()
        L_0x0038:
            java.util.List r0 = r0.getPlansArray()
            if (r0 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00a8
            net.one97.paytm.wifi.models.WifiUserPlanResponse r0 = r8.getUserplansGwResponse()
            if (r0 != 0) goto L_0x0050
            kotlin.g.b.k.a()
        L_0x0050:
            java.util.List r0 = r0.getPlansArray()
            if (r0 != 0) goto L_0x0059
            kotlin.g.b.k.a()
        L_0x0059:
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.wifi.models.WifiPlanArray r0 = (net.one97.paytm.wifi.models.WifiPlanArray) r0
            java.util.ArrayList r0 = r0.getData()
            if (r0 != 0) goto L_0x0067
            goto L_0x00a8
        L_0x0067:
            java.lang.String r10 = "proceed to data-plan activity"
            com.paytm.utility.q.d(r10)
            android.content.Intent r10 = new android.content.Intent
            r11 = r7
            android.content.Context r11 = (android.content.Context) r11
            java.lang.Class<net.one97.paytm.wifi.ui.WifiDataPlansActivity> r0 = net.one97.paytm.wifi.ui.WifiDataPlansActivity.class
            r10.<init>(r11, r0)
            net.one97.paytm.wifi.models.WifiUserPlanResponse r8 = r8.getUserplansGwResponse()
            if (r8 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            java.util.List r8 = r8.getPlansArray()
            if (r8 == 0) goto L_0x0092
            java.lang.Object r8 = r8.get(r1)
            net.one97.paytm.wifi.models.WifiPlanArray r8 = (net.one97.paytm.wifi.models.WifiPlanArray) r8
            if (r8 == 0) goto L_0x0092
            java.util.ArrayList r8 = r8.getData()
            goto L_0x0093
        L_0x0092:
            r8 = 0
        L_0x0093:
            java.lang.String r11 = "key_wifi_plans"
            r10.putParcelableArrayListExtra(r11, r8)
            java.lang.String r8 = "key_wifi_ssid"
            r10.putExtra(r8, r9)
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r8 = "key_cart_item"
            r10.putExtra(r8, r12)
            r7.startActivity(r10)
            return
        L_0x00a8:
            java.lang.String r8 = "response incorrect WifiDataPlansModel"
            com.paytm.utility.q.b(r8)
            r8 = 1
            r7.k = r8
            int r8 = net.one97.paytm.wifi.R.string.could_not_connect_title
            java.lang.String r2 = r7.getString(r8)
            java.lang.String r8 = "getString(R.string.could_not_connect_title)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            int r8 = net.one97.paytm.wifi.R.string.fetch_data_plans_error
            java.lang.String r3 = r7.getString(r8)
            java.lang.String r8 = "getString(R.string.fetch_data_plans_error)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            int r8 = net.one97.paytm.wifi.R.string.retry
            java.lang.String r4 = r7.getString(r8)
            java.lang.String r8 = "getString(R.string.retry)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            int r8 = net.one97.paytm.wifi.R.string.dismiss
            java.lang.String r5 = r7.getString(r8)
            java.lang.String r8 = "getString(R.string.dismiss)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r1 = "fetch-plan-failed"
            r0 = r7
            net.one97.paytm.wifi.ui.b.a r8 = r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            net.one97.paytm.wifi.ui.WiFiHomeActivity$m r6 = new net.one97.paytm.wifi.ui.WiFiHomeActivity$m
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r11
            r4 = r10
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            net.one97.paytm.wifi.ui.b.a$a r6 = (net.one97.paytm.wifi.ui.b.a.C0419a) r6
            r8.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.ui.WiFiHomeActivity.a(net.one97.paytm.wifi.ui.WiFiHomeActivity, net.one97.paytm.wifi.models.WifiDataPlansModel, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart):void");
    }
}
