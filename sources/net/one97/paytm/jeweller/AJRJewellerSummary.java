package net.one97.paytm.jeweller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import java.util.Map;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.gold.CJRGoldTransaction;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldInitiate;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldStatusModel;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.m;
import net.one97.paytm.network.a;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;

public class AJRJewellerSummary extends BaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    Dialog f51026a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f51027b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f51028c;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f51029e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f51030f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f51031g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f51032h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f51033i;
    private CircularImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private CJRGoldInitiate r;
    private a s;
    private CJRGoldTransaction t;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private Handler y = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                AJRJewellerSummary.this.a();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gold_jeweller_summary);
        this.f51027b = (ImageView) findViewById(R.id.img_back);
        this.f51028c = (LottieAnimationView) findViewById(R.id.dot_progress_bar);
        this.f51029e = (ImageView) findViewById(R.id.top_success_view);
        this.f51030f = (TextView) findViewById(R.id.txt_gold_detailed_message);
        this.f51031g = (TextView) findViewById(R.id.txt_gold_merchant_message);
        this.f51032h = (TextView) findViewById(R.id.txt_gold_name);
        this.f51033i = (TextView) findViewById(R.id.txt_gold_display_amount);
        this.j = (CircularImageView) findViewById(R.id.merchant_logo_img);
        this.k = (TextView) findViewById(R.id.txt_gold_heading);
        this.l = (TextView) findViewById(R.id.txt_gold_date);
        this.m = (TextView) findViewById(R.id.txt_gold_order_id);
        this.q = (LinearLayout) findViewById(R.id.linear_bottom_view);
        this.n = (LinearLayout) findViewById(R.id.lin_view_passbook_root);
        this.o = (LinearLayout) findViewById(R.id.lin_view_need_help_root);
        this.p = (LinearLayout) findViewById(R.id.lin_view_check_status_root);
        this.f51027b.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        if (getIntent() != null) {
            this.r = (CJRGoldInitiate) getIntent().getSerializableExtra("intent_gold_initiate");
            a(this.r.getTransactions());
            if (!TextUtils.isEmpty(this.r.getLogoImage())) {
                try {
                    w.a().a(this.r.getLogoImage()).a(R.drawable.merchant_icon).b(R.drawable.merchant_icon).a((ImageView) this.j, (e) null);
                } catch (Exception unused) {
                }
            } else {
                this.j.setImageDrawable(b.a((Context) this, R.drawable.merchant_icon));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        LiveData<f> performRequestOrShowNetworkDialog = performRequestOrShowNetworkDialog(new a(this.r.getStatusCheckUrl(), new CJRGoldStatusModel(), (Map<String, String>) null, a.a(this)));
        if (performRequestOrShowNetworkDialog != null) {
            performRequestOrShowNetworkDialog.observeForever(new z() {
                public final void onChanged(Object obj) {
                    AJRJewellerSummary.this.a((f) obj);
                }
            });
        }
    }

    private void a(List<CJRGoldTransaction> list) {
        if (list != null && list.size() > 0) {
            this.t = list.get(0);
            if (this.t.getStatus().equalsIgnoreCase("ACCEPTED")) {
                d();
            } else if (this.t.getStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_EXPIRED) || this.t.getStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                c();
            } else {
                b();
            }
            i();
        }
    }

    private void b() {
        if (!this.x) {
            this.x = true;
            a("/digital_gold_offline/pending", "order_pending");
        }
        k();
        g();
    }

    private void c() {
        a("/digital_gold_offline/failed", "order_failed");
        e();
        f();
    }

    private void d() {
        a("/digital_gold_offline/success", "order_success");
        e();
        h();
    }

    private void a(String str, String str2) {
        a.a((Context) this, str);
        a.a(this, "/digital_gold_offline/pay_screen", "digital_gold_offline", str2, (String) null, this.t.getDstName(), com.paytm.utility.b.n((Context) this));
    }

    private void e() {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    private void f() {
        this.f51031g.setVisibility(8);
        this.q.setVisibility(8);
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.f51029e.setBackgroundResource(R.drawable.failed);
        this.k.setText(getString(R.string.train_payment_failed));
        this.k.setTextColor(getResources().getColor(R.color.color_fd5c5c));
        this.f51030f.setText(Html.fromHtml(getString(R.string.gold_jeweller_failed_message)));
        this.f51030f.setBackgroundColor(getResources().getColor(R.color.color_19fd5c5c));
    }

    private void g() {
        this.q.setVisibility(0);
        this.n.setVisibility(8);
        this.p.setVisibility(0);
        this.f51029e.setBackgroundResource(R.drawable.pending);
        this.k.setText(getString(R.string.gold_payment_process));
        this.k.setTextColor(getResources().getColor(R.color.color_ffa400));
        this.f51030f.setText(Html.fromHtml(getString(R.string.paytm_gold_summary_pending_msg)));
        this.f51030f.setBackgroundColor(getResources().getColor(R.color.color_fdfbd3));
        this.f51031g.setText(getString(R.string.gold_merchant_accpt_msg));
        this.f51031g.setBackgroundColor(getResources().getColor(R.color.transparent));
        if (!TextUtils.isEmpty(this.r.getMessage())) {
            this.f51031g.setText(this.r.getMessage());
        }
    }

    private void h() {
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.n.setVisibility(8);
        this.f51029e.setBackgroundResource(R.drawable.success);
        this.k.setText(getString(R.string.paid_successfully_to));
        this.k.setTextColor(getResources().getColor(R.color.color_222222));
        this.f51030f.setText(Html.fromHtml(a(com.paytm.utility.b.x(this.t.getPricePerGram()))));
        this.f51030f.setPadding(0, 0, 0, 0);
        this.f51030f.setBackgroundColor(getResources().getColor(R.color.transparent));
        this.f51031g.setText(Html.fromHtml(getString(R.string.gold_merchant_message_success, new Object[]{this.t.getTotalAmount()})));
        this.f51031g.setBackgroundColor(getResources().getColor(R.color.color_f3f7f8));
    }

    private String a(String str) {
        return "<b> " + this.t.getGrams() + " </b> grams of gold has been deducted from your Paytm Gold Locker based on Current Gold Price: ₹" + str + "/g. <br />Your updated balance is <b> " + this.t.getRemainingBalance() + " </b>g";
    }

    private void i() {
        this.f51032h.setText(this.t.getDstName());
        net.one97.paytm.wallet.utility.a.a(getString(R.string.rs) + " " + this.t.getTotalAmount(), this.f51033i);
        this.l.setText(net.one97.paytm.wallet.utility.a.c(this.t.getUpdatedAt(), "hh:mm a, dd MMM yyyy"));
        this.m.setText(getString(R.string.transaction_id) + ": " + this.t.getId());
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void j() {
        this.f51028c.setVisibility(8);
    }

    private void k() {
        if (!this.u) {
            this.u = true;
            this.y.sendEmptyMessageDelayed(1, 10000);
        } else if (!this.v) {
            this.v = true;
            this.y.sendEmptyMessageDelayed(1, 25000);
        } else if (!this.w) {
            this.w = true;
            this.y.sendEmptyMessageDelayed(1, 35000);
        } else {
            e();
        }
    }

    public void onDestroy() {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.img_back) {
            b("main");
        } else if (id == R.id.lin_view_need_help_root) {
            CJRGoldTransaction cJRGoldTransaction = this.t;
            if (cJRGoldTransaction != null) {
                cJRGoldTransaction.setResultValue("gold_pay");
                this.t.setVerticalId(83);
                this.t.setVerticalLabel("Gold");
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_deep_link", true);
            StringBuilder sb = new StringBuilder();
            sb.append(this.t.getVerticalId());
            bundle.putString("verticalId", sb.toString());
            bundle.putString("vertical", "vertical_detail");
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, this.t);
            net.one97.paytm.wallet.communicator.b.a().getCstOrderIssueIntent(this, bundle, new m() {
                public final void show() {
                    AJRJewellerSummary aJRJewellerSummary = AJRJewellerSummary.this;
                    try {
                        if (aJRJewellerSummary.f51026a == null) {
                            aJRJewellerSummary.f51026a = net.one97.paytm.wallet.utility.a.b((Activity) aJRJewellerSummary);
                        }
                        if (aJRJewellerSummary.f51026a != null && !aJRJewellerSummary.f51026a.isShowing()) {
                            aJRJewellerSummary.f51026a.show();
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                }

                public final void dismiss() {
                    AJRJewellerSummary aJRJewellerSummary = AJRJewellerSummary.this;
                    try {
                        if (aJRJewellerSummary.f51026a != null && aJRJewellerSummary.f51026a.isShowing()) {
                            aJRJewellerSummary.f51026a.dismiss();
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                }
            });
        } else if (id == R.id.lin_view_check_status_root) {
            a();
        }
    }

    public void onBackPressed() {
        try {
            b("main");
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    private void b(String str) {
        Intent intent = new Intent(this, net.one97.paytm.wallet.communicator.b.a().getMainActivityClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        if (!str.isEmpty()) {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
        } else {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        }
        intent.putExtra("started_activity_from_recharge", true);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRGoldStatusModel)) {
                a(((CJRGoldStatusModel) iJRPaytmDataModel).getTransactions());
            }
            j();
        } else if (fVar.f55796a == h.ERROR) {
            NetworkCustomError networkCustomError = fVar.f55798c.f55801c;
            try {
                j();
                a aVar = this.s;
                if (networkCustomError == null) {
                    return;
                }
                if (networkCustomError != null && networkCustomError.getAlertTitle() != null && networkCustomError.getAlertTitle().equalsIgnoreCase("Pincode Error")) {
                    com.paytm.utility.b.b(aVar.f51036a, networkCustomError.getAlertTitle(), aVar.f51036a.getResources().getString(R.string.gold_pincode_error_text));
                } else if (networkCustomError == null || networkCustomError.getAlertMessage() == null || !networkCustomError.getAlertMessage().contains("Please enter a valid promocode.")) {
                    if (!(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410)) {
                        if (networkCustomError.getStatusCode() != 403) {
                            if (networkCustomError.getMessage() != null) {
                                if (!net.one97.paytm.wallet.communicator.b.a().reportError(aVar.f51036a, networkCustomError, "error.gold@paytm.com")) {
                                    if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                        com.paytm.utility.b.b(aVar.f51036a, "utility_hide_title", aVar.f51036a.getResources().getString(R.string.message_error_data_display));
                                        return;
                                    } else if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                                        com.paytm.utility.b.b(aVar.f51036a, "utility_hide_title", networkCustomError.getAlertMessage());
                                        return;
                                    } else {
                                        com.paytm.utility.b.b(aVar.f51036a, "utility_hide_title", aVar.f51036a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                        return;
                                    }
                                }
                            }
                            String message = networkCustomError.getMessage();
                            if (message != null && message.equalsIgnoreCase("417")) {
                                com.paytm.utility.b.b(aVar.f51036a, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                                return;
                            } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                Context context = aVar.f51036a;
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.getStatusCode());
                                com.paytm.utility.b.d(context, url, sb.toString());
                                return;
                            } else if (networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) {
                                com.paytm.utility.b.b(aVar.f51036a, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                return;
                            } else if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                                com.paytm.utility.b.b(aVar.f51036a, "utility_hide_title", networkCustomError.getAlertMessage());
                                return;
                            } else {
                                com.paytm.utility.b.b(aVar.f51036a, aVar.f51036a.getResources().getString(R.string.network_error_heading), aVar.f51036a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                return;
                            }
                        }
                    }
                    net.one97.paytm.wallet.communicator.b.a().handleError((Activity) aVar.f51036a, networkCustomError, aVar.f51036a.getClass().getSimpleName(), (Bundle) null, false);
                } else {
                    com.paytm.utility.b.b(aVar.f51036a, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }
}
