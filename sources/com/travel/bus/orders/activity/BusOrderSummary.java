package com.travel.bus.orders.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.f.d;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.f.f;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public class BusOrderSummary extends PaytmActivity implements d, f, m {
    private c mActiveFragment;
    private com.travel.bus.orders.c.a mBusOrderSummaryFragment;
    private String mEntryPoint;
    private boolean mHomeLaunchCalled;
    private boolean mIsGAEvents = false;
    private String mOrderNo;
    private a mType;

    public void onViewCreated() {
    }

    public void show() {
    }

    public enum a {
        BUS("bus");
        
        /* access modifiers changed from: private */
        public final String name;

        private a(String str) {
            this.name = str;
        }
    }

    public void removeProgress() {
        com.travel.bus.orders.c.a aVar = this.mBusOrderSummaryFragment;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromIntent(getIntent());
        checkDataFromDeeplinking(getIntent());
        setContentView(R.layout.pre_b_new_order_summary);
        if (isAuthUser()) {
            loadOrderSummaryPage();
        } else {
            callLoginActivity();
        }
    }

    private void callLoginActivity() {
        Intent intent = new Intent();
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent, 4);
    }

    private void loadOrderSummaryPage() {
        startOrderSummaryFragment();
        setContactListener();
        if (this.mType == null || TextUtils.isEmpty(this.mOrderNo)) {
            showErrorMessage();
        }
    }

    private boolean isAuthUser() {
        if (com.travel.bus.b.a.a(getApplicationContext()).b("sso_token=", "", true).length() > 0) {
            return true;
        }
        return false;
    }

    private void checkDataFromDeeplinking(Intent intent) {
        CJRItem cJRItem = (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            try {
                if (!TextUtils.isEmpty(cJRItem.getURLType()) && cJRItem.getURLType().equalsIgnoreCase("bus_order_summary")) {
                    this.mType = a.BUS;
                }
                String url = cJRItem.getURL();
                String str = "";
                if (url != null) {
                    if (url.startsWith("paytmmp")) {
                        String queryParameter = Uri.parse(url).getQueryParameter("url");
                        if (queryParameter != null) {
                            Uri parse = Uri.parse(queryParameter);
                            if (parse.getPath() != null) {
                                str = parse.getPath().toLowerCase();
                            }
                            this.mOrderNo = str.substring(str.indexOf("/v1/myorders/") + 13);
                        }
                        this.mEntryPoint = "Deep Linking";
                    }
                }
                Uri parse2 = Uri.parse(url);
                if (parse2.getPath() != null) {
                    str = parse2.getPath().toLowerCase();
                }
                this.mOrderNo = str.substring(str.indexOf("myorders/") + 9);
                this.mEntryPoint = "Deep Linking";
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public void setContactListener() {
        c cVar = this.mActiveFragment;
        if (cVar != null) {
            cVar.p = this;
        }
    }

    public String getOrderTitle() {
        if (!TextUtils.isEmpty(this.mOrderNo)) {
            return this.mOrderNo;
        }
        return AnonymousClass1.f22569a[this.mType.ordinal()] != 1 ? "" : "Bus Order Summary";
    }

    /* renamed from: com.travel.bus.orders.activity.BusOrderSummary$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22569a = new int[a.values().length];

        static {
            try {
                f22569a[a.BUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.mEntryPoint) && this.mEntryPoint.equalsIgnoreCase("Payment") && this.mOrderNo != null && !this.mHomeLaunchCalled) {
            this.mHomeLaunchCalled = true;
            launchHome();
        }
        super.onBackPressed();
    }

    private void launchHome() {
        new CJRHomePageItem().setUrl(com.travel.bus.b.a.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        if (!TextUtils.isEmpty(this.mEntryPoint) && this.mEntryPoint.equalsIgnoreCase("Payment")) {
            intent.putExtra("Reset_fast_farward", true);
        }
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent);
        finish();
    }

    private void startOrderSummaryFragment() {
        if (this.mType == null) {
            return;
        }
        if (AnonymousClass1.f22569a[this.mType.ordinal()] != 1) {
            showErrorMessage();
        } else {
            startBusFragment();
        }
    }

    private void getDataFromIntent(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString("order-summary-type", (String) null);
            int i2 = 0;
            this.mIsGAEvents = intent.getBooleanExtra("isGAEvents", false);
            this.mEntryPoint = intent.getStringExtra(UpiConstants.FROM);
            if (!TextUtils.isEmpty(string)) {
                a[] values = a.values();
                int length = values.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    a aVar = values[i2];
                    if (string.equalsIgnoreCase(aVar.name)) {
                        this.mType = aVar;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.mOrderNo = intent.getStringExtra("order_id");
    }

    private void startBusFragment() {
        if (this.mBusOrderSummaryFragment == null) {
            this.mBusOrderSummaryFragment = new com.travel.bus.orders.c.a();
        }
        this.mBusOrderSummaryFragment.f22576g = this;
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (TextUtils.isEmpty(extras.getString("order_id", (String) null)) && !TextUtils.isEmpty(this.mOrderNo)) {
                extras.putString("order_id", this.mOrderNo);
            }
            extras.putSerializable("VERTICAL", this.mType);
            extras.putBoolean("isGAEvents", this.mIsGAEvents);
            extras.putString(UpiConstants.FROM, this.mEntryPoint);
            if (TextUtils.isEmpty(this.mEntryPoint) || !this.mEntryPoint.equalsIgnoreCase("Payment")) {
                extras.putBoolean("isFromPayment", false);
            } else {
                extras.putBoolean("isFromPayment", true);
            }
            this.mBusOrderSummaryFragment.setArguments(extras);
        }
        this.mActiveFragment = this.mBusOrderSummaryFragment;
        getSupportFragmentManager().a().a(R.id.newOrderSummaryFrameLayout, (Fragment) this.mBusOrderSummaryFragment).b();
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("/bus-tickets-summary", "BusTicket", (Context) this);
    }

    public void showErrorMessage() {
        b.b((Context) this, getString(R.string.error_dialog_title), getString(R.string.some_went_wrong));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 4) {
            if (!isAuthUser() || i3 != -1) {
                finish();
            } else {
                loadOrderSummaryPage();
            }
        } else if (getActiveFragment() != null) {
            this.mActiveFragment.onActivityResult(i2, i3, intent);
        }
    }

    private Fragment getActiveFragment() {
        return this.mActiveFragment;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        com.travel.bus.orders.c.a aVar = this.mBusOrderSummaryFragment;
        if (aVar != null) {
            com.travel.bus.orders.d.a aVar2 = aVar.f22600h;
            if (i2 != 56) {
                return;
            }
            if (s.a(iArr)) {
                String str = com.travel.bus.orders.d.a.f22607g;
                q.d("permission granted");
                aVar2.a();
                return;
            }
            String str2 = com.travel.bus.orders.d.a.f22607g;
            q.d("permission not granted! wtf!");
            aVar2.b();
            if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", aVar2.f22608a) != 1) {
                aVar2.a(true);
            }
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void dismiss() {
        com.travel.bus.orders.c.a aVar = this.mBusOrderSummaryFragment;
        if (aVar != null) {
            aVar.f();
        }
    }
}
