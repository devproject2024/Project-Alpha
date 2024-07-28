package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.z;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.wallet.R;

public class QRZoomActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f70542a;

    /* renamed from: b  reason: collision with root package name */
    private Toolbar f70543b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f70544c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70545d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70546e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70547f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f70548g = true;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f70549h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(true);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        setContentView(R.layout.activity_qr_zoom);
        getSupportActionBar().b(true);
        getSupportActionBar().a(2.0f);
        setTitle(getString(R.string.qrcode));
        this.f70542a = (ImageView) findViewById(R.id.activity_qr_zoom_iv_qrcode);
        int a2 = b.a((Activity) this);
        this.f70542a.getLayoutParams().width = a2;
        this.f70542a.getLayoutParams().height = a2;
        this.f70542a.requestLayout();
        this.f70543b = (Toolbar) findViewById(R.id.activity_show_code_toolbar);
        this.f70544c = (LinearLayout) findViewById(R.id.ll_balance_header);
        this.f70545d = (TextView) findViewById(R.id.tv_show_screen_to_cashier);
        this.f70546e = (TextView) findViewById(R.id.activity_show_code_heading2);
        this.f70547f = (TextView) findViewById(R.id.tv_add_money);
        this.f70549h = (ImageView) findViewById(R.id.activity_show_code_btn_back);
        if (getIntent().getExtras() != null) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("qrcode");
            if (getIntent().getBooleanExtra("is_for_dmrc", false)) {
                getSupportActionBar().e();
                findViewById(R.id.activity_qr_zoom_paytm_logo).setVisibility(8);
            } else if (getIntent().getBooleanExtra("is_from_show_code", false)) {
                getSupportActionBar().f();
                this.f70543b.setVisibility(0);
                this.f70546e.setText(String.format(getString(R.string.available_balance), new Object[]{"--.-"}));
                this.f70544c.setVisibility(0);
                this.f70545d.setVisibility(0);
                this.f70547f.setOnClickListener(this);
                this.f70549h.setOnClickListener(this);
            } else {
                getSupportActionBar().f();
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            if (Build.VERSION.SDK_INT >= 16) {
                this.f70542a.setBackground(new BitmapDrawable(getResources(), decodeByteArray));
            } else {
                this.f70542a.setBackgroundDrawable(new BitmapDrawable(getResources(), decodeByteArray));
            }
        }
        this.f70542a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRZoomActivity.this.onBackPressed();
            }
        });
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.wallet.communicator.b.a().wrapContextByRestring(context));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void a(boolean z) {
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (z) {
                attributes.screenBrightness = 1.0f;
            } else {
                attributes.screenBrightness = -1.0f;
            }
            getWindow().setAttributes(attributes);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDestroy() {
        a(false);
        super.onDestroy();
    }

    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_add_money) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "show code");
                hashMap.put("event_category", d.bE);
                hashMap.put("event_action", "add_money_clicked");
                hashMap.put(d.cw, "clicks add money");
                hashMap.put("user_id", b.n((Context) this));
                hashMap.put(d.cv, "offline_payments");
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
            } catch (Exception e2) {
                if (b.v) {
                    q.d(String.valueOf(e2));
                }
            }
            this.f70548g = true;
            net.one97.paytm.wallet.communicator.b.a().openAddMoneyScreen(this);
        } else if (id == R.id.activity_show_code_btn_back) {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f70548g) {
            try {
                String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "checkBalance");
                if (stringFromGTM != null) {
                    if (URLUtil.isValidUrl(stringFromGTM)) {
                        String e2 = b.e((Context) this, stringFromGTM);
                        HashMap hashMap = new HashMap();
                        hashMap.put("ssotoken", a.q(this));
                        hashMap.put("Accept-Encoding", "gzip");
                        if (b.c((Context) this)) {
                            new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, (String) null).c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    QRZoomActivity.this.a((f) obj);
                                }
                            });
                        }
                    }
                }
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
            this.f70548g = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a != h.SUCCESS) {
            h hVar = h.ERROR;
        } else if (fVar.f55797b instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double amount = cJRCashWallet.getResponse().getAmount();
                String b2 = b.b(Double.valueOf(amount));
                net.one97.paytm.wallet.utility.a.a((Context) this, amount);
                this.f70546e.setText(String.format(getString(R.string.available_balance), new Object[]{b2}));
            }
        }
    }
}
