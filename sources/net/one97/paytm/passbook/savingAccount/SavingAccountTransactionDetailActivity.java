package net.one97.paytm.passbook.savingAccount;

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
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.s;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRReplacementReason;
import net.one97.paytm.passbook.beans.SavingAccountDetailDataModel;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.beans.Transaction;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.savingAccount.a.b.a;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public class SavingAccountTransactionDetailActivity extends BaseActivity implements View.OnClickListener, a {
    private Transaction A;
    private SavingAccountDetailDataModel B;

    /* renamed from: a  reason: collision with root package name */
    Button f58243a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f58244b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.passbook.savingAccount.a.a.a f58245c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.passbook.savingAccount.a.a f58246d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f58247e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f58248f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58249g;

    /* renamed from: h  reason: collision with root package name */
    private CircularImageView f58250h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58251i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ProgressBar m;
    private Toolbar n;
    private TextView o;
    private TextView p;
    private TextView q;
    private LinearLayout r;
    private LinearLayout s;
    /* access modifiers changed from: private */
    public String t = "";
    private String u;
    private String v;
    private String w;
    private String x;
    private IJRDataModel y;
    /* access modifiers changed from: private */
    public RelativeLayout z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_passbook_saving_act_detail);
        this.f58245c = new net.one97.paytm.passbook.savingAccount.a.a.a(this);
        this.f58246d = new net.one97.paytm.passbook.savingAccount.a.a(this.f58245c, this);
        this.n = (Toolbar) findViewById(R.id.actionbar);
        this.o = (TextView) this.n.findViewById(R.id.header);
        this.f58244b = (ImageView) this.n.findViewById(R.id.share);
        this.o.setText(R.string.passbook);
        ((ImageView) this.n.findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SavingAccountTransactionDetailActivity.this.finish();
            }
        });
        this.f58244b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                q.a(view.getContext(), "passbook_ppb", "ppb_passbook_share_clicked", (ArrayList<String>) null, "/passbook/ppb/txn-detail");
                SavingAccountTransactionDetailActivity savingAccountTransactionDetailActivity = SavingAccountTransactionDetailActivity.this;
                String unused = savingAccountTransactionDetailActivity.t = savingAccountTransactionDetailActivity.t == null ? "" : SavingAccountTransactionDetailActivity.this.t;
                SavingAccountTransactionDetailActivity savingAccountTransactionDetailActivity2 = SavingAccountTransactionDetailActivity.this;
                String a2 = savingAccountTransactionDetailActivity2.t;
                RelativeLayout b2 = SavingAccountTransactionDetailActivity.this.z;
                if (Build.VERSION.SDK_INT < 23 || !s.a() || savingAccountTransactionDetailActivity2 == null || savingAccountTransactionDetailActivity2.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("image/png");
                        intent.putExtra("android.intent.extra.SUBJECT", savingAccountTransactionDetailActivity2.getString(R.string.post_payment_share_subject));
                        intent.putExtra("android.intent.extra.TEXT", a2);
                        int visibility = savingAccountTransactionDetailActivity2.f58243a.getVisibility();
                        int visibility2 = savingAccountTransactionDetailActivity2.f58244b.getVisibility();
                        savingAccountTransactionDetailActivity2.f58243a.setVisibility(8);
                        savingAccountTransactionDetailActivity2.f58244b.setVisibility(8);
                        Bitmap createBitmap = Bitmap.createBitmap(b2.getWidth(), b2.getHeight(), Bitmap.Config.ARGB_8888);
                        b2.draw(new Canvas(createBitmap));
                        savingAccountTransactionDetailActivity2.f58243a.setVisibility(visibility);
                        savingAccountTransactionDetailActivity2.f58244b.setVisibility(visibility2);
                        String insertImage = MediaStore.Images.Media.insertImage(savingAccountTransactionDetailActivity2.getContentResolver(), createBitmap, savingAccountTransactionDetailActivity2.getString(R.string.title), (String) null);
                        if (insertImage != null) {
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                            Intent createChooser = Intent.createChooser(intent, savingAccountTransactionDetailActivity2.getString(R.string.post_payment_share_title));
                            if (createChooser.resolveActivity(savingAccountTransactionDetailActivity2.getPackageManager()) != null) {
                                savingAccountTransactionDetailActivity2.startActivity(createChooser);
                            } else {
                                Toast.makeText(savingAccountTransactionDetailActivity2, savingAccountTransactionDetailActivity2.getString(R.string.no_app_found), 1).show();
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } else {
                    s.b((Activity) savingAccountTransactionDetailActivity2);
                    Toast.makeText(savingAccountTransactionDetailActivity2, savingAccountTransactionDetailActivity2.getString(R.string.permission_not_granted), 0).show();
                }
            }
        });
        this.f58247e = (ImageView) findViewById(R.id.success_symbol_iv);
        this.f58248f = (TextView) findViewById(R.id.amount_sa_psbk_dtl);
        this.f58249g = (TextView) findViewById(R.id.narration_sa_psbk_dtl);
        this.f58250h = (CircularImageView) findViewById(R.id.txn_type_icon_psbk_dtl);
        this.f58251i = (TextView) findViewById(R.id.txn_heading_sa_psbk_dtl);
        this.p = (TextView) findViewById(R.id.txnDescription2_sa_psbk_dtl);
        this.q = (TextView) findViewById(R.id.txn_heading_sa_psbk_txndesc6);
        this.l = (TextView) findViewById(R.id.txn_date_sa_psbk_dtl);
        this.k = (TextView) findViewById(R.id.txn_heading_sa_psbk_txndesc2);
        this.j = (TextView) findViewById(R.id.txnDescription1_sa_psbk_dtl);
        this.f58243a = (Button) findViewById(R.id.need_help_psbk_dtl);
        this.m = (ProgressBar) findViewById(R.id.progress);
        this.r = (LinearLayout) findViewById(R.id.detail_parent_LL);
        this.z = (RelativeLayout) findViewById(R.id.passbook_detail_layout);
        this.s = (LinearLayout) findViewById(R.id.txnDescription2_parent_sa_psbk_dtl);
        this.f58243a.setOnClickListener(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("txnId");
        this.u = intent.getStringExtra("ActId");
        String stringExtra2 = intent.getStringExtra("txnDate");
        String stringExtra3 = intent.getStringExtra("serialNum");
        String stringExtra4 = intent.getStringExtra(UpiConstants.EXTRA_ACCOUNT_TYPE);
        this.v = intent.getStringExtra("reportCode");
        this.x = intent.getStringExtra("bank_description");
        this.y = (IJRDataModel) getIntent().getSerializableExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM);
        if (stringExtra2 != null) {
            this.w = stringExtra2.trim();
        }
        try {
            net.one97.paytm.passbook.savingAccount.a.a aVar = this.f58246d;
            String trim = stringExtra.trim();
            String trim2 = this.u.trim();
            String trim3 = stringExtra2.trim();
            String str = this.v;
            new HashMap().put("screen_name", aVar.getClass().getSimpleName());
            net.one97.paytm.passbook.mapping.a.a a2 = net.one97.paytm.passbook.savingAccount.a.a.a(aVar.f58260a.f58262a, trim, trim2, trim3, stringExtra3, str, stringExtra4, aVar, aVar, a.c.PAYMENTSBANK, a.b.USER_FACING, aVar.getClass().getSimpleName());
            if (b.c(aVar.f58260a.f58262a)) {
                aVar.f58261b.a();
                c.a();
                c.b(a2);
                return;
            }
            aVar.f58261b.a((e) a2);
        } catch (Exception unused) {
        }
    }

    public final void a() {
        this.m.setVisibility(0);
    }

    public final void b() {
        this.m.setVisibility(8);
    }

    public final void a(String str, String str2) {
        net.one97.paytm.passbook.mapping.c.a((Context) this, str, str2);
    }

    public final void a(final e eVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c((Context) SavingAccountTransactionDetailActivity.this)) {
                    SavingAccountTransactionDetailActivity.this.getApplicationContext();
                    c.a();
                    c.b(eVar);
                    return;
                }
                SavingAccountTransactionDetailActivity.this.a(eVar);
            }
        });
        builder.show();
    }

    public final void a(SavingAccountDetailDataModel savingAccountDetailDataModel) {
        this.B = savingAccountDetailDataModel;
        this.A = (savingAccountDetailDataModel.getTransactions() == null || savingAccountDetailDataModel.getTransactions().size() <= 0) ? null : savingAccountDetailDataModel.getTransactions().get(0);
        this.t = savingAccountDetailDataModel.getTextForShare();
        if (this.A != null) {
            this.f58243a.setVisibility(0);
            if (c()) {
                this.f58243a.setText(getString(R.string.pass_view_detail));
            }
            if (this.A.getRrn() != null) {
                ((SavingAccountPassbookEntriesModal.TransactionDetail) this.y).setRrn(this.A.getRrn());
            }
            IJRDataModel iJRDataModel = this.y;
            if (iJRDataModel != null && (iJRDataModel instanceof SavingAccountPassbookEntriesModal.TransactionDetail)) {
                this.l.setText(net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd'T'HH:mm:ss.SSS", "MMMM dd , hh:mm a", ((SavingAccountPassbookEntriesModal.TransactionDetail) iJRDataModel).getTxnPostDate()));
            }
            this.o.setText(this.A.getNarration());
            String string = getString(R.string.wallet_rs);
            if (TextUtils.isEmpty(this.A.getTxnamount())) {
                net.one97.paytm.passbook.mapping.c.b(String.format(string, new Object[]{new DecimalFormat(q.a(Double.parseDouble(((SavingAccountPassbookEntriesModal.TransactionDetail) this.y).getAmountValue())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(((SavingAccountPassbookEntriesModal.TransactionDetail) this.y).getAmountValue()))}), this.f58248f);
            } else {
                net.one97.paytm.passbook.mapping.c.b(String.format(string, new Object[]{new DecimalFormat(q.a(Double.parseDouble(this.A.getTxnamount())), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.A.getTxnamount()))}), this.f58248f);
            }
            this.f58249g.setText(this.A.getTxnDesc0());
            this.f58250h.setImageResource(R.drawable.pass_circle_border);
            this.f58250h.setImageResource(R.drawable.pass_circle_border);
            if (URLUtil.isValidUrl(this.A.getImageUrl())) {
                w.a().a(this.A.getImageUrl()).a((ImageView) this.f58250h, (com.squareup.picasso.e) null);
            }
            if (!TextUtils.isEmpty(this.A.getTxnDesc1())) {
                this.f58251i.setText(this.A.getTxnDesc1());
            }
            if (!TextUtils.isEmpty(this.A.getTxnDesc6Value())) {
                this.q.setText(this.A.getTxnDesc6Value());
            } else {
                this.q.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.A.getTxnDesc2Value())) {
                if (!TextUtils.isEmpty(this.A.getTxnDesc2Key())) {
                    this.k.setText(this.A.getTxnDesc2Key() + " " + this.A.getTxnDesc2Value());
                } else {
                    this.k.setText(this.A.getTxnDesc2Value());
                }
            }
            if (!TextUtils.isEmpty(this.A.getTxndesc6())) {
                this.k.setText(this.A.getTxndesc6());
            }
            if (!TextUtils.isEmpty(this.A.getTxnDesc3Value())) {
                String charSequence = this.j.getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    String str = charSequence + StringUtility.NEW_LINE;
                    if (!TextUtils.isEmpty(this.A.getTxnDesc3Key())) {
                        this.j.setText((str + this.A.getTxnDesc3Key() + " " + this.A.getTxnDesc3Value()).trim());
                    } else {
                        this.j.setText((str + this.A.getTxnDesc3Value()).trim());
                    }
                } else if (!TextUtils.isEmpty(this.A.getTxnDesc3Key())) {
                    this.j.setText(this.A.getTxnDesc3Key() + " " + this.A.getTxnDesc3Value());
                } else {
                    this.j.setText(this.A.getTxnDesc3Value().trim());
                }
            }
            if (!TextUtils.isEmpty(this.A.getTxnDesc4Value())) {
                String charSequence2 = this.j.getText().toString();
                if (!TextUtils.isEmpty(charSequence2)) {
                    String str2 = charSequence2 + StringUtility.NEW_LINE;
                    if (!TextUtils.isEmpty(this.A.getTxnDesc4Key())) {
                        this.j.setText((str2 + this.A.getTxnDesc4Key() + " " + this.A.getTxnDesc4Value()).trim());
                    } else {
                        this.j.setText((str2 + this.A.getTxnDesc4Value()).trim());
                    }
                } else if (!TextUtils.isEmpty(this.A.getTxnDesc4Key())) {
                    this.j.setText((this.A.getTxnDesc4Key() + " " + this.A.getTxnDesc4Value()).trim());
                } else {
                    this.j.setText(this.A.getTxnDesc4Value().trim());
                }
            }
            if (TextUtils.isEmpty(this.A.getTxnDesc5Value())) {
                this.s.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.A.getTxnDesc5Key())) {
                this.p.setText(this.A.getTxnDesc5Key() + " " + this.A.getTxnDesc5Value());
            } else {
                this.p.setText(this.A.getTxnDesc5Value());
            }
        }
    }

    private boolean c() {
        Transaction transaction = this.A;
        return (transaction == null || !"20502".equalsIgnoreCase(transaction.getReport_code()) || this.A.getExtraInfo() == null || this.A.getExtraInfo().payerVPA == null || !this.A.getExtraInfo().payerVPA.toLowerCase().endsWith("@paytm")) ? false : true;
    }

    public final void a(Throwable th) {
        SavingAccountTransactionDetailActivity.class.getSimpleName();
        j.a((Activity) this, th);
    }

    public void onClick(View view) {
        if (view == this.f58243a) {
            q.a(this, "passbook_ppb", "ppb_passbook_need_help_clicked", (ArrayList<String>) null, "/passbook/ppb/txn-detail");
            if (c()) {
                SavingAccountDetailDataModel savingAccountDetailDataModel = this.B;
                if (savingAccountDetailDataModel != null && savingAccountDetailDataModel.getTransactions() != null && this.B.getTransactions().size() > 0 && this.B.getTransactions().get(0).getExtraInfo() != null) {
                    d.b().a("paytmmp://upi_passbook?featuretype=transactiondetail&txnId=" + this.B.getTransactions().get(0).getExtraInfo().upiTranId, (Activity) this);
                    return;
                }
                return;
            }
            d.b();
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText("My Account");
            cJRReplacementReason.setId(1000010);
            d.b().a(this.y, cJRReplacementReason, this.u);
        }
    }
}
