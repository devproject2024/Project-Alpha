package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiRequestMoneyStatusActivity extends PaytmActivity {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private boolean L = false;

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f69325a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f69326b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f69327c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f69328d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f69329e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f69330f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f69331g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f69332h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f69333i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private LinearLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private boolean y;
    private HashMap<String, View> z = new HashMap<>();

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_request_money_status);
        UpiUtils.setStatusBarColor(R.color.app_theme_color, this);
        this.y = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_SUCCESS, false);
        this.A = getIntent().getStringExtra(UpiConstants.EXTRA_RESPONSE_CODE);
        this.B = getIntent().getStringExtra("message");
        this.C = getIntent().getStringExtra(UpiConstants.EXTRA_RRN);
        this.D = getIntent().getStringExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID);
        this.E = getIntent().getStringExtra("seq_no");
        this.F = getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        this.G = getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_NAME);
        this.H = getIntent().getStringExtra("amount");
        this.I = getIntent().getStringExtra(UpiConstants.EXTRA_OPTIONAL_DESC);
        this.J = getIntent().getStringExtra(UpiConstants.EXTRA_EXPIRY_TIME);
        this.K = getIntent().getStringExtra(UpiConstants.EXTRA_EXPIRY_TIME_HINT);
        i.a().m.a((LinearLayout) findViewById(R.id.parent_layout_bottom));
        this.f69325a = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.f69325a);
        this.f69326b = (ImageView) findViewById(R.id.iv_share);
        this.f69326b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyStatusActivity.a(UpiRequestMoneyStatusActivity.this);
            }
        });
        this.f69327c = (ImageView) findViewById(R.id.iv_status);
        this.f69328d = (TextView) findViewById(R.id.tv_status_header);
        this.f69329e = (TextView) findViewById(R.id.tv_amount);
        this.f69330f = (TextView) findViewById(R.id.tv_payer_name);
        this.f69331g = (TextView) findViewById(R.id.tv_payer_vpa);
        this.o = (TextView) findViewById(R.id.tv_note);
        this.j = (TextView) findViewById(R.id.tv_date);
        this.s = (LinearLayout) findViewById(R.id.i_options);
        this.k = (TextView) findViewById(R.id.updated_balance_value);
        this.m = (TextView) findViewById(R.id.logout);
        this.l = (TextView) findViewById(R.id.av_balance_label);
        this.n = (TextView) findViewById(R.id.tv_failure_msg);
        this.p = (TextView) findViewById(R.id.tv_expiry_value);
        this.f69332h = (TextView) findViewById(R.id.tv_request_expires);
        this.q = (TextView) findViewById(R.id.tv_txn_id);
        this.t = (RelativeLayout) findViewById(R.id.add_money_view);
        this.u = (RelativeLayout) findViewById(R.id.passbook_view);
        this.v = (RelativeLayout) findViewById(R.id.contact_us_view);
        this.f69333i = (TextView) findViewById(R.id.contact_us_new_layout);
        this.r = (TextView) findViewById(R.id.pass_book_layout);
        this.w = (RelativeLayout) findViewById(R.id.rl_content);
        this.x = (RelativeLayout) findViewById(R.id.rv_vpa_details);
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(UpiRequestMoneyStatusActivity.this, UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, "getpendingrequests");
                UpiRequestMoneyStatusActivity.this.startActivity(intent);
                UpiRequestMoneyStatusActivity.this.finish();
            }
        });
        if (this.L) {
            this.f69328d.setText("Upi Mandate Created");
            ((TextView) findViewById(R.id.tv_status)).setText("Status: PENDING");
        }
        this.r.setText(R.string.upi_view_transactions);
        UpiAppUtils.updateAmount(String.format(getString(R.string.rs_str), new Object[]{UpiAppUtils.priceToString(this.H)}), this.f69329e);
        this.u.setVisibility(0);
        this.t.setVisibility(8);
        this.m.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.f69330f.setText(this.G);
        this.f69331g.setText(this.F);
        this.j.setText(UpiUtils.getCurrentDateAndTime());
        this.f69332h.setText(getString(R.string.upi_expires_in_label));
        if (!TextUtils.isEmpty(this.J)) {
            TextView textView = this.p;
            textView.setText(this.J + getString(R.string.upi_minutes_label));
        }
        this.q.setText(this.C);
        if (!TextUtils.isEmpty(this.I)) {
            TextView textView2 = this.o;
            textView2.setText("\"" + this.I + "\"");
        } else {
            this.o.setVisibility(8);
        }
        if (this.L) {
            return;
        }
        if (this.A.equalsIgnoreCase("0")) {
            this.n.setVisibility(8);
            this.f69327c.setBackground(b.a((Context) this, R.drawable.payment_done_00048));
            this.f69328d.setText(getString(R.string.upi_request_money_success));
            UpiUtils.sendReloadPassbookUpiBroadcast(this, false, true);
        } else if (this.A.equalsIgnoreCase("92")) {
            this.n.setVisibility(0);
            this.n.setText(this.B);
            this.f69327c.setBackground(b.a((Context) this, R.drawable.payment_done_00048));
            this.f69328d.setText(getString(R.string.upi_request_money_pending));
            UpiUtils.sendReloadPassbookUpiBroadcast(this, false, true);
        } else {
            this.n.setVisibility(0);
            this.n.setText(this.B);
            this.f69327c.setBackground(b.a((Context) this, R.drawable.failure_add_money));
            this.f69328d.setText(getString(R.string.upi_request_money_failed));
        }
    }

    private void a() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.w.getWidth(), this.w.getHeight(), Bitmap.Config.ARGB_8888);
            this.w.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.post_payment_share_title));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 48) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                CustomDialog.showAlert(this, "", "Please go to Settings and give Paytm app Storage permission.");
            } else {
                a();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    static /* synthetic */ void a(UpiRequestMoneyStatusActivity upiRequestMoneyStatusActivity) {
        if (Build.VERSION.SDK_INT < 23 || b.a((Context) upiRequestMoneyStatusActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            upiRequestMoneyStatusActivity.a();
        } else {
            upiRequestMoneyStatusActivity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 48);
        }
    }
}
