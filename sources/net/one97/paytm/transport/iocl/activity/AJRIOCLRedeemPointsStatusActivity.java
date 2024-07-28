package net.one97.paytm.transport.iocl.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl.b.c;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl.others.HomeTabItem;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRIOCLRedeemPointsStatusActivity extends AppCompatActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f14257a = AJRIOCLRedeemPointsStatusActivity.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private IOCLBaseModel f14258b;

    /* renamed from: c  reason: collision with root package name */
    private String f14259c = "";

    /* renamed from: d  reason: collision with root package name */
    private boolean f14260d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f14261e = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!view.isSelected()) {
                Object tag = view.getTag();
                if (tag instanceof HomeTabItem) {
                    AJRIOCLRedeemPointsStatusActivity.a(AJRIOCLRedeemPointsStatusActivity.this, ((HomeTabItem) tag).getUrlType());
                    return;
                }
                String unused = AJRIOCLRedeemPointsStatusActivity.f14257a;
                q.c();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.iocl_point_redeem);
        a.c().sendOpenScreenEvent(this, "/iocl-xtrarewards-redemption");
        try {
            Intent intent = getIntent();
            if (!(intent == null || intent.getSerializableExtra("common_response") == null)) {
                this.f14258b = (IOCLBaseModel) intent.getSerializableExtra("common_response");
            }
            ImageView imageView = (ImageView) findViewById(R.id.status_icon);
            TextView textView = (TextView) findViewById(R.id.tv_booking_confirm_text);
            TextView textView2 = (TextView) findViewById(R.id.tv_amount);
            TextView textView3 = (TextView) findViewById(R.id.tv_cta);
            TextView textView4 = (TextView) findViewById(R.id.tv_time_stamp);
            TextView textView5 = (TextView) findViewById(R.id.wallet_balance);
            TextView textView6 = (TextView) findViewById(R.id.txn_id);
            View findViewById = findViewById(R.id.money_container);
            View findViewById2 = findViewById(R.id.success_redeem_layout);
            View findViewById3 = findViewById(R.id.pending_redeem_layout);
            View findViewById4 = findViewById(R.id.line_above_wallet_balance);
            ((TextView) findViewById(R.id.pay_now)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.f(view);
                }
            });
            TextView textView7 = (TextView) findViewById(R.id.view_iocl_wallet);
            textView7.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.e(view);
                }
            });
            Object obj = "/iocl-xtrarewards-redemption";
            ((TextView) findViewById(R.id.iocl_wallet)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.d(view);
                }
            });
            findViewById(R.id.tv_need_help).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.c(view);
                }
            });
            findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.b(view);
                }
            });
            findViewById(R.id.tv_need_help_success).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRIOCLRedeemPointsStatusActivity.this.a(view);
                }
            });
            if (!(this.f14258b == null || this.f14258b.getResponse() == null)) {
                textView4.setText(a(this.f14258b.getResponse().getTransactionTime().longValue()));
                textView3.setText(this.f14258b.getResponse().getPrimaryMessage());
                if (this.f14258b.getResponse().getIoclTxnNo() == null || TextUtils.isEmpty(this.f14258b.getResponse().getIoclTxnNo())) {
                    textView6.setVisibility(8);
                } else {
                    String ioclTxnNo = this.f14258b.getResponse().getIoclTxnNo();
                    textView6.setText(getString(R.string.iocl_txn_id) + " " + ioclTxnNo);
                    textView6.setVisibility(0);
                }
                String format = String.format("%.2f", new Object[]{this.f14258b.getResponse().getTransactionPoints()});
                String format2 = String.format("%.2f", new Object[]{this.f14258b.getResponse().getTransactionAmount()});
                if (this.f14258b.getResponse().getRedeemStatus().equalsIgnoreCase("SUCCESS")) {
                    this.f14259c = "success";
                    imageView.setBackground(b.a((Context) this, R.drawable.success_green_icon));
                    if (TextUtils.isEmpty(this.f14258b.getResponse().getEarnedOrRedeemed()) || !this.f14258b.getResponse().getEarnedOrRedeemed().equalsIgnoreCase("Points Earned")) {
                        textView.setText(String.format(getString(R.string.iocl_status_text_redeem), new Object[]{format, getString(R.string.iocl_successful)}));
                    } else {
                        textView.setText(String.format(getString(R.string.iocl_status_text_accural), new Object[]{format, getString(R.string.iocl_successful)}));
                    }
                    textView2.setText(format2);
                    if (this.f14258b.getResponse().getUpdatedWalletBalance() != null) {
                        textView5.setText(getString(R.string.iocl_updated_wallet_balance) + String.valueOf(this.f14258b.getResponse().getUpdatedWalletBalance()));
                        textView5.setVisibility(0);
                        i2 = 8;
                    } else {
                        i2 = 8;
                        textView5.setVisibility(8);
                    }
                    findViewById.setVisibility(0);
                    findViewById4.setVisibility(0);
                    findViewById2.setVisibility(0);
                    textView7.setVisibility(0);
                    findViewById3.setVisibility(i2);
                } else if (this.f14258b.getResponse().getRedeemStatus().equalsIgnoreCase("PENDING")) {
                    this.f14259c = "pending_" + this.f14258b.getResponse().getPrimaryMessage();
                    imageView.setBackground(b.a((Context) this, R.drawable.iocl_ic_pending));
                    if (TextUtils.isEmpty(this.f14258b.getResponse().getEarnedOrRedeemed()) || !this.f14258b.getResponse().getEarnedOrRedeemed().equalsIgnoreCase("Points Earned")) {
                        textView.setText(String.format(getString(R.string.iocl_status_text_redeem), new Object[]{format, getString(R.string.iocl_pending)}));
                    } else {
                        textView.setText(String.format(getString(R.string.iocl_status_text_accural), new Object[]{format, getString(R.string.iocl_pending)}));
                    }
                    findViewById.setVisibility(8);
                    textView5.setVisibility(8);
                    findViewById4.setVisibility(4);
                    findViewById2.setVisibility(8);
                    textView7.setVisibility(8);
                    findViewById3.setVisibility(0);
                } else if (this.f14258b.getResponse().getRedeemStatus().equalsIgnoreCase("FAILURE")) {
                    this.f14259c = "failed_" + this.f14258b.getResponse().getPrimaryMessage();
                    imageView.setBackground(b.a((Context) this, R.drawable.iocl_ic_failed));
                    if (TextUtils.isEmpty(this.f14258b.getResponse().getEarnedOrRedeemed()) || !this.f14258b.getResponse().getEarnedOrRedeemed().equalsIgnoreCase("Points Earned")) {
                        textView.setText(String.format(getString(R.string.iocl_status_text_redeem), new Object[]{format, getString(R.string.iocl_failed)}));
                    } else {
                        textView.setText(String.format(getString(R.string.iocl_status_text_accural), new Object[]{format, getString(R.string.iocl_failed)}));
                    }
                    findViewById.setVisibility(8);
                    textView5.setVisibility(8);
                    findViewById4.setVisibility(4);
                    findViewById2.setVisibility(8);
                    textView7.setVisibility(8);
                    findViewById3.setVisibility(0);
                }
            }
            c.a aVar = c.f14280a;
            c.a.a(this, "iocl_xtrarewards", "redemption_screen_loaded", obj, this.f14259c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        c.a aVar = c.f14280a;
        c.a.a(this, "iocl_xtrarewards", "pay_now_clicked", "/iocl-xtrarewards-redemption", "");
        Intent intent = new Intent(this, a.b().getPaySendActivity());
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        c.a aVar = c.f14280a;
        c.a.a(this, "iocl_xtrarewards", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, "/iocl-xtrarewards-redemption", "redemption_screen");
        a.b().launchDeeplink("paytmmp://cash_wallet?featuretype=cash_ledger", this, "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        c.a aVar = c.f14280a;
        c.a.a(this, "iocl_xtrarewards", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, "/iocl-xtrarewards-redemption", "redemption_screen");
        a.b().launchDeeplink("paytmmp://cash_wallet?featuretype=cash_ledger", this, "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        c.a aVar = c.f14280a;
        c.a.a(this, "iocl_xtrarewards", "help_clicked", "/iocl-xtrarewards-redemption", "");
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    private static String a(long j) {
        try {
            return new SimpleDateFormat("hh:mm a,dd MMM yyyy").format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    private void b() {
        if (!this.f14260d) {
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText(getString(R.string.iocl_know_more_header));
            cJRReplacementReason.setId(Integer.parseInt("2400001"));
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) null);
            a.b().openH5CST(this, bundle);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRIOCLRedeemPointsStatusActivity.this.c();
                }
            }, 300);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f14260d = false;
    }

    static /* synthetic */ void a(AJRIOCLRedeemPointsStatusActivity aJRIOCLRedeemPointsStatusActivity, String str) {
        Intent intent = new Intent(aJRIOCLRedeemPointsStatusActivity, a.b().getAJRMainActivity());
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
        aJRIOCLRedeemPointsStatusActivity.startActivity(intent);
        aJRIOCLRedeemPointsStatusActivity.finish();
    }
}
