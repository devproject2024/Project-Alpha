package com.travel.flight.flightorder.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.RoboTextView;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.e.b;
import com.travel.flight.flightorder.g.d;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.flight.utils.i;
import com.travel.utils.n;
import com.travel.utils.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public class FlightOrderSummary extends PaytmActivity implements d, m {
    private b CJRContactUsDialogHelper;
    private ImageView backButton;
    private com.travel.flight.flightorder.d.b mActiveFragment;
    private RelativeLayout mBackBtnLyt;
    b.C0467b mCurrentState;
    private String mEntryPoint;
    private com.travel.flight.flightorder.d.a mFlightOrderSummaryFragment;
    private com.travel.flight.flightorder.h.a mFlightOrderSummaryPresenter;
    private boolean mHomeLaunchCalled;
    private boolean mIsGAEvents = false;
    private String mOrderNo;
    private CJRFlightOrderSummaryResponse mOrderSummary;
    private ProgressDialog mProgressDialog;
    private ImageView mShareButton;
    private TextView mTitle;
    private ImageView mTravelSupportIcon;
    private a mType;

    public void show() {
        com.travel.flight.flightorder.d.a aVar = this.mFlightOrderSummaryFragment;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void dismiss() {
        com.travel.flight.flightorder.d.a aVar = this.mFlightOrderSummaryFragment;
        if (aVar != null) {
            aVar.g();
        }
    }

    public enum a {
        FLIGHT("flight");
        
        /* access modifiers changed from: private */
        public final String name;

        private a(String str) {
            this.name = str;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromIntent(getIntent());
        checkDataFromDeeplinking(getIntent());
        setContentView(R.layout.pre_f_flight_new_order_summary);
        initUI();
        startOrderSummaryFragment();
        if (this.mType == null || TextUtils.isEmpty(this.mOrderNo)) {
            showErrorMessage();
        }
    }

    private void checkDataFromDeeplinking(Intent intent) {
        CJRItem cJRItem = (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            try {
                this.mType = a.FLIGHT;
                String url = cJRItem.getURL();
                if (TextUtils.isEmpty(url) && (cJRItem instanceof CJRHomePageItem)) {
                    url = ((CJRHomePageItem) cJRItem).getDeeplink();
                }
                Uri parse = Uri.parse(url);
                String path = parse.getPath();
                if (TextUtils.isEmpty(path)) {
                    String queryParameter = parse.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        path = Uri.parse(queryParameter).getPath();
                    }
                }
                this.mOrderNo = path.substring(path.indexOf("myOrders/") + 9, path.length());
                this.mEntryPoint = "Deep Linking";
            } catch (Exception unused) {
            }
        }
    }

    public void shouldDisplayShareButton(boolean z) {
        if (z) {
            this.mShareButton.setVisibility(0);
        } else {
            this.mShareButton.setVisibility(8);
        }
    }

    private void initUI() {
        this.mTitle = (RoboTextView) findViewById(R.id.activity_header);
        this.mBackBtnLyt = (RelativeLayout) findViewById(R.id.toolbar_btn_layout);
        this.backButton = (ImageView) findViewById(R.id.back_btn);
        this.backButton.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.backButton.setRotation(180.0f);
        this.mBackBtnLyt.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUI$0$FlightOrderSummary(view);
            }
        });
        this.mTravelSupportIcon = (ImageView) findViewById(R.id.travel_support);
        ResourceUtils.loadFlightImagesFromCDN(this.mTravelSupportIcon, "help_support_icon.png", false, false, n.a.V1);
        this.mTravelSupportIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUI$1$FlightOrderSummary(view);
            }
        });
        if (!TextUtils.isEmpty(this.mOrderNo)) {
            TextView textView = this.mTitle;
            textView.setText(getString(R.string.bookin_id) + " - " + this.mOrderNo);
        } else {
            this.mTitle.setText(AnonymousClass1.f24339a[this.mType.ordinal()] != 1 ? "" : "Flight Order Summary");
        }
        this.mShareButton = (ImageView) findViewById(R.id.order_summary_share_button);
        ResourceUtils.loadFlightImagesFromCDN(this.mShareButton, "share_icon.png", false, true, n.a.V1);
        this.mShareButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUI$2$FlightOrderSummary(view);
            }
        });
    }

    public /* synthetic */ void lambda$initUI$0$FlightOrderSummary(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initUI$1$FlightOrderSummary(View view) {
        performSupportClick();
    }

    /* renamed from: com.travel.flight.flightorder.activity.FlightOrderSummary$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24339a = new int[a.values().length];

        static {
            try {
                f24339a[a.FLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public /* synthetic */ void lambda$initUI$2$FlightOrderSummary(View view) {
        com.travel.flight.flightorder.d.a aVar = this.mFlightOrderSummaryFragment;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void initUIForParentOrderSummary(String str) {
        this.mTitle = (RoboTextView) findViewById(R.id.activity_header);
        this.mBackBtnLyt = (RelativeLayout) findViewById(R.id.toolbar_btn_layout);
        this.mBackBtnLyt.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUIForParentOrderSummary$3$FlightOrderSummary(view);
            }
        });
        this.mTravelSupportIcon = (ImageView) findViewById(R.id.travel_support);
        this.mTravelSupportIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUIForParentOrderSummary$4$FlightOrderSummary(view);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.mTitle;
            textView.setText(getString(R.string.bookin_id) + " - " + str);
        } else {
            this.mTitle.setText(AnonymousClass1.f24339a[this.mType.ordinal()] != 1 ? "" : "Flight Order Summary");
        }
        this.mShareButton = (ImageView) findViewById(R.id.order_summary_share_button);
        this.mShareButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightOrderSummary.this.lambda$initUIForParentOrderSummary$5$FlightOrderSummary(view);
            }
        });
    }

    public /* synthetic */ void lambda$initUIForParentOrderSummary$3$FlightOrderSummary(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initUIForParentOrderSummary$4$FlightOrderSummary(View view) {
        performSupportClick();
    }

    public /* synthetic */ void lambda$initUIForParentOrderSummary$5$FlightOrderSummary(View view) {
        com.travel.flight.flightorder.d.a aVar = this.mFlightOrderSummaryFragment;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void performSupportClick() {
        com.travel.flight.flightorder.d.b bVar;
        if (AnonymousClass1.f24339a[this.mType.ordinal()] == 1 && (bVar = this.mActiveFragment) != null) {
            this.mOrderSummary = bVar.j();
            this.mCurrentState = this.mActiveFragment.m;
            this.mFlightOrderSummaryPresenter = new com.travel.flight.flightorder.h.a(this);
            this.CJRContactUsDialogHelper = new com.travel.flight.flightorder.e.b(this, this.mOrderSummary, this.mCurrentState, this);
            this.CJRContactUsDialogHelper.a();
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
        new CJRHomePageItem().setUrl(i.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        if (!TextUtils.isEmpty(this.mEntryPoint) && this.mEntryPoint.equalsIgnoreCase("Payment")) {
            intent.putExtra("Reset_fast_farward", true);
        }
        com.travel.flight.b.a();
        com.travel.flight.b.b().b(this, intent);
        finish();
    }

    private void startOrderSummaryFragment() {
        if (this.mType == null) {
            return;
        }
        if (AnonymousClass1.f24339a[this.mType.ordinal()] != 1) {
            showErrorMessage();
        } else {
            startFlightFragment();
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

    private void startFlightFragment() {
        if (this.mFlightOrderSummaryFragment == null) {
            this.mFlightOrderSummaryFragment = new com.travel.flight.flightorder.d.a();
            this.mFlightOrderSummaryFragment.f24354a = this;
        }
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (TextUtils.isEmpty(extras.getString("order_id", (String) null)) && !TextUtils.isEmpty(this.mOrderNo)) {
                extras.putString("order_id", this.mOrderNo);
            }
            extras.putSerializable("VERTICAL", this.mType);
            extras.putBoolean("isGAEvents", this.mIsGAEvents);
            if (TextUtils.isEmpty(this.mEntryPoint) || !this.mEntryPoint.equalsIgnoreCase("Payment")) {
                extras.putBoolean("isFromPayment", false);
            } else {
                extras.putBoolean("isFromPayment", true);
            }
            this.mFlightOrderSummaryFragment.setArguments(extras);
        }
        this.mActiveFragment = this.mFlightOrderSummaryFragment;
        getSupportFragmentManager().a().a(R.id.newOrderSummaryFrameLayout, (Fragment) this.mFlightOrderSummaryFragment).b();
    }

    public void showParentFlightOrderSummary(String str) {
        this.mFlightOrderSummaryFragment = new com.travel.flight.flightorder.d.a();
        this.mFlightOrderSummaryFragment.f24354a = this;
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            extras.putString("order_id", str);
            extras.putSerializable("VERTICAL", this.mType);
            extras.putBoolean("isGAEvents", this.mIsGAEvents);
            if (TextUtils.isEmpty(this.mEntryPoint) || !this.mEntryPoint.equalsIgnoreCase("Payment")) {
                extras.putBoolean("isFromPayment", false);
            } else {
                extras.putBoolean("isFromPayment", true);
            }
            this.mFlightOrderSummaryFragment.setArguments(extras);
        }
        this.mActiveFragment = this.mFlightOrderSummaryFragment;
        getSupportFragmentManager().a().a(R.id.newOrderSummaryFrameLayout, (Fragment) this.mFlightOrderSummaryFragment).b();
        initUIForParentOrderSummary(str);
    }

    public void showErrorMessage() {
        com.paytm.utility.b.b((Context) this, getString(R.string.error_dialog_title), getString(R.string.some_went_wrong));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mProgressDialog.cancel();
        }
        if (i3 != 0 && getActiveFragment() != null) {
            this.mActiveFragment.onActivityResult(i2, i3, intent);
        }
    }

    private Fragment getActiveFragment() {
        return this.mActiveFragment;
    }

    public void removeProgress() {
        this.mActiveFragment.k();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        com.travel.flight.flightorder.d.a aVar = this.mFlightOrderSummaryFragment;
        if (aVar != null) {
            aVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void showProgressDialog(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new ProgressDialog(context);
                try {
                    this.mProgressDialog.setProgressStyle(0);
                    this.mProgressDialog.setMessage(str);
                    this.mProgressDialog.setCancelable(false);
                    this.mProgressDialog.setCanceledOnTouchOutside(false);
                    this.mProgressDialog.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    public void hideProgress() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null || progressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }
}
