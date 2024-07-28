package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public class FullKYCPendingActivity extends UpgradeKycBaseActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(R.string.vip_customer));
        Button button = (Button) findViewById(R.id.activity_upgrade_kyc_button_home);
        button.setOnClickListener(this);
        ((ImageView) findViewById(R.id.upgrade_icon)).setImageResource(R.drawable.wallet_under_process);
        ((TextView) findViewById(R.id.kyc_upgradewallet_tv)).setText(getString(R.string.msg_kycrequest));
        button.setText(getString(R.string.great_go_shopping));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.activity_upgrade_kyc_button_home) {
            HashMap hashMap = new HashMap();
            hashMap.put("kyc_aadhaar_otp_user_id", b.n((Context) this));
            e.a aVar = e.f66028b;
            e.a.b().a("kyc_aadhaar_otp_ok_clicked", (HashMap<String, Object>) hashMap, (Context) this);
            e.a aVar2 = e.f66028b;
            e.a.b().a((Activity) this);
        }
    }

    public void onBackPressed() {
        Intent intent;
        try {
            e.a aVar = e.f66028b;
            intent = new Intent(this, Class.forName(e.a.b().b()));
        } catch (ClassNotFoundException unused) {
            intent = null;
        }
        intent.setFlags(67108864);
        startActivity(intent);
        super.onBackPressed();
    }

    public final int a() {
        return R.layout.activity_full_kyc_pending;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }
}
