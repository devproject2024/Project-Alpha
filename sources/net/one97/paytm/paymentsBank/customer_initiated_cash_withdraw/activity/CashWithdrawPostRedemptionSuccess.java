package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.core.content.b;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.utils.f;
import net.one97.paytm.paymentsBank.utils.i;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;

public class CashWithdrawPostRedemptionSuccess extends PBBaseActivity implements View.OnClickListener, g.a, g.b<IJRPaytmDataModel> {
    private ImageView A;
    private Runnable B = new Runnable() {
        public final void run() {
            CashWithdrawPostRedemptionSuccess.this.f();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    String f18270b;

    /* renamed from: c  reason: collision with root package name */
    double f18271c;

    /* renamed from: d  reason: collision with root package name */
    TextView f18272d;

    /* renamed from: e  reason: collision with root package name */
    TextView f18273e;

    /* renamed from: f  reason: collision with root package name */
    TextView f18274f;

    /* renamed from: g  reason: collision with root package name */
    CircularImageView f18275g;

    /* renamed from: h  reason: collision with root package name */
    private String f18276h;

    /* renamed from: i  reason: collision with root package name */
    private View f18277i;
    private String j;
    private TextView k;
    private TextView l;
    private String m = "";
    private CustProductList n;
    private View o;
    private TextView p;
    private ImageView q;
    private TextView r;
    private boolean s;
    private String t;
    private TextView u;
    private ImageView v;
    private String w;
    private TextView x;
    private View y;
    private String z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_post_transaction_cash_withdraw);
        this.f18270b = getIntent().getStringExtra("amount");
        this.f18271c = getIntent().getDoubleExtra("effectivebalance", 0.0d);
        this.f18276h = getIntent().getStringExtra("name");
        this.j = getIntent().getStringExtra("status");
        if (getIntent().hasExtra("orderId")) {
            this.m = getIntent().getStringExtra("orderId");
            this.w = getIntent().getStringExtra("orderDate");
        }
        this.s = getIntent().getBooleanExtra("isbankbranch", false);
        this.f18272d = (TextView) findViewById(R.id.tv_amnt);
        this.f18272d.setText(getString(R.string.rs_str, new Object[]{a.ac(this.f18270b)}));
        this.f18273e = (TextView) findViewById(R.id.tv_updated_saving_account);
        this.f18274f = (TextView) findViewById(R.id.tv_amount_in_rupees);
        this.o = findViewById(R.id.ll_cash_heading_wrapper);
        this.p = (TextView) findViewById(R.id.top_title_tv);
        this.q = (ImageView) findViewById(R.id.top_icon_iv);
        this.u = (TextView) findViewById(R.id.titleTv);
        this.v = (ImageView) findViewById(R.id.success_icon_iv);
        this.y = findViewById(R.id.rl_share_wrapper);
        this.A = (ImageView) findViewById(R.id.iv_back_arrow);
        this.A.setOnClickListener(this);
        this.y.setOnClickListener(this);
        TextView textView = this.f18274f;
        textView.setText(getString(R.string.pb_fd_rupees) + " " + i.a(this.f18270b) + " Only");
        this.f18275g = (CircularImageView) findViewById(R.id.paytm_circular);
        this.f18277i = findViewById(R.id.success_from_lyt);
        this.k = (TextView) findViewById(R.id.tv_paytm_payments_bank);
        this.l = (TextView) findViewById(R.id.transaction_id);
        this.x = (TextView) findViewById(R.id.tv_date);
        this.r = (TextView) findViewById(R.id.retry_button);
        findViewById(R.id.ll_generate_qr).setOnClickListener(this);
        findViewById(R.id.ll_view_passbook).setOnClickListener(this);
        findViewById(R.id.ll_generate_qr).setOnClickListener(this);
        findViewById(R.id.ll_view_help).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CashWithdrawPostRedemptionSuccess.this.a(view);
            }
        });
        if (!v.a(this.m)) {
            TextView textView2 = this.l;
            textView2.setText(getString(R.string.pb_transaction_id) + " " + this.m);
        } else {
            this.l.setVisibility(8);
        }
        if (!v.a(this.w)) {
            String a2 = a(this.w);
            if (!v.a(a2)) {
                this.x.setText(a2);
                this.x.setVisibility(0);
            }
        } else {
            this.x.setVisibility(8);
        }
        if (this.j.equalsIgnoreCase("SUCCESS")) {
            this.u.setText(getString(R.string.pb_cw_success_msg));
            this.f18277i.setVisibility(0);
            this.k.setText(getString(R.string.paytm_payments_bank));
            this.o.setBackgroundColor(Color.parseColor("#21c17a"));
            this.q.setImageDrawable(b.a((Context) this, R.drawable.cash_withdraw_success));
            this.p.setText(R.string.pb_cw_confirm);
            w.a().a(R.drawable.pb_ic_paytm_logo).a((ah) new f()).a((ImageView) this.f18275g, (e) new e() {
                public final void onError(Exception exc) {
                }

                public final void onSuccess() {
                    ViewGroup.LayoutParams layoutParams = CashWithdrawPostRedemptionSuccess.this.f18275g.getLayoutParams();
                    layoutParams.height -= 10;
                    layoutParams.width -= 10;
                    CashWithdrawPostRedemptionSuccess.this.f18275g.setLayoutParams(layoutParams);
                }
            });
            this.v.setVisibility(0);
            this.r.setVisibility(8);
        } else {
            this.u.setText(getString(R.string.pb_cw_failure_msg));
            this.o.setBackgroundColor(Color.parseColor("#ff585d"));
            this.q.setImageDrawable(b.a((Context) this, R.drawable.cash_withdraw_ic_failed));
            this.p.setText(R.string.pb_cw_declined);
            this.f18277i.setVisibility(8);
            this.r.setVisibility(0);
            this.r.setOnClickListener(this);
            this.v.setVisibility(8);
        }
        if (com.paytm.utility.b.c((Context) this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a3 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new c();
            c.a(a3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    private static String a(String str) {
        new SimpleDateFormat();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            return new SimpleDateFormat("hh:mm aa, dd MMM yyyy").format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.retry_button) {
            Intent intent = new Intent(this, CashWithdrawnActivity.class);
            intent.putExtra("slfd_meta_response", new SlfdMetaApiResponseModel());
            intent.putExtra("name", this.f18276h);
            intent.putExtra("isbankbranch", this.s);
            startActivity(intent);
            finish();
        } else if (id == R.id.ll_view_help) {
            o.a().openHelpAndSupport(this, true);
            finish();
        } else if (id == R.id.ll_view_passbook) {
            if (!TextUtils.isEmpty(this.t)) {
                o.a().openInnerSavingAccPasscodeActivity(this, this.t, this.n.getIsaAccNum(), this.z, j.a());
                finish();
                return;
            }
            Toast.makeText(this, getString(R.string.please_wait), 0).show();
        } else if (id == R.id.ll_generate_qr) {
            Intent intent2 = new Intent(this, CashWithdrawnActivity.class);
            intent2.putExtra("slfd_meta_response", new SlfdMetaApiResponseModel());
            intent2.putExtra("name", this.f18276h);
            intent2.putExtra("isbankbranch", this.s);
            startActivity(intent2);
            finish();
        } else if (id == R.id.rl_share_wrapper) {
            if (!s.a()) {
                e();
            } else if (s.c((Activity) this)) {
                e();
            } else {
                s.b((Activity) this);
            }
        } else if (id == R.id.iv_back_arrow) {
            finish();
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        PBCJRAccountSummary pBCJRAccountSummary;
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.n = (CustProductList) iJRPaytmDataModel;
            TextView textView = this.k;
            textView.setText(getString(R.string.paytm_payments_bank) + " XX " + this.n.getIsaAccNum().substring(this.n.getIsaAccNum().length() - 4));
            String isaAccNum = this.n.getIsaAccNum();
            if (com.paytm.utility.b.c((Context) this)) {
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankCommon.g.f c2 = net.one97.paytm.paymentsBank.b.a.c((Context) this, isaAccNum, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
                getApplicationContext();
                new c();
                c.a(c2);
            }
        } else if ((iJRPaytmDataModel instanceof PBCJRAccountSummary) && (pBCJRAccountSummary = (PBCJRAccountSummary) iJRPaytmDataModel) != null && pBCJRAccountSummary.getStatus() != null && pBCJRAccountSummary.getStatus().equalsIgnoreCase("success") && pBCJRAccountSummary.getAccounts() != null && pBCJRAccountSummary.getAccounts().size() > 0) {
            pBCJRAccountSummary.getAccounts().get(0).getEffectiveBalance();
            StringBuilder sb = new StringBuilder();
            sb.append(pBCJRAccountSummary.getAccounts().get(0).getEffectiveBalance());
            this.t = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(pBCJRAccountSummary.getAccounts().get(0).getTotalBalance());
            this.z = sb2.toString();
            TextView textView2 = this.f18273e;
            textView2.setText(getString(R.string.pb_updated_sa_bal) + AppConstants.COLON + String.format(getString(R.string.rupee), new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(this.t)}));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.pb_cw_paytm_karo));
            intent.putExtra("android.intent.extra.TEXT", net.one97.paytm.bankCommon.mapping.a.ac(this.f18270b) + " Withdrawn");
            View findViewById = findViewById(R.id.nsv_main_content);
            int visibility = this.y.getVisibility();
            this.y.setVisibility(8);
            Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
            findViewById.draw(new Canvas(createBitmap));
            this.y.setVisibility(visibility);
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.pb_cw_share_transaction));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.pb_cw_no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            e();
        } else if (androidx.core.app.a.a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Toast.makeText(this, "Storage permission is required to share the screen.", 0).show();
        } else {
            try {
                c.a aVar = new c.a(this);
                aVar.b((CharSequence) getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                aVar.a((CharSequence) getResources().getString(R.string.action_settings), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        CashWithdrawPostRedemptionSuccess.this.b(dialogInterface, i2);
                    }
                });
                aVar.b((CharSequence) getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) $$Lambda$CashWithdrawPostRedemptionSuccess$sDLjPWJFJi7j3gXlPAFeisGITI.INSTANCE);
                aVar.b();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void e() {
        this.B.run();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        s.b((Context) this);
    }
}
