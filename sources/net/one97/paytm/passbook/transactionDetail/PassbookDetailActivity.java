package net.one97.paytm.passbook.transactionDetail;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.b.h;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.widgets.RoundedImageView;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRBusInvoiceModel;
import net.one97.paytm.passbook.beans.CJRButton;
import net.one97.paytm.passbook.beans.CJRCSTTransactionType;
import net.one97.paytm.passbook.beans.CJRMerchantTransactionDetail;
import net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.ExtendedTxnInfo;
import net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook;
import net.one97.paytm.passbook.beans.postcard.ReceivedLifafaDetailsResponse;
import net.one97.paytm.passbook.beans.postcard.SentLifafaDetailsResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.transactionDetail.PassbookDetailActivity;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class PassbookDetailActivity extends BaseActivity implements View.OnClickListener, g, i.a<IJRDataModel> {
    private Toolbar A;
    private String B;
    private String C = "SENT";
    private TextView D;
    private TextView E;
    /* access modifiers changed from: private */
    public DownloadManager F;
    /* access modifiers changed from: private */
    public long G;
    private CJRMerchantpaymentTransaction.Transaction H;
    private BroadcastReceiver I = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            Cursor query2 = PassbookDetailActivity.this.F.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    if (longExtra == ((long) query2.getInt(0)) && longExtra == PassbookDetailActivity.this.G) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            new Handler().postDelayed(new Runnable(query2.getString(query2.getColumnIndex("local_uri"))) {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    PassbookDetailActivity.AnonymousClass1.this.a(this.f$1);
                                }
                            }, 10000);
                        } else {
                            PassbookDetailActivity.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                            PassbookDetailActivity.this.a();
                        }
                    }
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == PassbookDetailActivity.this.G) {
                    PassbookDetailActivity.this.a();
                    PassbookDetailActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            PassbookDetailActivity.AnonymousClass1.this.a();
                        }
                    });
                }
            }
            PassbookDetailActivity.a(query2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            PassbookDetailActivity.this.a(str);
            PassbookDetailActivity.this.a();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
            Toast.makeText(passbookDetailActivity, passbookDetailActivity.getString(R.string.oops_something_went_wrong), 0).show();
        }
    };
    private String J;

    /* renamed from: a  reason: collision with root package name */
    String f58951a = "SUCCESS";

    /* renamed from: b  reason: collision with root package name */
    String f58952b = "PENDING";

    /* renamed from: c  reason: collision with root package name */
    String f58953c = "FAILURE";

    /* renamed from: d  reason: collision with root package name */
    String f58954d = AppConstants.TRANSACTION_STATUS_REFUND_SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    String f58955e = "REFUNDED_BACK";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f58956f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f58957g;

    /* renamed from: h  reason: collision with root package name */
    private View f58958h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRTransaction f58959i;
    private RoundedImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private LinearLayout s;
    private TextView t;
    private Button u;
    private Button v;
    private ImageView w;
    private LinearLayout x;
    private Dialog y;
    private TextView z;

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (!isFinishing()) {
            a();
            if (iJRDataModel instanceof CJRMerchantTransactionDetail) {
                CJRMerchantTransactionDetail cJRMerchantTransactionDetail = (CJRMerchantTransactionDetail) iJRDataModel;
                if ("00000000".equalsIgnoreCase(cJRMerchantTransactionDetail.resultCode)) {
                    this.f58959i.setmImageUrl(cJRMerchantTransactionDetail.detail.merchantLogo);
                    this.f58959i.setmNarration(cJRMerchantTransactionDetail.detail.merchantDisplayName);
                    this.f58959i.setmTxnTo(cJRMerchantTransactionDetail.detail.merchantDisplayName);
                    this.f58959i.setmTxnDesc1(cJRMerchantTransactionDetail.detail.merchantDisplayName);
                    if ("REFUND".equalsIgnoreCase(this.J)) {
                        this.f58959i.setmTxnTo(getString(R.string.you));
                        this.f58959i.setmTxnFrom(cJRMerchantTransactionDetail.detail.merchantDisplayName);
                        this.f58959i.setmType("2");
                    } else {
                        this.f58959i.setmTxnFrom(getString(R.string.you));
                        this.f58959i.setmTxnTo(cJRMerchantTransactionDetail.detail.merchantDisplayName);
                        this.f58959i.setmType("1");
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList<CJRMerchantTransactionDetail.Transactions> arrayList2 = cJRMerchantTransactionDetail.detail.transactions;
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        CJRMerchantTransactionDetail.Transactions transactions = arrayList2.get(i2);
                        ExtendedTxnInfo extendedTxnInfo = new ExtendedTxnInfo();
                        extendedTxnInfo.setSubWalletType("");
                        try {
                            extendedTxnInfo.setAmount(Double.parseDouble((transactions.txnAmt).replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, "")));
                        } catch (NumberFormatException unused) {
                            extendedTxnInfo.setAmount(0.0d);
                        }
                        extendedTxnInfo.setDisplayName(transactions.payMethod);
                        arrayList.add(extendedTxnInfo);
                    }
                    this.f58959i.setExtendedTxnInfo(arrayList);
                    a(this.f58959i);
                }
            } else if (iJRDataModel instanceof CJRCSTTransactionType) {
                CJRCSTTransactionType cJRCSTTransactionType = (CJRCSTTransactionType) iJRDataModel;
                if (cJRCSTTransactionType == null) {
                    f();
                } else if (cJRCSTTransactionType.getResponse() == null || cJRCSTTransactionType.getResponse().getTxnDetails() == null || cJRCSTTransactionType.getResponse().getTxnDetails().size() <= 0 || cJRCSTTransactionType.getResponse().getTxnDetails().get(0).getMerchantCategory() == null) {
                    f();
                } else if (cJRCSTTransactionType.getResponse().getTxnDetails().get(0).getMerchantCategory().equalsIgnoreCase("OnPaytm")) {
                    Matcher matcher = Pattern.compile("#(\\S+)").matcher(this.f58959i.getTxnDesc2());
                    ArrayList arrayList3 = new ArrayList();
                    while (matcher.find()) {
                        arrayList3.add(matcher.group(1));
                    }
                    if (arrayList3.size() <= 0 || TextUtils.isEmpty((CharSequence) arrayList3.get(0))) {
                        f();
                        return;
                    }
                    Intent intent = new Intent(this, d.b().i());
                    intent.putExtra(UpiConstants.FROM, "Order_history");
                    intent.putExtra("order_id", d((String) arrayList3.get(0)));
                    startActivity(intent);
                } else {
                    f();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_passbook_detail_activity);
        this.f58956f = (RelativeLayout) findViewById(R.id.passbook_detail_layout);
        this.f58957g = (LinearLayout) findViewById(R.id.passbook_details_parent_ll);
        this.f58958h = getLayoutInflater().inflate(R.layout.pass_passbook_detail_success, (ViewGroup) null);
        this.f58957g.addView(this.f58958h);
        this.f58959i = (CJRTransaction) getIntent().getSerializableExtra("passbook_detail_data");
        if (this.f58959i == null) {
            this.H = (CJRMerchantpaymentTransaction.Transaction) getIntent().getSerializableExtra("passbook_transaction_detail_data");
            this.J = getIntent().getStringExtra("walletTransactiontype");
            CJRMerchantpaymentTransaction.Transaction transaction = this.H;
            CJRTransaction cJRTransaction = new CJRTransaction();
            cJRTransaction.setmImageUrl(transaction.merchantLogo);
            cJRTransaction.setmTxnAmount(transaction.txnAmt);
            cJRTransaction.setmTxnDate(transaction.txnDate);
            cJRTransaction.setmNarration(transaction.merchantDisplayName);
            cJRTransaction.setmWalletOrderId(transaction.orderId);
            cJRTransaction.setmTxnTo(transaction.merchantDisplayName);
            cJRTransaction.setmTxnType(transaction.txnType);
            cJRTransaction.setmTxnStatus(transaction.txnStatus);
            if ("REFUND".equalsIgnoreCase(transaction.txnType)) {
                cJRTransaction.setmTxnTo(getString(R.string.you));
                cJRTransaction.setmTxnFrom(transaction.merchantDisplayName);
                cJRTransaction.setmType("2");
            } else {
                cJRTransaction.setmTxnFrom(getString(R.string.you));
                cJRTransaction.setmTxnTo(transaction.merchantDisplayName);
                cJRTransaction.setmType("1");
            }
            c(transaction.txnId);
            this.f58959i = cJRTransaction;
        }
        this.B = getIntent().getStringExtra("EXTENDED_TXN_INFO");
        this.w = (ImageView) findViewById(R.id.success_symbol_iv);
        this.k = (TextView) findViewById(R.id.amount_psbk_dtl);
        this.l = (TextView) findViewById(R.id.pending_fail_heading_psbk_dtl);
        this.m = (TextView) findViewById(R.id.narration_psbk_dtl);
        this.j = (RoundedImageView) findViewById(R.id.txn_type_icon_psbk_dtl);
        this.n = (TextView) findViewById(R.id.txn_date_psbk_dtl);
        this.o = (TextView) findViewById(R.id.txn_desc1_psbk_dtl);
        this.p = (TextView) findViewById(R.id.txn_desc2_psbk_dtl);
        this.z = (TextView) findViewById(R.id.tvPreviewLifafa);
        this.q = (TextView) findViewById(R.id.txn_heading_psbk_dtl);
        this.r = (TextView) findViewById(R.id.txnDescription1_psbk_dtl);
        this.s = (LinearLayout) findViewById(R.id.passbook_extrainfo_foodcards_layout);
        this.x = (LinearLayout) findViewById(R.id.txn_comment_parent_psbk_dtl);
        this.t = (TextView) findViewById(R.id.txn_comment_lbl_psbk_dtl);
        this.E = (TextView) findViewById(R.id.view_postcard_btn);
        this.A = (Toolbar) findViewById(R.id.actionbar);
        this.D = (TextView) this.A.findViewById(R.id.header);
        this.D.setText(R.string.passbook);
        ((ImageView) this.A.findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookDetailActivity.this.finish();
            }
        });
        ((ImageView) this.A.findViewById(R.id.share)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                String textForShare = passbookDetailActivity.f58959i.getTextForShare();
                RelativeLayout d2 = PassbookDetailActivity.this.f58956f;
                if (!s.a() || passbookDetailActivity == null || passbookDetailActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("image/png");
                        intent.putExtra("android.intent.extra.SUBJECT", passbookDetailActivity.getString(R.string.post_payment_share_subject));
                        intent.putExtra("android.intent.extra.TEXT", textForShare);
                        Bitmap createBitmap = Bitmap.createBitmap(d2.getWidth(), d2.getHeight(), Bitmap.Config.ARGB_8888);
                        d2.draw(new Canvas(createBitmap));
                        String insertImage = MediaStore.Images.Media.insertImage(passbookDetailActivity.getContentResolver(), createBitmap, passbookDetailActivity.getString(R.string.title), (String) null);
                        if (insertImage != null) {
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                            Intent createChooser = Intent.createChooser(intent, passbookDetailActivity.getString(R.string.post_payment_share_title));
                            if (createChooser.resolveActivity(passbookDetailActivity.getPackageManager()) != null) {
                                passbookDetailActivity.startActivity(createChooser);
                            } else {
                                Toast.makeText(passbookDetailActivity, passbookDetailActivity.getString(R.string.no_app_found), 1).show();
                            }
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    s.b((Activity) passbookDetailActivity);
                    Toast.makeText(passbookDetailActivity, passbookDetailActivity.getString(R.string.permission_not_granted), 0).show();
                }
            }
        });
        String txnStatus = this.f58959i.getTxnStatus();
        this.u = (Button) findViewById(R.id.need_help_psbk_dtl);
        this.v = (Button) findViewById(R.id.why_transaction_on_hold);
        if (!this.f58959i.getTxnType().equalsIgnoreCase("DR") || !this.f58959i.getType().equalsIgnoreCase("22") || !this.f58959i.getNarration().contains(getString(R.string.auth))) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        this.v.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.E.setOnClickListener(this);
        if (!TextUtils.isEmpty(txnStatus)) {
            this.l.setVisibility(8);
            if (txnStatus.equalsIgnoreCase(this.f58951a)) {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_payment_done_00048));
            } else if (txnStatus.equalsIgnoreCase(this.f58952b)) {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_group_3_copy));
                this.l.setVisibility(0);
            } else if (txnStatus.equalsIgnoreCase(this.f58953c)) {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_ic_failed));
                this.l.setVisibility(0);
            } else if (txnStatus.equalsIgnoreCase(this.f58955e)) {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_payment_done_00048));
                this.l.setVisibility(0);
            } else if (txnStatus.equalsIgnoreCase(this.f58954d)) {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_payment_done_00048));
            } else {
                this.w.setImageDrawable(b.a((Context) this, R.drawable.pass_group_3_copy));
            }
            if ("FAILURE".equalsIgnoreCase(txnStatus)) {
                this.l.setText("Transaction Failed");
            }
        }
        this.n = (TextView) findViewById(R.id.txn_date_psbk_dtl);
        a(this.f58959i);
    }

    private void c(String str) {
        String a2 = d.b().a("merchantTransactionDetialURL");
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", a.q(this));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("searchType", this.J);
            jSONObject.put("txnId", str);
        } catch (JSONException unused) {
        }
        net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(a2, this, this, new CJRMerchantTransactionDetail(), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.SILENT, getClass().getName());
        if (com.paytm.utility.b.c((Context) this)) {
            b();
            c.a();
            c.b(bVar);
            return;
        }
        a((e) bVar);
    }

    private void a(CJRTransaction cJRTransaction) {
        String txnTo = cJRTransaction.getTxnTo();
        String txnDate = cJRTransaction.getTxnDate();
        String txnAmount = cJRTransaction.getTxnAmount();
        String imageUrl = cJRTransaction.getImageUrl();
        String txnDesc2 = cJRTransaction.getTxnDesc2();
        String narration = cJRTransaction.getNarration();
        String walletOrderId = cJRTransaction.getWalletOrderId();
        cJRTransaction.getTxnDescription1();
        String type = cJRTransaction.getType();
        if (!TextUtils.isEmpty(narration)) {
            this.D.setText(e(narration));
        }
        if (TextUtils.isEmpty(txnTo)) {
            this.q.setText(e(txnTo));
        }
        if (URLUtil.isValidUrl(imageUrl)) {
            this.j.setImageUrl(imageUrl, h.INSTANCE.getImageLoader());
        }
        String format = String.format(getString(R.string.wallet_rs), new Object[]{net.one97.paytm.passbook.utility.c.d(txnAmount)});
        this.n.setText(net.one97.paytm.passbook.mapping.c.k("yyyy-MM-dd HH:mm:ss", "MMMM dd , hh:mm a", txnDate));
        this.k.setText(format);
        TextView textView = this.o;
        textView.setText(getString(R.string.wallet_order_id) + " " + walletOrderId);
        if (!TextUtils.isEmpty(txnDesc2)) {
            this.p.setText(cJRTransaction.getTxnDesc2());
        }
        if (!TextUtils.isEmpty(cJRTransaction.getTxnDesc3())) {
            TextView textView2 = this.p;
            textView2.setText(this.p.getText().toString() + StringUtility.NEW_LINE + cJRTransaction.getTxnDesc3());
        }
        if (!TextUtils.isEmpty(cJRTransaction.getTxnDesc4())) {
            TextView textView3 = this.p;
            textView3.setText(this.p.getText().toString() + StringUtility.NEW_LINE + cJRTransaction.getTxnDesc4());
        }
        if (!TextUtils.isEmpty(cJRTransaction.getTxnDesc4()) && cJRTransaction.getThemeInfo() != null) {
            char c2 = 65535;
            int hashCode = type.hashCode();
            if (hashCode != 53) {
                if (hashCode != 56) {
                    if (hashCode == 1691 && type.equals("50")) {
                        c2 = 1;
                    }
                } else if (type.equals("8")) {
                    c2 = 0;
                }
            } else if (type.equals("5")) {
                c2 = 2;
            }
            if (c2 == 0) {
                this.C = "RECEIVED";
                this.p.setVisibility(8);
                this.z.setVisibility(0);
                this.z.setOnClickListener(this);
            } else if (c2 == 1) {
                this.C = "SENT";
                this.p.setVisibility(8);
                this.z.setVisibility(0);
                this.z.setOnClickListener(this);
            } else if (c2 == 2) {
                this.C = "RECEIVED";
                this.p.setVisibility(8);
                this.z.setVisibility(0);
                this.z.setOnClickListener(this);
            }
        }
        if (TextUtils.isEmpty(this.p.getText().toString())) {
            this.x.setVisibility(8);
        }
        a(this.s, cJRTransaction.getExtendedTxnInfo());
        a(type, cJRTransaction);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x061d  */
    /* JADX WARNING: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, net.one97.paytm.passbook.beans.CJRTransaction r8) {
        /*
            r6 = this;
            java.lang.String r0 = r8.getTxnStatus()
            java.lang.String r1 = r6.f58951a
            boolean r0 = r0.equalsIgnoreCase(r1)
            r1 = 8
            r2 = 0
            if (r0 == 0) goto L_0x0015
            android.widget.TextView r0 = r6.m
            r0.setVisibility(r2)
            goto L_0x001a
        L_0x0015:
            android.widget.TextView r0 = r6.m
            r0.setVisibility(r1)
        L_0x001a:
            android.widget.TextView r0 = r6.r
            r0.setVisibility(r1)
            android.widget.TextView r0 = r6.t
            r0.setVisibility(r1)
            r0 = -1
            int r3 = r7.hashCode()
            r4 = 55
            r5 = 1
            if (r3 == r4) goto L_0x00bf
            r4 = 56
            if (r3 == r4) goto L_0x00b5
            r4 = 1598(0x63e, float:2.239E-42)
            if (r3 == r4) goto L_0x00aa
            r4 = 1607(0x647, float:2.252E-42)
            if (r3 == r4) goto L_0x009f
            r4 = 1691(0x69b, float:2.37E-42)
            if (r3 == r4) goto L_0x0095
            r4 = 1665(0x681, float:2.333E-42)
            if (r3 == r4) goto L_0x008a
            r4 = 1666(0x682, float:2.335E-42)
            if (r3 == r4) goto L_0x007f
            switch(r3) {
                case 49: goto L_0x0075;
                case 50: goto L_0x006b;
                case 51: goto L_0x0061;
                case 52: goto L_0x0056;
                case 53: goto L_0x004b;
                default: goto L_0x0049;
            }
        L_0x0049:
            goto L_0x00c9
        L_0x004b:
            java.lang.String r3 = "5"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 6
            goto L_0x00ca
        L_0x0056:
            java.lang.String r3 = "4"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 5
            goto L_0x00ca
        L_0x0061:
            java.lang.String r3 = "3"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 4
            goto L_0x00ca
        L_0x006b:
            java.lang.String r3 = "2"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 3
            goto L_0x00ca
        L_0x0075:
            java.lang.String r3 = "1"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 2
            goto L_0x00ca
        L_0x007f:
            java.lang.String r3 = "46"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 11
            goto L_0x00ca
        L_0x008a:
            java.lang.String r3 = "45"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 10
            goto L_0x00ca
        L_0x0095:
            java.lang.String r3 = "50"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 1
            goto L_0x00ca
        L_0x009f:
            java.lang.String r3 = "29"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 9
            goto L_0x00ca
        L_0x00aa:
            java.lang.String r3 = "20"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 8
            goto L_0x00ca
        L_0x00b5:
            java.lang.String r3 = "8"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 0
            goto L_0x00ca
        L_0x00bf:
            java.lang.String r3 = "7"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00c9
            r7 = 7
            goto L_0x00ca
        L_0x00c9:
            r7 = -1
        L_0x00ca:
            java.lang.String r0 = " "
            java.lang.String r3 = "CR"
            java.lang.String r4 = ""
            switch(r7) {
                case 0: goto L_0x061d;
                case 1: goto L_0x05c5;
                case 2: goto L_0x04f4;
                case 3: goto L_0x0435;
                case 4: goto L_0x03d0;
                case 5: goto L_0x03cf;
                case 6: goto L_0x0332;
                case 7: goto L_0x02d8;
                case 8: goto L_0x027e;
                case 9: goto L_0x0149;
                case 10: goto L_0x00ec;
                case 11: goto L_0x00ec;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58951a
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0646
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.txn_suc_to_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            goto L_0x0675
        L_0x00ec:
            java.lang.String r7 = r8.getTxnType()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x010b
            java.lang.String r7 = r8.getTxnType()
            boolean r7 = r7.equalsIgnoreCase(r3)
            if (r7 == 0) goto L_0x010b
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.recived
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
        L_0x010b:
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0122
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
        L_0x0122:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0143
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r0[r2] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r8 = r6.o
            r8.setText(r7)
        L_0x0143:
            android.widget.TextView r7 = r6.r
            r7.setVisibility(r1)
            return
        L_0x0149:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58951a
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0161
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.txn_suc_to_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            goto L_0x0190
        L_0x0161:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58952b
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0179
            android.widget.TextView r7 = r6.l
            int r0 = net.one97.paytm.passbook.R.string.rqst_pndng_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            goto L_0x0190
        L_0x0179:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58953c
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0190
            android.widget.TextView r7 = r6.l
            int r0 = net.one97.paytm.passbook.R.string.pmnt_fail_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
        L_0x0190:
            java.lang.String r7 = r8.getTxnDesc3()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01b1
            int r7 = net.one97.paytm.passbook.R.string.acc_no_psbk_dtl
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r3 = r8.getTxnDesc3()
            r0[r2] = r3
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r0 = r6.q
            r0.setText(r7)
        L_0x01b1:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01d2
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r3 = r8.getWalletOrderId()
            r0[r2] = r3
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r0 = r6.o
            r0.setText(r7)
        L_0x01d2:
            android.widget.TextView r7 = r6.p
            r7.setText(r4)
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01ea
            android.widget.TextView r7 = r6.p
            java.lang.String r0 = r8.getTxnDesc1()
            r7.setText(r0)
        L_0x01ea:
            java.lang.String r7 = r8.getTxnDesc2()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r0 = "\n"
            if (r7 != 0) goto L_0x021b
            android.widget.TextView r7 = r6.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.widget.TextView r3 = r6.p
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = r8.getTxnDesc2()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r7.setText(r2)
        L_0x021b:
            java.lang.String r7 = r8.getTxnDesc4()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x024a
            android.widget.TextView r7 = r6.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.widget.TextView r3 = r6.p
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r8 = r8.getTxnDesc4()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r7.setText(r8)
        L_0x024a:
            android.widget.TextView r7 = r6.p
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x025f
            android.widget.LinearLayout r7 = r6.x
            r7.setVisibility(r1)
        L_0x025f:
            android.widget.TextView r7 = r6.p
            java.lang.CharSequence r8 = r7.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = e(r8)
            java.lang.String r8 = e(r8)
            r7.setText(r8)
            int r7 = net.one97.paytm.passbook.R.id.txn_comment_lbl_psbk_dtl
            android.view.View r7 = r6.findViewById(r7)
            r7.setVisibility(r1)
            return
        L_0x027e:
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.added_successfully_passbook_detail
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            android.widget.TextView r7 = r6.r
            r7.setVisibility(r1)
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x02a5
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
        L_0x02a5:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x02c6
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r0[r2] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r8 = r6.o
            r8.setText(r7)
        L_0x02c6:
            android.widget.TextView r7 = r6.p
            java.lang.CharSequence r8 = r7.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = e(r8)
            r7.setText(r8)
            return
        L_0x02d8:
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.rcvd_for
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x02f6
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            r7.setText(r0)
        L_0x02f6:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0317
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r0[r2] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r8 = r6.o
            r8.setText(r7)
        L_0x0317:
            android.widget.TextView r7 = r6.p
            java.lang.CharSequence r8 = r7.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = e(r8)
            r7.setText(r8)
            int r7 = net.one97.paytm.passbook.R.id.txn_comment_lbl_psbk_dtl
            android.view.View r7 = r6.findViewById(r7)
            r7.setVisibility(r1)
            return
        L_0x0332:
            java.lang.String r7 = r8.getTxnType()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0352
            java.lang.String r7 = r8.getTxnType()
            boolean r7 = r7.equalsIgnoreCase(r3)
            if (r7 == 0) goto L_0x0352
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.recived
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            goto L_0x0373
        L_0x0352:
            java.lang.String r7 = r8.getTxnType()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0373
            java.lang.String r7 = r8.getTxnType()
            java.lang.String r0 = "DR"
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0373
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.paid_scs
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
        L_0x0373:
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x038a
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
        L_0x038a:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x03ab
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r3 = r8.getWalletOrderId()
            r0[r2] = r3
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r0 = r6.o
            r0.setText(r7)
        L_0x03ab:
            android.widget.TextView r7 = r6.r
            r7.setVisibility(r1)
            net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook r7 = r8.getThemeInfo()
            java.lang.String r7 = a((net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook) r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x06cc
            boolean r8 = android.webkit.URLUtil.isValidUrl(r7)
            if (r8 == 0) goto L_0x06cc
            net.one97.paytm.common.widgets.RoundedImageView r8 = r6.j
            com.paytm.network.b.h r0 = com.paytm.network.b.h.INSTANCE
            com.android.volley.toolbox.ImageLoader r0 = r0.getImageLoader()
            r8.setImageUrl(r7, r0)
        L_0x03cf:
            return
        L_0x03d0:
            android.widget.TextView r7 = r6.m
            int r0 = net.one97.paytm.passbook.R.string.psbk_dtl_aded_agnst_ordr
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x03f2
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
        L_0x03f2:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0413
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_order
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = r8.getWalletOrderId()
            r0[r2] = r1
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r0 = r6.r
            r0.setText(r7)
        L_0x0413:
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x06cc
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r0[r2] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r8 = r6.o
            r8.setText(r7)
            return
        L_0x0435:
            android.widget.TextView r7 = r6.m
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_restored_frm
            java.lang.String r1 = r6.getString(r1)
            r7.setText(r1)
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0461
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r3 = r8.getWalletOrderId()
            r1[r2] = r3
            java.lang.String r7 = java.lang.String.format(r7, r1)
            android.widget.TextView r1 = r6.p
            r1.setText(r7)
        L_0x0461:
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0478
            android.widget.TextView r7 = r6.q
            java.lang.String r1 = r8.getTxnDesc1()
            java.lang.String r1 = e(r1)
            r7.setText(r1)
        L_0x0478:
            int r7 = net.one97.paytm.passbook.R.id.txn_date_psbk_dtl
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r2)
            java.lang.String r1 = r8.getWalletOrderId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04c5
            net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction$Transaction r1 = r6.H
            if (r1 == 0) goto L_0x04ae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r3 = net.one97.paytm.passbook.R.string.order_txn_id
            java.lang.String r3 = r6.getString(r3)
            r1.append(r3)
            r1.append(r0)
            java.lang.String r8 = r8.getWalletOrderId()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            goto L_0x04c0
        L_0x04ae:
            int r0 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r0 = r6.getString(r0)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r1[r2] = r8
            java.lang.String r8 = java.lang.String.format(r0, r1)
        L_0x04c0:
            android.widget.TextView r0 = r6.o
            r0.setText(r8)
        L_0x04c5:
            android.widget.TextView r8 = r6.t
            r8.setVisibility(r2)
            android.widget.TextView r8 = r6.t
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r8.setText(r7)
            java.lang.String r7 = r6.J
            java.lang.String r8 = "REFUND"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x06cc
            net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction$Transaction r7 = r6.H
            if (r7 == 0) goto L_0x06cc
            net.one97.paytm.common.widgets.RoundedImageView r7 = r6.j
            int r8 = net.one97.paytm.passbook.R.drawable.pass_default_credit
            r7.setDefaultImageResId(r8)
            android.widget.TextView r7 = r6.m
            int r8 = net.one97.paytm.passbook.R.string.refund_successfully
            r7.setText(r8)
            return
        L_0x04f4:
            android.widget.TextView r7 = r6.m
            int r1 = net.one97.paytm.passbook.R.string.psbk_dtl_p_to_m_desc
            java.lang.String r1 = r6.getString(r1)
            r7.setText(r1)
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_order
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r3 = r8.getWalletOrderId()
            r1[r2] = r3
            java.lang.String r7 = java.lang.String.format(r7, r1)
            android.widget.TextView r1 = r6.r
            r1.setText(r7)
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0558
            net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction$Transaction r7 = r6.H
            if (r7 == 0) goto L_0x0541
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r1 = net.one97.paytm.passbook.R.string.order_txn_id
            java.lang.String r1 = r6.getString(r1)
            r7.append(r1)
            r7.append(r0)
            java.lang.String r0 = r8.getWalletOrderId()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            goto L_0x0553
        L_0x0541:
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = r8.getWalletOrderId()
            r0[r2] = r1
            java.lang.String r7 = java.lang.String.format(r7, r0)
        L_0x0553:
            android.widget.TextView r0 = r6.o
            r0.setText(r7)
        L_0x0558:
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
            r6.b((net.one97.paytm.passbook.beans.CJRTransaction) r8)
            java.lang.String r7 = r6.J
            java.lang.String r0 = "TRANSACTION"
            boolean r7 = r0.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0579
            net.one97.paytm.common.widgets.RoundedImageView r7 = r6.j
            int r0 = net.one97.paytm.passbook.R.drawable.pass_default_debit
            r7.setDefaultImageResId(r0)
        L_0x0579:
            net.one97.paytm.passbook.beans.CJRMerchantpaymentTransaction$Transaction r7 = r6.H
            if (r7 == 0) goto L_0x06cc
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58951a
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0595
            android.widget.TextView r7 = r6.m
            int r8 = net.one97.paytm.passbook.R.string.psbk_dtl_p_to_m_desc
            java.lang.String r8 = r6.getString(r8)
            r7.setText(r8)
            return
        L_0x0595:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58952b
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x05ad
            android.widget.TextView r7 = r6.l
            int r8 = net.one97.paytm.passbook.R.string.rqst_pndng_psbk_dtl
            java.lang.String r8 = r6.getString(r8)
            r7.setText(r8)
            return
        L_0x05ad:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r8 = r6.f58953c
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x06cc
            android.widget.TextView r7 = r6.l
            int r8 = net.one97.paytm.passbook.R.string.pmnt_fail_psbk_dtl
            java.lang.String r8 = r6.getString(r8)
            r7.setText(r8)
            return
        L_0x05c5:
            android.widget.TextView r7 = r6.m
            java.lang.String r0 = r8.getNarration()
            r7.setText(r0)
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            r7.setText(r0)
            android.widget.TextView r7 = r6.p
            r7.setText(r4)
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x05fd
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = r8.getWalletOrderId()
            r0[r2] = r1
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r0 = r6.o
            r0.setText(r7)
        L_0x05fd:
            net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook r7 = r8.getThemeInfo()
            java.lang.String r7 = a((net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook) r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x06cc
            boolean r8 = android.webkit.URLUtil.isValidUrl(r7)
            if (r8 == 0) goto L_0x06cc
            net.one97.paytm.common.widgets.RoundedImageView r8 = r6.j
            com.paytm.network.b.h r0 = com.paytm.network.b.h.INSTANCE
            com.android.volley.toolbox.ImageLoader r0 = r0.getImageLoader()
            r8.setImageUrl(r7, r0)
            return
        L_0x061d:
            android.widget.TextView r7 = r6.m
            java.lang.String r0 = r8.getNarration()
            r7.setText(r0)
            net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook r7 = r8.getThemeInfo()
            java.lang.String r7 = a((net.one97.paytm.passbook.beans.data.ThemesMetaDataModelPassbook) r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x06cc
            boolean r8 = android.webkit.URLUtil.isValidUrl(r7)
            if (r8 == 0) goto L_0x06cc
            net.one97.paytm.common.widgets.RoundedImageView r8 = r6.j
            com.paytm.network.b.h r0 = com.paytm.network.b.h.INSTANCE
            com.android.volley.toolbox.ImageLoader r0 = r0.getImageLoader()
            r8.setImageUrl(r7, r0)
            return
        L_0x0646:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58952b
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x065e
            android.widget.TextView r7 = r6.l
            int r0 = net.one97.paytm.passbook.R.string.rqst_pndng_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
            goto L_0x0675
        L_0x065e:
            java.lang.String r7 = r8.getTxnStatus()
            java.lang.String r0 = r6.f58953c
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x0675
            android.widget.TextView r7 = r6.l
            int r0 = net.one97.paytm.passbook.R.string.pmnt_fail_psbk_dtl
            java.lang.String r0 = r6.getString(r0)
            r7.setText(r0)
        L_0x0675:
            android.widget.TextView r7 = r6.r
            r7.setVisibility(r1)
            java.lang.String r7 = r8.getTxnDesc1()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0691
            android.widget.TextView r7 = r6.q
            java.lang.String r0 = r8.getTxnDesc1()
            java.lang.String r0 = e(r0)
            r7.setText(r0)
        L_0x0691:
            int r7 = net.one97.paytm.passbook.R.id.narration_psbk_dtl
            android.view.View r7 = r6.findViewById(r7)
            r7.setVisibility(r1)
            java.lang.String r7 = r8.getWalletOrderId()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x06bb
            int r7 = net.one97.paytm.passbook.R.string.psbk_dtl_wallet_txn_id
            java.lang.String r7 = r6.getString(r7)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getWalletOrderId()
            r0[r2] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            android.widget.TextView r8 = r6.o
            r8.setText(r7)
        L_0x06bb:
            android.widget.TextView r7 = r6.p
            java.lang.CharSequence r8 = r7.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = e(r8)
            r7.setText(r8)
        L_0x06cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.PassbookDetailActivity.a(java.lang.String, net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    private static String a(ThemesMetaDataModelPassbook themesMetaDataModelPassbook) {
        if (themesMetaDataModelPassbook == null) {
            return null;
        }
        try {
            new f();
            return themesMetaDataModelPassbook.getThemes().getThumbnailView().get(1).getUrl1();
        } catch (Exception unused) {
            return null;
        }
    }

    public void onClick(View view) {
        String[] split;
        View view2 = view;
        String str = "";
        if (view2 == this.u) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                hashMap.put("new_wallet_passbook_tab_name", this.B);
                d.b().a((Map<String, Object>) hashMap);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(this.f58959i.getTxnDesc1()) && this.f58959i.getTxnDesc1().startsWith("Paytm") && !this.f58959i.getType().equals("7")) {
                final CJRTransaction cJRTransaction = this.f58959i;
                final com.paytm.utility.h hVar = new com.paytm.utility.h(this);
                hVar.setTitle(getString(R.string.needhelp_dialog_title));
                hVar.a(getString(R.string.passbook_contact_us_order_history));
                hVar.a(-3, getResources().getString(R.string.passbook_go_to_order_history), new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.cancel();
                        Intent intent = new Intent(PassbookDetailActivity.this, d.b().i());
                        intent.putExtra(UpiConstants.FROM, "Order_history");
                        if (!TextUtils.isEmpty(cJRTransaction.getTxnDescription1())) {
                            intent.putExtra("order_id", PassbookDetailActivity.d(cJRTransaction.getTxnDescription1()));
                        }
                        PassbookDetailActivity.this.startActivity(intent);
                    }
                });
                hVar.setCancelable(true);
                hVar.show();
            } else if (TextUtils.isEmpty(this.f58959i.getTxnDesc1()) || (!this.f58959i.getType().equalsIgnoreCase("7") && !this.f58959i.getType().equalsIgnoreCase("59"))) {
                d.b().a((AppCompatActivity) this, this.f58959i);
            } else {
                CJRTransaction cJRTransaction2 = this.f58959i;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Content-Type", "application/json");
                hashMap2.put("clientid", "c114653fb7b74318af0c89a95e69230b");
                hashMap2.put("hash", "5df45d5cf05f6606cb0016e5b3114428989c273adadbee0d6344627eb09a7396");
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (cJRTransaction2.getWalletOrderId() != null) {
                        jSONObject2.put("walletTxnId", cJRTransaction2.getWalletOrderId());
                    }
                    if (cJRTransaction2.getWalletOrderId() != null) {
                        jSONObject2.put("orderId", cJRTransaction2.getWalletOrderId());
                    }
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, str);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, str);
                } catch (JSONException unused2) {
                }
                if (com.paytm.utility.b.c((Context) this)) {
                    String d2 = com.paytm.utility.b.d((Context) this, d.b().a("transactionValidationAPI"));
                    c.a();
                    c.b(new net.one97.paytm.passbook.mapping.a.b(d2, this, this, new CJRCSTTransactionType(), hashMap2, jSONObject.toString(), a.c.PASSBOOK, a.b.SILENT, getClass().getName()));
                    return;
                }
                net.one97.paytm.passbook.mapping.d dVar = new net.one97.paytm.passbook.mapping.d();
                dVar.setmAlertTitle(getResources().getString(R.string.title_connection_problem));
                dVar.setAlertMessage(getResources().getString(R.string.msg_connection_problem));
            }
        } else if (view2 == this.E) {
            Intent intent = new Intent(this, d.b().w());
            String txnDesc4 = this.f58959i.getTxnDesc4();
            if (!TextUtils.isEmpty(txnDesc4) && (split = txnDesc4.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON)) != null && split.length > 1) {
                str = split[1].trim();
            }
            intent.putExtra("event_id", str);
            startActivity(intent);
        } else if (view2 == this.z) {
            String txnDesc42 = this.f58959i.getTxnDesc4();
            b();
            String a2 = d.b().a("lifafaEventDetailURL");
            if (URLUtil.isValidUrl(a2)) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("lifafaKey", txnDesc42);
                    jSONObject3.put("startOffset", "0");
                    jSONObject3.put("limit", "100");
                } catch (JSONException unused3) {
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("ssotoken", com.paytm.utility.a.q(this));
                hashMap3.put("Content-Type", "application/json");
                IJRDataModel iJRDataModel = null;
                if (this.C.equalsIgnoreCase("RECEIVED")) {
                    iJRDataModel = new ReceivedLifafaDetailsResponse();
                } else if (this.C.equalsIgnoreCase("SENT")) {
                    iJRDataModel = new SentLifafaDetailsResponse();
                }
                net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(a2, new i.a<IJRDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        SentLifafaDetailsResponse sentLifafaDetailsResponse;
                        IJRDataModel iJRDataModel = (IJRDataModel) obj;
                        PassbookDetailActivity.this.a();
                        if (iJRDataModel == null) {
                            return;
                        }
                        if (iJRDataModel instanceof ReceivedLifafaDetailsResponse) {
                            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) iJRDataModel;
                            if (receivedLifafaDetailsResponse == null) {
                                return;
                            }
                            if (receivedLifafaDetailsResponse.getStatusCode() != null && receivedLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                                Intent intent = new Intent(PassbookDetailActivity.this, d.b().w());
                                intent.putExtra("data", receivedLifafaDetailsResponse);
                                PassbookDetailActivity.this.startActivity(intent);
                            } else if ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (receivedLifafaDetailsResponse.getStatusCode() == null || !receivedLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                                PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                                com.paytm.utility.b.b((Context) passbookDetailActivity, passbookDetailActivity.getString(R.string.error), PassbookDetailActivity.this.getString(R.string.some_went_wrong));
                            } else {
                                PassbookDetailActivity passbookDetailActivity2 = PassbookDetailActivity.this;
                                com.paytm.utility.b.b((Context) passbookDetailActivity2, passbookDetailActivity2.getString(R.string.error), receivedLifafaDetailsResponse.getStatusMessage());
                            }
                        } else if ((iJRDataModel instanceof SentLifafaDetailsResponse) && (sentLifafaDetailsResponse = (SentLifafaDetailsResponse) iJRDataModel) != null) {
                            if (sentLifafaDetailsResponse.getStatusCode() != null && sentLifafaDetailsResponse.getStatusCode().equals("FE_0000")) {
                                Intent intent2 = new Intent(PassbookDetailActivity.this, d.b().w());
                                intent2.putExtra("data", sentLifafaDetailsResponse);
                                PassbookDetailActivity.this.startActivity(intent2);
                            } else if ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("EV_0014")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0001")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0002")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0003")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_0004")) && ((sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1000")) && (sentLifafaDetailsResponse.getStatusCode() == null || !sentLifafaDetailsResponse.getStatusCode().equals("RWL_1001")))))))) {
                                PassbookDetailActivity passbookDetailActivity3 = PassbookDetailActivity.this;
                                com.paytm.utility.b.b((Context) passbookDetailActivity3, passbookDetailActivity3.getString(R.string.error), PassbookDetailActivity.this.getString(R.string.some_went_wrong));
                            } else {
                                PassbookDetailActivity passbookDetailActivity4 = PassbookDetailActivity.this;
                                com.paytm.utility.b.b((Context) passbookDetailActivity4, passbookDetailActivity4.getString(R.string.error), sentLifafaDetailsResponse.getStatusMessage());
                            }
                        }
                    }
                }, new g() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        PassbookDetailActivity.this.a();
                        PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                        PassbookDetailActivity.class.getSimpleName();
                        j.a((Activity) passbookDetailActivity, (Throwable) networkCustomError);
                    }
                }, iJRDataModel, hashMap3, jSONObject3.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, getClass().getName());
                if (com.paytm.utility.b.c((Context) this)) {
                    c.a();
                    c.b(bVar);
                }
            }
        } else if (view2 == this.v) {
            d.b().a((Context) this, "https://paytm.com/offer/uber-introduces-a-new-feature-on-paytm/", getString(R.string.passbook_on_hold_txn_text));
        }
    }

    private void b() {
        try {
            if (this.y == null) {
                this.y = net.one97.paytm.passbook.mapping.c.f(this);
            }
            if (this.y != null && !this.y.isShowing()) {
                this.y.show();
            }
        } catch (Exception unused) {
        }
    }

    public final void a() {
        try {
            if (this.y != null && this.y.isShowing()) {
                this.y.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static String d(String str) {
        try {
            Long.parseLong(str);
            return str;
        } catch (Exception unused) {
            return str.substring(str.indexOf("-") + 1);
        }
    }

    private void a(LinearLayout linearLayout, ArrayList<ExtendedTxnInfo> arrayList) {
        if (arrayList != null) {
            try {
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.passbook_extrainfo_foodcards_txn_layout);
                linearLayout2.removeAllViews();
                Iterator<ExtendedTxnInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ExtendedTxnInfo next = it2.next();
                    View inflate = LayoutInflater.from(this).inflate(R.layout.pass_row_extended_info, (ViewGroup) null, false);
                    TextView textView = (TextView) inflate.findViewById(R.id.wallet_name);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.wallet_amount);
                    if (!TextUtils.isEmpty(next.getDisplayName())) {
                        textView.setText(next.getDisplayName());
                        if (!TextUtils.isEmpty(next.getDisplayName())) {
                            net.one97.paytm.passbook.mapping.c.a(String.format(getResources().getString(R.string.simple_amount), new Object[]{Double.valueOf(next.getAmount())}), textView2);
                            inflate.setPadding(0, (int) ((getResources().getDisplayMetrics().density * 10.0f) + 0.5f), 0, 0);
                            linearLayout2.addView(inflate);
                        }
                    }
                }
                linearLayout.setVisibility(0);
            } catch (Exception unused) {
            }
        } else {
            linearLayout.setVisibility(8);
        }
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (str2.length() > 1) {
                sb.append(str2.substring(0, 1).toUpperCase());
                sb.append(str2.substring(1) + " ");
            } else {
                sb.append(str2 + " ");
            }
        }
        return sb.toString();
    }

    private void b(final CJRTransaction cJRTransaction) {
        ArrayList<CJRButton> buttonList = cJRTransaction.getButtonList();
        if (buttonList != null && buttonList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < buttonList.size(); i2++) {
                final CJRButton cJRButton = buttonList.get(i2);
                if (cJRTransaction.isBtnEnabled()) {
                    if (cJRButton.getActionUrl() == null && cJRTransaction.getType().equalsIgnoreCase("1") && cJRTransaction.getLabel().equalsIgnoreCase("UTS")) {
                        Button button = (Button) findViewById(R.id.uts_psbk_dtl);
                        button.setText(cJRButton.getButtonName());
                        button.setVisibility(0);
                        button.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                PassbookDetailActivity.a(PassbookDetailActivity.this, cJRTransaction.getWalletOrderId());
                            }
                        });
                    } else if (cJRTransaction.isInvoiceProcessed() && !v.a(cJRButton.getActionUrl())) {
                        Button button2 = (Button) findViewById(R.id.uts_psbk_view_bill);
                        button2.setText(cJRButton.getButtonName());
                        button2.setVisibility(0);
                        button2.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                if (com.paytm.utility.b.c(view.getContext())) {
                                    PassbookDetailActivity.b(PassbookDetailActivity.this, cJRTransaction.getWalletOrderId(), cJRButton.getActionUrl());
                                    return;
                                }
                                PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                                com.paytm.utility.b.b((Context) passbookDetailActivity, passbookDetailActivity.getString(R.string.network_error_heading), PassbookDetailActivity.this.getString(R.string.unexpected_error_message));
                            }
                        });
                    }
                }
                int size = arrayList.size();
                arrayList.add(cJRButton.getButtonName());
                cJRButton.setButtonTag(size);
            }
        }
    }

    private void c() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f58970a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f58970a) {
                        s.b((Context) PassbookDetailActivity.this);
                        PassbookDetailActivity.this.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        PassbookDetailActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        PassbookDetailActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2, getResources().getString(net.one97.paytm.passbook.R.string.no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0044
            r2.a()     // Catch:{ Exception -> 0x0044 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = "net.one97.paytm.passbook.provider"
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0044 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0044 }
            android.net.Uri r3 = androidx.core.content.FileProvider.getUriForFile(r2, r0, r1)     // Catch:{ Exception -> 0x0044 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "application/pdf"
            r0.setDataAndType(r3, r1)     // Catch:{ Exception -> 0x0044 }
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0044 }
            r3 = 1
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0044 }
            r2.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0031 }
            return
        L_0x0031:
            android.content.res.Resources r3 = r2.getResources()     // Catch:{ Exception -> 0x0044 }
            int r0 = net.one97.paytm.passbook.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x0044 }
            r0 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ Exception -> 0x0044 }
            r3.show()     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.PassbookDetailActivity.a(java.lang.String):void");
    }

    public final void a(final e eVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) PassbookDetailActivity.this)) {
                    c.a();
                    c.b(eVar);
                    return;
                }
                PassbookDetailActivity.this.a(eVar);
            }
        });
        builder.show();
    }

    private i.a<IJRDataModel> d() {
        return new i.a<IJRDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                if (iJRDataModel instanceof CJRBusInvoiceModel) {
                    CJRBusInvoiceModel cJRBusInvoiceModel = (CJRBusInvoiceModel) iJRDataModel;
                    if (cJRBusInvoiceModel.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                        new Intent();
                        d.b();
                        return;
                    }
                    PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                    PassbookDetailActivity.c(passbookDetailActivity, passbookDetailActivity.getString(R.string.error), cJRBusInvoiceModel.getmStatusMessage());
                }
            }
        };
    }

    private g e() {
        return new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                PassbookDetailActivity passbookDetailActivity = PassbookDetailActivity.this;
                PassbookDetailActivity.c(passbookDetailActivity, passbookDetailActivity.getString(R.string.error), PassbookDetailActivity.this.getString(R.string.some_went_wrong));
            }
        };
    }

    private void f() {
        d.b().a((AppCompatActivity) this, this.f58959i);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            a();
            PassbookDetailActivity.class.getSimpleName();
            j.a((Activity) this, (Throwable) networkCustomError);
        }
    }

    static /* synthetic */ void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void a(PassbookDetailActivity passbookDetailActivity, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("systemTxnId", str);
            jSONObject.put("request", jSONObject2);
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "192.168.1.100");
            jSONObject.put("channel", "WEB");
            jSONObject.put("version", "1.0");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "WITHDRAW_MONEY");
        } catch (JSONException unused) {
        }
        String a2 = d.b().a("utsGetInvoiceUrl");
        if (a2 != null) {
            String b2 = com.paytm.utility.b.b((Context) passbookDetailActivity, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", com.paytm.utility.a.q(passbookDetailActivity));
            hashMap.put("Accept-Encoding", "gzip");
            if (!TextUtils.isEmpty(b2) && URLUtil.isValidUrl(b2.trim())) {
                if (com.paytm.utility.b.c((Context) passbookDetailActivity)) {
                    c.a();
                    c.b(new net.one97.paytm.passbook.mapping.a.b(b2, passbookDetailActivity.d(), passbookDetailActivity.e(), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, passbookDetailActivity.getClass().getName()));
                    return;
                }
                passbookDetailActivity.a((e) new net.one97.paytm.passbook.mapping.a.b(b2, passbookDetailActivity.d(), passbookDetailActivity.e(), new CJRBusInvoiceModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, passbookDetailActivity.getClass().getName()));
            }
        }
    }

    static /* synthetic */ void b(PassbookDetailActivity passbookDetailActivity, String str, String str2) {
        boolean z2;
        long j2;
        passbookDetailActivity.registerReceiver(passbookDetailActivity.I, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        Uri parse = Uri.parse(str2);
        int applicationEnabledSetting = passbookDetailActivity.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
            passbookDetailActivity.c();
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || !"mounted".equals(Environment.getExternalStorageState())) {
            passbookDetailActivity.a();
            j2 = 0;
        } else {
            passbookDetailActivity.F = (DownloadManager) passbookDetailActivity.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
            DownloadManager.Request request = new DownloadManager.Request(parse);
            request.addRequestHeader("ssotoken", com.paytm.utility.a.q(passbookDetailActivity));
            String str3 = str + "_invoice";
            request.setTitle(str3);
            request.setDescription("Downloading...");
            request.setDestinationInExternalFilesDir(passbookDetailActivity, Environment.DIRECTORY_DOWNLOADS, str3 + ".pdf");
            request.setNotificationVisibility(1);
            j2 = passbookDetailActivity.F.enqueue(request);
            passbookDetailActivity.b();
        }
        passbookDetailActivity.G = j2;
    }

    static /* synthetic */ void c(PassbookDetailActivity passbookDetailActivity, String str, String str2) {
        if (!passbookDetailActivity.isFinishing()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(passbookDetailActivity);
            if (TextUtils.isEmpty(str)) {
                str = passbookDetailActivity.getResources().getString(R.string.alert);
            }
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.a(-3, passbookDetailActivity.getResources().getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                }
            });
            hVar.show();
        }
    }
}
