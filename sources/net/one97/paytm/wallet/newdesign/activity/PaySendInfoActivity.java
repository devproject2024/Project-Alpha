package net.one97.paytm.wallet.newdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.utility.q;
import java.io.UnsupportedEncodingException;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.p2p.P2PAppCompatActivity;

public class PaySendInfoActivity extends P2PAppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    String f70534a;

    /* renamed from: b  reason: collision with root package name */
    String f70535b;

    /* renamed from: c  reason: collision with root package name */
    boolean f70536c;

    /* renamed from: e  reason: collision with root package name */
    String f70537e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f70538f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f70539g;

    /* renamed from: h  reason: collision with root package name */
    private String f70540h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f70541i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.w_activity_paysend_info);
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        Intent intent = getIntent();
        getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        this.f70538f = intent.getBundleExtra("resultant activity_bundle");
        this.f70539g = intent.getBooleanExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
        this.f70534a = intent.getStringExtra(CJRQRScanResultModel.KEY_QR_CODE_ID);
        this.f70535b = intent.getStringExtra("qr_scan_result");
        this.f70537e = intent.getStringExtra("mobile");
        this.f70536c = intent.getBooleanExtra("contact_picker", false);
        this.f70540h = intent.getStringExtra("dest");
        if (intent.hasExtra("UNI_P2P_BUNDLE")) {
            this.f70541i = intent.getBundleExtra("UNI_P2P_BUNDLE");
        }
        b.a().callLoginActivity(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (!b.a().isMinKycDone(this) && com.paytm.utility.b.r(getApplicationContext())) {
            try {
                b.a().checkDeepLinking(this, "paytmmp://cash_wallet", "wallet");
            } catch (UnsupportedEncodingException e2) {
                q.d(String.valueOf(e2));
            }
            finish();
        } else if (i2 == 301 && com.paytm.utility.b.r((Context) this) && TextUtils.isEmpty(this.f70540h)) {
            Intent intent2 = new Intent(this, PaySendActivityV2.class);
            intent2.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, this.f70539g);
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                String stringExtra = getIntent().getStringExtra("openTab");
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent2.putExtra("openTab", stringExtra);
                }
            }
            Bundle bundle = this.f70538f;
            if (bundle != null) {
                intent2.putExtra("extra_home_data", bundle);
            }
            intent2.setFlags(67108864);
            startActivity(intent2);
            finish();
        } else if (i2 == 301 && com.paytm.utility.b.r((Context) this) && this.f70540h.equalsIgnoreCase(UpiConstants.WALLET_TYPE_MONEY_TRANSFER)) {
            b.a().startMoneyTransferActivity(this, this.f70539g, this.f70538f);
            finish();
        } else if (i2 == 301 && com.paytm.utility.b.r((Context) this) && this.f70540h.equalsIgnoreCase("show_code")) {
            Intent intent3 = new Intent(this, ShowCodeActivity.class);
            intent3.setFlags(67108864);
            startActivity(intent3);
            finish();
        } else if (i2 == 301 && com.paytm.utility.b.r((Context) this) && this.f70540h.equalsIgnoreCase("qr_send_money")) {
            Intent intent4 = new Intent(this, AJRQRActivity.class);
            intent4.putExtra("OPERATION", "scan");
            intent4.setFlags(67108864);
            if (!TextUtils.isEmpty(this.f70534a)) {
                intent4.putExtra("QR_CODE_ID", this.f70534a);
                intent4.putExtra(CJRQRScanResultModel.KEY_QR_CODE_ID, this.f70534a);
            } else if (!TextUtils.isEmpty(this.f70535b)) {
                intent4.putExtra("scan_result", this.f70535b);
            }
            startActivity(intent4);
            finish();
        } else if (i2 == 301 && com.paytm.utility.b.r((Context) this) && this.f70540h.equalsIgnoreCase("p2p_screen")) {
            Intent intent5 = new Intent(this, P2PActivity.class);
            intent5.setFlags(67108864);
            Bundle bundle2 = this.f70541i;
            if (bundle2 != null) {
                intent5.putExtra("UNI_P2P_BUNDLE", bundle2);
            } else {
                if (!TextUtils.isEmpty(this.f70537e)) {
                    intent5.putExtra("mobile", this.f70537e);
                }
                intent5.putExtra("contact_picker", this.f70536c);
            }
            startActivity(intent5);
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
