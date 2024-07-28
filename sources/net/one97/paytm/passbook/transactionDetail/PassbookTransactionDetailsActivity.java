package net.one97.paytm.passbook.transactionDetail;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.paytm.utility.s;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRCSTTransactionType;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.a;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.upi.util.UpiConstants;

public class PassbookTransactionDetailsActivity extends BaseActivity implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public String f58985a;

    /* renamed from: b  reason: collision with root package name */
    public int f58986b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTransaction f58987c;

    /* renamed from: d  reason: collision with root package name */
    private q f58988d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f58989e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f58990f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f58991g;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (!isFinishing()) {
            b();
            if (iJRDataModel instanceof CJRCSTTransactionType) {
                CJRCSTTransactionType cJRCSTTransactionType = (CJRCSTTransactionType) iJRDataModel;
                if (cJRCSTTransactionType == null) {
                    e();
                } else if (cJRCSTTransactionType.getResponse() == null || cJRCSTTransactionType.getResponse().getTxnDetails() == null || cJRCSTTransactionType.getResponse().getTxnDetails().size() <= 0 || cJRCSTTransactionType.getResponse().getTxnDetails().get(0).getMerchantCategory() == null) {
                    e();
                } else if (cJRCSTTransactionType.getResponse().getTxnDetails().get(0).getMerchantCategory().equalsIgnoreCase("OnPaytm")) {
                    Matcher matcher = Pattern.compile("#(\\S+)").matcher(this.f58987c.getTxnDesc2());
                    ArrayList arrayList = new ArrayList();
                    while (matcher.find()) {
                        arrayList.add(matcher.group(1));
                    }
                    if (arrayList.size() <= 0 || TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                        e();
                        return;
                    }
                    Intent intent = new Intent(this, d.b().i());
                    intent.putExtra(UpiConstants.FROM, "Order_history");
                    intent.putExtra("order_id", d((String) arrayList.get(0)));
                    startActivity(intent);
                } else {
                    e();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_transaction_detail);
        this.f58990f = (RelativeLayout) findViewById(R.id.loader_ll);
        this.f58989e = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.f58987c = (CJRTransaction) getIntent().getSerializableExtra("passbook_detail_data");
        this.f58985a = getIntent().getStringExtra("EXTENDED_TXN_INFO");
        this.f58986b = getIntent().getIntExtra("sub_wallet_type", -1);
        c(this.f58987c);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f58987c = (CJRTransaction) intent.getSerializableExtra("passbook_detail_data");
        c(this.f58987c);
    }

    private void c(CJRTransaction cJRTransaction) {
        String type = cJRTransaction.getType();
        "SUCCESS".equalsIgnoreCase(cJRTransaction.getTxnStatus());
        Fragment c2 = c(type);
        this.f58988d = getSupportFragmentManager().a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("passbook_detail_data", this.f58987c);
        bundle.putSerializable("EXTENDED_TXN_INFO", this.f58985a);
        bundle.putInt("sub_wallet_type", this.f58986b);
        c2.setArguments(bundle);
        this.f58988d.b(R.id.container_ll, c2, (String) null);
        this.f58988d.c();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.fragment.app.Fragment c(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 49
            if (r0 == r1) goto L_0x01a7
            r1 = 50
            if (r0 == r1) goto L_0x019c
            r1 = 52
            if (r0 == r1) goto L_0x0191
            r1 = 53
            if (r0 == r1) goto L_0x0187
            r1 = 55
            if (r0 == r1) goto L_0x017c
            r1 = 56
            if (r0 == r1) goto L_0x0171
            r1 = 1568(0x620, float:2.197E-42)
            if (r0 == r1) goto L_0x0167
            r1 = 1598(0x63e, float:2.239E-42)
            if (r0 == r1) goto L_0x015c
            r1 = 1600(0x640, float:2.242E-42)
            if (r0 == r1) goto L_0x0152
            r1 = 1635(0x663, float:2.291E-42)
            if (r0 == r1) goto L_0x0147
            r1 = 1669(0x685, float:2.339E-42)
            if (r0 == r1) goto L_0x013b
            r1 = 1691(0x69b, float:2.37E-42)
            if (r0 == r1) goto L_0x012f
            r1 = 1694(0x69e, float:2.374E-42)
            if (r0 == r1) goto L_0x0123
            r1 = 1606(0x646, float:2.25E-42)
            if (r0 == r1) goto L_0x0117
            r1 = 1607(0x647, float:2.252E-42)
            if (r0 == r1) goto L_0x010c
            r1 = 1730(0x6c2, float:2.424E-42)
            if (r0 == r1) goto L_0x0100
            r1 = 1731(0x6c3, float:2.426E-42)
            if (r0 == r1) goto L_0x00f5
            r1 = 1755(0x6db, float:2.459E-42)
            if (r0 == r1) goto L_0x00e9
            r1 = 1756(0x6dc, float:2.46E-42)
            if (r0 == r1) goto L_0x00dd
            switch(r0) {
                case 1570: goto L_0x00d2;
                case 1571: goto L_0x00c7;
                case 1572: goto L_0x00bb;
                case 1573: goto L_0x00af;
                default: goto L_0x0053;
            }
        L_0x0053:
            switch(r0) {
                case 1664: goto L_0x00a3;
                case 1665: goto L_0x0097;
                case 1666: goto L_0x008b;
                case 1667: goto L_0x007f;
                default: goto L_0x0056;
            }
        L_0x0056:
            switch(r0) {
                case 1696: goto L_0x0073;
                case 1697: goto L_0x0067;
                case 1698: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x01b1
        L_0x005b:
            java.lang.String r0 = "57"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 26
            goto L_0x01b2
        L_0x0067:
            java.lang.String r0 = "56"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 25
            goto L_0x01b2
        L_0x0073:
            java.lang.String r0 = "55"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 24
            goto L_0x01b2
        L_0x007f:
            java.lang.String r0 = "47"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 9
            goto L_0x01b2
        L_0x008b:
            java.lang.String r0 = "46"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 23
            goto L_0x01b2
        L_0x0097:
            java.lang.String r0 = "45"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 22
            goto L_0x01b2
        L_0x00a3:
            java.lang.String r0 = "44"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 19
            goto L_0x01b2
        L_0x00af:
            java.lang.String r0 = "16"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 10
            goto L_0x01b2
        L_0x00bb:
            java.lang.String r0 = "15"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 8
            goto L_0x01b2
        L_0x00c7:
            java.lang.String r0 = "14"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 7
            goto L_0x01b2
        L_0x00d2:
            java.lang.String r0 = "13"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 6
            goto L_0x01b2
        L_0x00dd:
            java.lang.String r0 = "73"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 29
            goto L_0x01b2
        L_0x00e9:
            java.lang.String r0 = "72"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 11
            goto L_0x01b2
        L_0x00f5:
            java.lang.String r0 = "69"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 3
            goto L_0x01b2
        L_0x0100:
            java.lang.String r0 = "68"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 16
            goto L_0x01b2
        L_0x010c:
            java.lang.String r0 = "29"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 0
            goto L_0x01b2
        L_0x0117:
            java.lang.String r0 = "28"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 18
            goto L_0x01b2
        L_0x0123:
            java.lang.String r0 = "53"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 21
            goto L_0x01b2
        L_0x012f:
            java.lang.String r0 = "50"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 28
            goto L_0x01b2
        L_0x013b:
            java.lang.String r0 = "49"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 27
            goto L_0x01b2
        L_0x0147:
            java.lang.String r0 = "36"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 15
            goto L_0x01b2
        L_0x0152:
            java.lang.String r0 = "22"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 5
            goto L_0x01b2
        L_0x015c:
            java.lang.String r0 = "20"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 14
            goto L_0x01b2
        L_0x0167:
            java.lang.String r0 = "11"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 1
            goto L_0x01b2
        L_0x0171:
            java.lang.String r0 = "8"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 12
            goto L_0x01b2
        L_0x017c:
            java.lang.String r0 = "7"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 17
            goto L_0x01b2
        L_0x0187:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 2
            goto L_0x01b2
        L_0x0191:
            java.lang.String r0 = "4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 13
            goto L_0x01b2
        L_0x019c:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 20
            goto L_0x01b2
        L_0x01a7:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b1
            r2 = 4
            goto L_0x01b2
        L_0x01b1:
            r2 = -1
        L_0x01b2:
            switch(r2) {
                case 0: goto L_0x01c7;
                case 1: goto L_0x01c7;
                case 2: goto L_0x01c7;
                case 3: goto L_0x01c7;
                case 4: goto L_0x01c1;
                case 5: goto L_0x01c1;
                case 6: goto L_0x01c1;
                case 7: goto L_0x01c1;
                case 8: goto L_0x01c1;
                case 9: goto L_0x01c1;
                case 10: goto L_0x01c1;
                case 11: goto L_0x01c1;
                case 12: goto L_0x01c1;
                case 13: goto L_0x01bb;
                case 14: goto L_0x01bb;
                case 15: goto L_0x01bb;
                case 16: goto L_0x01bb;
                case 17: goto L_0x01bb;
                case 18: goto L_0x01bb;
                case 19: goto L_0x01bb;
                case 20: goto L_0x01bb;
                case 21: goto L_0x01bb;
                case 22: goto L_0x01bb;
                case 23: goto L_0x01bb;
                case 24: goto L_0x01bb;
                case 25: goto L_0x01bb;
                case 26: goto L_0x01bb;
                case 27: goto L_0x01bb;
                case 28: goto L_0x01bb;
                case 29: goto L_0x01bb;
                default: goto L_0x01b5;
            }
        L_0x01b5:
            net.one97.paytm.passbook.transactionDetail.c.f r2 = new net.one97.paytm.passbook.transactionDetail.c.f
            r2.<init>()
            return r2
        L_0x01bb:
            net.one97.paytm.passbook.transactionDetail.c.b r2 = new net.one97.paytm.passbook.transactionDetail.c.b
            r2.<init>()
            return r2
        L_0x01c1:
            net.one97.paytm.passbook.transactionDetail.c.c r2 = new net.one97.paytm.passbook.transactionDetail.c.c
            r2.<init>()
            return r2
        L_0x01c7:
            net.one97.paytm.passbook.transactionDetail.c.d r2 = new net.one97.paytm.passbook.transactionDetail.c.d
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.c(java.lang.String):androidx.fragment.app.Fragment");
    }

    public static boolean a(CJRTransaction cJRTransaction) {
        return a(cJRTransaction.getType(), cJRTransaction.getTxnStatus(), cJRTransaction.getTxnDesc1());
    }

    public static boolean a(String str, String str2, String str3) {
        e.a();
        if (e.h()) {
            return false;
        }
        if ("1".equals(str) && str3.startsWith("Rajkot")) {
            return false;
        }
        "SUCCESS".equalsIgnoreCase(str2);
        c(str);
        return true;
    }

    public final void a() {
        if (!isFinishing()) {
            a.a(this.f58989e);
            this.f58990f.setVisibility(0);
        }
    }

    public final void b() {
        if (!isFinishing()) {
            a.b(this.f58989e);
            this.f58990f.setVisibility(8);
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

    private void e() {
        Intent intent = new Intent(this, d.b().h());
        intent.putExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, this.f58987c);
        intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, true);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return b.b(str, str.contains(AppUtility.CENTER_DOT) ? "##,##,##,##,###.00" : AppConstants.PRICE_PATTERN);
    }

    public final void d() {
        String str;
        String str2;
        String str3;
        if (!isFinishing()) {
            if (this.f58986b == n.TOLL.getValue()) {
                str3 = "passbook_fastag_wallet";
                str2 = "fastag_wallet_passbook_share_clicked";
                str = "/passbook/fastag-wallet/txn-detail";
            } else if (this.f58986b == n.FOOD_WALLET.getValue()) {
                str3 = "passbook_food_wallet";
                str2 = "food_wallet_passbook_share_clicked";
                str = "/passbook/food-wallet/txn-detail";
            } else if (this.f58986b == n.GIFT_CARDS.getValue()) {
                str3 = "passbook_gift_wallet";
                str2 = "gift_wallet_recent_txn_clicked";
                str = "/passbook/gift-wallet/txn-detail";
            } else if (this.f58986b == n.PAYTM_WALLET.getValue()) {
                str3 = "passbook_wallet";
                str2 = "wallet_passbook_share_clicked";
                str = "/passbook/wallet/txn-detail";
            } else if (this.f58986b == n.GIFT_VOUCHER.getValue()) {
                net.one97.paytm.passbook.utility.q.a(this, "gift_voucher", "gv_added_share_clicked", (String) null, (String) null, "/passbook/gift-voucher", "gift_voucher");
                return;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            net.one97.paytm.passbook.utility.q.a(this, str3, str2, (ArrayList<String>) null, str);
        }
    }

    public static void a(Context context, View view, String str, String str2) {
        if (context != null && view != null && str != null && str2 != null) {
            view.setOnLongClickListener(new View.OnLongClickListener(context, str, str2) {
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final boolean onLongClick(View view) {
                    return PassbookTransactionDetailsActivity.a(this.f$0, this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(Context context, String str, String str2, View view) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
        Toast.makeText(context, str2, 0).show();
        return true;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        PassbookTransactionDetailsActivity.class.getSimpleName();
        j.a((Activity) this, (Throwable) networkCustomError);
    }

    public final void a(Runnable runnable) {
        this.f58991g = runnable;
        d();
        if (!s.a() || s.c((Activity) this)) {
            f();
        } else {
            s.b((Activity) this);
        }
    }

    private void f() {
        a();
        this.f58991g.run();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            f();
        } else if (androidx.core.app.a.a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Toast.makeText(this, "Storage permission is required to share the screen.", 0).show();
        } else {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        s.b((Context) PassbookTransactionDetailsActivity.this);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), $$Lambda$PassbookTransactionDetailsActivity$r98rPDKcmz4dIiVWFBYxan6oUGk.INSTANCE);
                builder.show();
            } catch (Exception unused) {
            }
        }
    }

    public static String b(CJRTransaction cJRTransaction) {
        if (cJRTransaction == null) {
            return null;
        }
        if (cJRTransaction.getFormattedTxnTime() != null) {
            return cJRTransaction.getTxnDate() + ", " + cJRTransaction.getFormattedTxnTime();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return new SimpleDateFormat("dd MMM, yyyy hh:mm a", Locale.US).format(simpleDateFormat.parse(cJRTransaction.getTxnDate()));
        } catch (ParseException unused) {
            return "";
        }
    }

    public final void c() {
        String str;
        String str2;
        String str3;
        int i2 = this.f58986b;
        if (i2 != -1) {
            if (i2 == n.TOLL.getValue()) {
                str3 = "passbook_fastag_wallet";
                str2 = "fastag_wallet_passbook_need_help_clicked";
                str = "/passbook/fastag-wallet/txn-detail";
            } else if (this.f58986b == n.FOOD_WALLET.getValue()) {
                str3 = "passbook_food_wallet";
                str2 = "food_wallet_passbook_need_help_clicked";
                str = "/passbook/food-wallet/txn-detail";
            } else if (this.f58986b == n.GIFT_CARDS.getValue()) {
                str3 = "passbook_gift_wallet";
                str2 = "gift_wallet_passbook_need_help_clicked";
                str = "/passbook/gift-wallet/txn-detail";
            } else if (this.f58986b == n.PAYTM_WALLET.getValue()) {
                str3 = "passbook_wallet";
                str2 = "wallet_passbook_need_help_clicked";
                str = "/passbook/wallet/txn-detail";
            } else if (this.f58986b == n.GIFT_VOUCHER.getValue()) {
                net.one97.paytm.passbook.utility.q.a(this, "gift_voucher", "gv_added_needhelp_clicked", (String) null, (String) null, "/passbook/gift-voucher/recent", "gift_voucher");
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            net.one97.paytm.passbook.utility.q.a(this, str3, str2, (ArrayList<String>) null, str);
        }
        if (TextUtils.isEmpty(this.f58987c.getTxnDesc1()) || !this.f58987c.getTxnDesc1().startsWith("Paytm") || this.f58987c.getType().equals("7")) {
            d.b().a((AppCompatActivity) this, this.f58987c);
            return;
        }
        final CJRTransaction cJRTransaction = this.f58987c;
        final h hVar = new h(this);
        hVar.setTitle(getString(R.string.needhelp_dialog_title));
        hVar.a(getString(R.string.passbook_contact_us_order_history));
        hVar.a(-3, getResources().getString(R.string.passbook_go_to_order_history), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
                Intent intent = new Intent(PassbookTransactionDetailsActivity.this, d.b().i());
                intent.putExtra(UpiConstants.FROM, "Order_history");
                if (!TextUtils.isEmpty(cJRTransaction.getTxnDescription1())) {
                    intent.putExtra("order_id", PassbookTransactionDetailsActivity.d(cJRTransaction.getTxnDescription1()));
                }
                PassbookTransactionDetailsActivity.this.startActivity(intent);
            }
        });
        hVar.setCancelable(true);
        hVar.show();
    }
}
