package net.one97.paytm.paymentsBank.pdc.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.ManageDebitCardActivity;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.pdc.a;
import net.one97.paytm.paymentsBank.pdc.a.e;
import net.one97.paytm.paymentsBank.pdc.response.PDCStatusResponse;

public class PDCSuccessActivity extends PBBaseToolbarActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private String f18688b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f18689c;

    /* renamed from: d  reason: collision with root package name */
    private View f18690d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18691f;

    /* renamed from: g  reason: collision with root package name */
    private String f18692g;

    /* renamed from: h  reason: collision with root package name */
    private int f18693h = 0;

    /* renamed from: i  reason: collision with root package name */
    private View f18694i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18688b = getIntent().getStringExtra("order_id");
        this.f18692g = getIntent().getStringExtra("redirectTo");
        String stringExtra = getIntent().getStringExtra("extra_address");
        String stringExtra2 = getIntent().getStringExtra("extra_mobile");
        String stringExtra3 = getIntent().getStringExtra("extra_name");
        if (TextUtils.isEmpty(this.f18688b)) {
            finish();
            return;
        }
        this.f18694i = findViewById(R.id.pb_pending);
        this.f18690d = findViewById(R.id.scroll_view_parent);
        this.f18690d.setVisibility(4);
        findViewById(R.id.retry_payment_btn).setOnClickListener(this);
        findViewById(R.id.pdc_order_detail).setOnClickListener(this);
        this.f18689c = (LottieAnimationView) findViewById(R.id.pdc_success_failure_img);
        findViewById(R.id.lyt_promo_applied);
        this.f18691f = (TextView) findViewById(R.id.pdc_success_title_text);
        i();
        if (!TextUtils.isEmpty(stringExtra)) {
            q a2 = getSupportFragmentManager().a();
            e eVar = new e();
            Bundle bundle2 = new Bundle();
            bundle2.putString("extra_address", stringExtra);
            bundle2.putString("extra_mobile", stringExtra2);
            bundle2.putString("extra_name", stringExtra3);
            eVar.setArguments(bundle2);
            a2.b(R.id.address_container, eVar, e.class.getName());
            a2.c();
        }
        String stringExtra4 = getIntent().getStringExtra("pdc_price");
        if (!TextUtils.isEmpty(stringExtra4)) {
            if (stringExtra4.endsWith(".0") || stringExtra4.endsWith(".00")) {
                stringExtra4 = stringExtra4.substring(0, stringExtra4.indexOf(AppUtility.CENTER_DOT));
            }
            ((TextView) findViewById(R.id.pdc_success_amount_success)).setText(getString(R.string.pb_pdc_order_rupee, new Object[]{stringExtra4}));
            ((TextView) findViewById(R.id.pdc_success_total_order)).setText(getString(R.string.pb_pdc_order_rupee, new Object[]{stringExtra4}));
        }
        ((TextView) findViewById(R.id.pdc_success_order_id)).setText(String.format(getResources().getString(R.string.pdc_order_no), new Object[]{this.f18688b}));
        g();
    }

    private void g() {
        int i2 = this.f18693h;
        if (i2 > 3) {
            this.f18694i.setVisibility(8);
        } else if (i2 == 0) {
            j();
        } else {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    PDCSuccessActivity.this.j();
                }
            }, 3000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void j() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f c2 = a.c(this, this, this, this.f18688b, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (b.c((Context) this)) {
            this.f18694i.setVisibility(0);
            this.f18693h++;
            new c();
            c.a(c2);
            return;
        }
        this.f18694i.setVisibility(8);
        b(c2);
    }

    public void onBackPressed() {
        if (TextUtils.isEmpty(this.f18692g)) {
            super.onBackPressed();
        } else if (this.f18692g.equals("manageDebitCardPage")) {
            Intent intent = new Intent(this, ManageDebitCardActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("fromATMPinChangePage", 201);
            startActivity(intent);
            finish();
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        final int i2;
        super.onResponse(iJRPaytmDataModel);
        ah_();
        if (iJRPaytmDataModel instanceof PDCStatusResponse) {
            PDCStatusResponse pDCStatusResponse = (PDCStatusResponse) iJRPaytmDataModel;
            if (pDCStatusResponse == null) {
                g();
                return;
            }
            this.f18690d.setVisibility(0);
            if (pDCStatusResponse.getResponseCode().intValue() == 200) {
                this.f18694i.setVisibility(8);
                if (pDCStatusResponse.getPayload() != null) {
                    String status = pDCStatusResponse.getPayload().getStatus();
                    PDCStatusResponse.Payload payload = pDCStatusResponse.getPayload();
                    if (status.equalsIgnoreCase("SUCCESS")) {
                        Intent intent = new Intent(this, PDCOrderDetailActivity.class);
                        intent.putExtra("pdc_is_delivery_status_checking", false);
                        intent.putExtra("order_id", this.f18688b);
                        intent.putExtra("CUST_PRODUCT", getIntent().getSerializableExtra("CUST_PRODUCT"));
                        startActivity(intent);
                        finish();
                    } else if (status.equalsIgnoreCase("FAILURE")) {
                        this.f18689c.setVisibility(0);
                        findViewById(R.id.pending_msg_tv).setVisibility(8);
                        findViewById(R.id.address_container).setVisibility(8);
                        this.f18689c.setImageResource(R.drawable.pdc_failure_svg);
                        this.f18691f.setText(R.string.pb_pdc_order_failed);
                        findViewById(R.id.pdc_order_detail_layout).setVisibility(8);
                        findViewById(R.id.fragment_container).setVisibility(8);
                        findViewById(R.id.retry_payment_btn).setVisibility(0);
                    } else if (status.equalsIgnoreCase("PENDING")) {
                        i();
                        q a2 = getSupportFragmentManager().a();
                        a2.b(R.id.fragment_container, net.one97.paytm.paymentsBank.pdc.a.f.a(), net.one97.paytm.paymentsBank.pdc.a.f.class.getName());
                        a2.c();
                    }
                    String valueOf = String.valueOf(payload.getAmount());
                    if (valueOf.endsWith(".0") || valueOf.endsWith(".00")) {
                        valueOf = valueOf.substring(0, valueOf.indexOf(AppUtility.CENTER_DOT));
                    }
                    ((TextView) findViewById(R.id.pdc_success_amount_success)).setText(getString(R.string.pb_pdc_order_rupee, new Object[]{valueOf}));
                    ((TextView) findViewById(R.id.pdc_success_total_order)).setText(getString(R.string.pb_pdc_order_rupee, new Object[]{valueOf}));
                    ((TextView) findViewById(R.id.pdc_success_order_id)).setText(String.format(getResources().getString(R.string.pdc_order_no), new Object[]{this.f18688b}));
                    long created = payload.getCreated();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a, dd MMM yyyy", new Locale(n.a()));
                    simpleDateFormat.setTimeZone(TimeZone.getDefault());
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(created);
                    ((TextView) findViewById(R.id.pdc_success_time)).setText(simpleDateFormat.format(instance.getTime()));
                    this.f18694i.setVisibility(8);
                    if (status.equalsIgnoreCase("PENDING")) {
                        g();
                    }
                    Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                    if (Build.VERSION.SDK_INT > 21) {
                        Point point = new Point();
                        defaultDisplay.getSize(point);
                        i2 = point.y;
                    } else {
                        i2 = defaultDisplay.getHeight();
                    }
                    final View findViewById = findViewById(R.id.paytm_strip);
                    findViewById.setVisibility(0);
                    findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            if (findViewById.getTop() < i2 - findViewById.getHeight()) {
                                if (((float) (i2 - findViewById.getHeight())) > ((float) net.one97.paytm.bankCommon.mapping.a.a(55.0f, (Context) PDCSuccessActivity.this))) {
                                    View view = findViewById;
                                    view.setPadding(0, (i2 - view.getBottom()) - net.one97.paytm.bankCommon.mapping.a.a(55.0f, (Context) PDCSuccessActivity.this), 0, 0);
                                }
                            }
                        }
                    });
                    return;
                }
                this.f18690d.setVisibility(8);
                b.b((Context) this, getString(R.string.error), pDCStatusResponse.getResponseMessage());
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        g();
    }

    public final int e() {
        return R.layout.pdc_success;
    }

    public final int f() {
        return R.layout.item_toolbar_normal_layout;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pdc_order_detail) {
            Intent intent = new Intent(this, PDCOrderDetailActivity.class);
            intent.putExtra("pdc_is_delivery_status_checking", false);
            intent.putExtra("order_id", this.f18688b);
            intent.putExtra("CUST_PRODUCT", getIntent().getSerializableExtra("CUST_PRODUCT"));
            startActivity(intent);
        } else if (id == R.id.retry_payment_btn) {
            Intent intent2 = new Intent(this, ManageDebitCardActivity.class);
            intent2.setFlags(603979776);
            intent2.putExtra("fromATMPinChangePage", KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
            startActivity(intent2);
            finish();
        }
    }

    private void i() {
        this.f18690d.setVisibility(0);
        findViewById(R.id.pending_msg_tv).setVisibility(0);
        this.f18689c.setImageResource(R.drawable.pdc_pending_svg);
        findViewById(R.id.pdc_order_detail_layout).setVisibility(8);
        this.f18691f.setText(R.string.pb_pdc_order_pending);
        findViewById(R.id.retry_payment_btn).setVisibility(0);
        findViewById(R.id.fragment_container).setVisibility(0);
    }
}
