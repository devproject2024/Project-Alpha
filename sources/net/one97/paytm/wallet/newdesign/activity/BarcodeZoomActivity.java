package net.one97.paytm.wallet.newdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.z;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.AJRLockActivity;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class BarcodeZoomActivity extends AJRLockActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f70471a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f70472b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70473c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f70474e = true;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(true);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        getSupportActionBar().f();
        setContentView(R.layout.w_activity_barcode_zoom);
        this.f70471a = (ImageView) findViewById(R.id.activity_barcode_zoom_iv_barcode);
        this.f70472b = (TextView) findViewById(R.id.activity_show_code_heading2);
        this.f70473c = (TextView) findViewById(R.id.tv_add_money);
        this.f70473c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BarcodeZoomActivity.a(BarcodeZoomActivity.this, "add_money_clicked", "clicks add money");
                BarcodeZoomActivity.a(BarcodeZoomActivity.this);
            }
        });
        this.f70472b.setText(String.format(getString(R.string.p2b_wallet_rs), new Object[]{"--.-"}));
        if (getIntent() != null) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("barcode");
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            if (Build.VERSION.SDK_INT >= 16) {
                this.f70471a.setBackground(new BitmapDrawable(getResources(), createBitmap));
            } else {
                this.f70471a.setBackgroundDrawable(new BitmapDrawable(getResources(), createBitmap));
            }
        }
        this.f70471a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BarcodeZoomActivity.super.onBackPressed();
            }
        });
        findViewById(R.id.activity_show_code_btn_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BarcodeZoomActivity.this.finish();
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 301 && com.paytm.utility.b.r((Context) this)) {
            a();
        }
    }

    private void b(boolean z) {
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

    private void a() {
        try {
            String stringFromGTM = b.a().getStringFromGTM(this, "checkBalance");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = com.paytm.utility.b.e((Context) this, stringFromGTM);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", a.q(this));
                hashMap.put("Accept-Encoding", "gzip");
                if (com.paytm.utility.b.c((Context) this)) {
                    new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, (String) null).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            BarcodeZoomActivity.this.a((f) obj);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f70474e) {
            a();
            this.f70474e = false;
        }
    }

    public void onDestroy() {
        b(false);
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a != h.SUCCESS) {
            h hVar = h.ERROR;
        } else if (fVar.f55797b instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double amount = cJRCashWallet.getResponse().getAmount();
                String b2 = com.paytm.utility.b.b(Double.valueOf(amount));
                net.one97.paytm.wallet.utility.a.a((Context) this, amount);
                this.f70472b.setText(String.format(getString(R.string.p2b_wallet_rs), new Object[]{b2}));
            }
        }
    }

    static /* synthetic */ void a(BarcodeZoomActivity barcodeZoomActivity, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "show code");
            hashMap.put("event_category", d.bE);
            hashMap.put("event_action", str);
            hashMap.put(d.cw, str2);
            hashMap.put("user_id", com.paytm.utility.b.n((Context) barcodeZoomActivity));
            hashMap.put(d.cv, "offline_payments");
            b.a().sendCustomGTMEvent(barcodeZoomActivity, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    static /* synthetic */ void a(BarcodeZoomActivity barcodeZoomActivity) {
        barcodeZoomActivity.f70474e = true;
        b.a().openAddMoneyScreen(barcodeZoomActivity);
    }
}
