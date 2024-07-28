package net.one97.paytm.landingpage.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.CLPConstants;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;

public class UniversalScannerLauncherActivity extends PaytmActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
        a.b((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.j.a.a((Context) this, "app_open", CLPConstants.NETWORK + com.paytm.utility.a.l(this) + ";root_status=false", CLPConstants.NETWORK_RPOVIDER + com.paytm.utility.a.l(this) + ";current_language = " + n.a((Context) this, n.a()), "qr_scan_widget", "", "sessional event", "wallet");
        Intent intent = new Intent(this, PaySendActivityV2.class);
        intent.addFlags(32768);
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
        intent.putExtra("from_universal_scanner", true);
        startActivity(intent);
        finish();
        requestWindowFeature(1);
        getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        View view = new View(this);
        view.setBackgroundColor(-16777216);
        setContentView(view);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }
}
