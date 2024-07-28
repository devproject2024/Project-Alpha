package net.one97.paytm.passbook.subWallet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.squareup.picasso.w;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRMerchantTransactionDetail;
import net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.j;
import org.json.JSONException;
import org.json.JSONObject;

public class MerchantPaymentDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f58748a;

    /* renamed from: b  reason: collision with root package name */
    private String f58749b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f58750c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f58751d;

    /* renamed from: e  reason: collision with root package name */
    private CJRMerchantpaymentTransaction.Transaction f58752e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f58753f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58754g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f58755h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58756i;
    private TextView j;
    private CJRMerchantTransactionDetail k;
    private LinearLayout l;
    private TextView m;
    private ImageView n;
    private View o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_merchant_payment_detail);
        this.f58752e = (CJRMerchantpaymentTransaction.Transaction) getIntent().getSerializableExtra("passbook_transaction_detail_data");
        this.f58749b = getIntent().getStringExtra("walletTransactiontype");
        this.f58748a = this.f58752e.txnId;
        this.t = (LinearLayout) findViewById(R.id.parent_layout);
        this.n = (ImageView) findViewById(R.id.status_icon);
        this.f58750c = (RelativeLayout) findViewById(R.id.loader_contianer);
        this.f58751d = (LottieAnimationView) findViewById(R.id.loader);
        this.f58753f = (TextView) findViewById(R.id.amount_tv);
        this.f58754g = (TextView) findViewById(R.id.date_time_tv);
        this.f58755h = (ImageView) findViewById(R.id.sent_to_pic_imv);
        this.f58756i = (TextView) findViewById(R.id.merchant_name_tv);
        this.j = (TextView) findViewById(R.id.orderid_tv);
        this.m = (TextView) findViewById(R.id.status_tv);
        this.o = findViewById(R.id.seprator_view);
        this.q = (TextView) findViewById(R.id.txnidtype_tv);
        this.p = (TextView) findViewById(R.id.txnid_tv);
        this.r = (TextView) findViewById(R.id.to_title_tv);
        this.s = (TextView) findViewById(R.id.from_title_tv);
        this.l = (LinearLayout) findViewById(R.id.transaction_details_layout);
        a();
        if ("SUCCESS".equalsIgnoreCase(this.f58752e.txnStatus)) {
            e.a();
            String n2 = e.n();
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", a.q(this));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("searchType", this.f58749b);
                jSONObject.put("txnId", this.f58748a);
            } catch (JSONException unused) {
            }
            b bVar = new b(n2, new i.a() {
                public final void onResponse(Object obj) {
                    MerchantPaymentDetailActivity.this.a((IJRDataModel) obj);
                }
            }, new g() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    MerchantPaymentDetailActivity.a(MerchantPaymentDetailActivity.this, (Throwable) networkCustomError);
                }
            }, new CJRMerchantTransactionDetail(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, MerchantPaymentDetailActivity.class.getName());
            if (com.paytm.utility.b.c((Context) this)) {
                b();
                c.a();
                c.b(bVar);
            } else {
                a(bVar, this, new DialogInterface.OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        MerchantPaymentDetailActivity.this.a(dialogInterface);
                    }
                });
            }
        } else {
            this.o.setVisibility(8);
        }
        findViewById(R.id.back_arrow_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MerchantPaymentDetailActivity.this.b(view);
            }
        });
        findViewById(R.id.share_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MerchantPaymentDetailActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        LinearLayout linearLayout = this.t;
        if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", "");
                Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
                linearLayout.draw(new Canvas(createBitmap));
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
        } else {
            s.b((Activity) this);
            Toast.makeText(this, getString(R.string.permission_not_granted), 0).show();
        }
    }

    private void a() {
        this.s.setVisibility(8);
        int i2 = R.drawable.pass_default_debit;
        if ("TRANSACTION".equalsIgnoreCase(this.f58752e.txnType)) {
            if ("SUCCESS".equalsIgnoreCase(this.f58752e.txnStatus)) {
                this.m.setText(R.string.paid_scs);
                this.n.setImageResource(R.drawable.pass_ic_tick);
                this.s.setVisibility(0);
            } else if ("PENDING".equalsIgnoreCase(this.f58752e.txnStatus)) {
                this.m.setText(R.string.payment_pending);
                this.n.setImageResource(R.drawable.pass_ic_pending_copy);
            } else {
                this.m.setText(R.string.payment_failed_wallet);
                this.n.setImageResource(R.drawable.pass_ic_failed_copy);
            }
            this.s.setText(R.string.paid_from);
            this.r.setText(R.string.paid_at1);
            i2 = R.drawable.pass_default_debit;
        } else if ("REFUND".equalsIgnoreCase(this.f58752e.txnType)) {
            if ("SUCCESS".equalsIgnoreCase(this.f58752e.txnStatus)) {
                this.m.setText(R.string.refunded_successful);
                this.n.setImageResource(R.drawable.pass_ic_tick);
                this.s.setVisibility(0);
            } else if ("PENDING".equalsIgnoreCase(this.f58752e.txnStatus)) {
                this.m.setText(R.string.refund_pending);
                this.n.setImageResource(R.drawable.pass_ic_pending_copy);
            } else {
                this.m.setText(R.string.refund_failed);
                this.n.setImageResource(R.drawable.pass_ic_failed_copy);
            }
            this.r.setText(R.string.refunded_by);
            this.s.setText(R.string.refunded_to);
            i2 = R.drawable.pass_default_credit;
        }
        net.one97.paytm.passbook.mapping.c.b(com.paytm.utility.b.x(this.f58752e.txnAmt), this.f58753f);
        this.f58754g.setText(b(this.f58752e.txnDate));
        if (!v.a(this.f58752e.merchantLogo)) {
            w.a().a(this.f58752e.merchantLogo).a(i2).b(i2).a(this.f58755h, (com.squareup.picasso.e) null);
        } else {
            this.f58755h.setImageResource(i2);
        }
        this.f58756i.setText(this.f58752e.merchantDisplayName);
        String str = this.f58752e.orderId;
        if (str.length() > 8) {
            str = str.substring(0, str.length() - 8) + " " + str.substring(str.length() - 8);
        }
        d.b().a(String.format(getString(R.string.order_id_with_value_and_colon), new Object[]{str}), this.j);
        CJRMerchantTransactionDetail cJRMerchantTransactionDetail = this.k;
        if (cJRMerchantTransactionDetail != null && cJRMerchantTransactionDetail.detail != null && this.k.detail.transactions != null) {
            if ("SUCCESS".equalsIgnoreCase(this.f58752e.txnStatus)) {
                ArrayList<CJRMerchantTransactionDetail.Transactions> arrayList = this.k.detail.transactions;
                if (arrayList.size() == 1) {
                    a(true, arrayList.get(0));
                } else {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (i3 > 0) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.height = com.paytm.utility.b.c(15);
                            View view = new View(this);
                            view.setLayoutParams(layoutParams);
                            this.l.addView(view);
                        }
                        a(false, arrayList.get(i3));
                    }
                }
            } else {
                this.o.setVisibility(8);
            }
            this.p.setText(this.f58752e.txnId);
            this.q.setText(R.string.transaction_id_success);
        }
    }

    private void a(boolean z, CJRMerchantTransactionDetail.Transactions transactions) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.pass_merchant_transaction_detail_item, (ViewGroup) null);
        this.l.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.transaction_type_subtitle_tv);
        ((TextView) inflate.findViewById(R.id.transaction_type_name_tv)).setText(transactions.payMethod);
        textView.setVisibility(0);
        if (!v.a(transactions.maskedCardNo)) {
            textView.setText(transactions.maskedCardNo);
        } else if (!v.a(transactions.bankAccountNo)) {
            textView.setText(transactions.bankAccountNo);
        } else {
            textView.setVisibility(8);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.amount_tv);
        if (z) {
            textView2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setImageResource(a(transactions.payMethod));
            return;
        }
        imageView.setVisibility(8);
        textView2.setVisibility(0);
        try {
            textView2.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.x(transactions.txnAmt)}));
        } catch (NumberFormatException unused) {
            textView2.setText(String.format(getString(R.string.rupee), new Object[]{transactions.txnAmt}));
        }
    }

    private static int a(String str) {
        if ("Paytm Wallet".equalsIgnoreCase(str)) {
            return R.drawable.pass_ic_wallet;
        }
        if ("Net Banking".equalsIgnoreCase(str)) {
            return R.drawable.pass_ic_ppb;
        }
        if ("Credit Card".equalsIgnoreCase(str) || "Debit Card".equalsIgnoreCase(str)) {
            return R.drawable.pass_credit_debit_card_icon;
        }
        if ("BHIM UPI".equalsIgnoreCase(str)) {
            return R.drawable.pass_ic_bhim_upi1;
        }
        return R.drawable.pass_ic_wallet;
    }

    private static String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRMerchantTransactionDetail) {
            CJRMerchantTransactionDetail cJRMerchantTransactionDetail = (CJRMerchantTransactionDetail) iJRDataModel;
            if (!isFinishing()) {
                this.k = cJRMerchantTransactionDetail;
                c();
                a();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        c();
        if (!isFinishing()) {
            finish();
        }
    }

    private void a(net.one97.paytm.passbook.mapping.a.e eVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(context, eVar, onCancelListener) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f$2;
            private final /* synthetic */ DialogInterface.OnCancelListener f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                MerchantPaymentDetailActivity.this.a(this.f$1, this.f$2, this.f$3, dialogInterface, i2);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, net.one97.paytm.passbook.mapping.a.e eVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        c();
        b();
        if (com.paytm.utility.b.c(context)) {
            context.getApplicationContext();
            c.a();
            c.b(eVar);
            return;
        }
        a(eVar, context, onCancelListener);
    }

    private void b() {
        this.f58750c.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.f58751d);
    }

    private void c() {
        this.f58750c.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.f58751d);
    }

    static /* synthetic */ void a(MerchantPaymentDetailActivity merchantPaymentDetailActivity, Throwable th) {
        merchantPaymentDetailActivity.c();
        MerchantPaymentDetailActivity.class.getSimpleName();
        j.a((Activity) merchantPaymentDetailActivity, th);
    }
}
