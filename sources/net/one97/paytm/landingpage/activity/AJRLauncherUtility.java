package net.one97.paytm.landingpage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.p2mNewDesign.models.b;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.a;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;

public class AJRLauncherUtility extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private int f52661a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        View view = new View(this);
        view.setBackgroundColor(-16777216);
        setContentView(view);
        this.f52661a = getIntent().getIntExtra("extra_type", 1);
    }

    public void onResume() {
        super.onResume();
        int i2 = this.f52661a;
        if (i2 == 1) {
            a("long_press_paytm_menu_button_clicked", "Add Money");
            a.a();
            a.a((Activity) this);
        } else if (i2 == 2) {
            a("long_press_paytm_menu_button_clicked", "Scan & Pay");
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    Intent intent;
                    if (com.paytm.utility.a.p(AJRLauncherUtility.this)) {
                        b.c().a("Shorctut");
                        intent = new Intent(AJRLauncherUtility.this, PaySendActivityV2.class);
                        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
                    } else {
                        intent = new Intent(AJRLauncherUtility.this, PaySendInfoActivity.class);
                        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
                    }
                    AJRLauncherUtility.this.startActivity(intent);
                    AJRLauncherUtility.this.finish();
                }
            }, 500);
        } else {
            if (i2 == 3) {
                a("long_press_paytm_menu_button_clicked", "View Balance");
                net.one97.paytm.payments.d.a.a((Activity) this, "paytmmp://cash_wallet?featuretype=cash_ledger");
            } else if (i2 == 4) {
                a("long_press_paytm_menu_button_clicked", "Transfer Money");
                if (!com.paytm.utility.a.p(this)) {
                    Intent intent = new Intent(this, PaySendInfoActivity.class);
                    intent.putExtra("dest", UpiConstants.WALLET_TYPE_MONEY_TRANSFER);
                    startActivity(intent);
                }
            } else {
                return;
            }
            finish();
        }
    }

    private void a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("menu_button_name", str2);
            net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}
