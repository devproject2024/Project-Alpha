package net.one97.paytm.wallet.p2p;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class P2PReferShopSuccessActivity extends P2PAppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f71535a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f71536b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f71537c;

    /* renamed from: e  reason: collision with root package name */
    private TextView f71538e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f71539f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f71540g;

    /* renamed from: h  reason: collision with root package name */
    private String f71541h;

    /* renamed from: i  reason: collision with root package name */
    private String f71542i;
    private String j;
    private LinearLayout k;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_p2_refer_shop_success);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        if (getIntent().hasExtra("merchantName")) {
            this.f71542i = getIntent().getStringExtra("merchantName");
        }
        if (getIntent().hasExtra("merchantMobileNumber")) {
            this.f71541h = getIntent().getStringExtra("merchantMobileNumber");
        }
        if (getIntent().hasExtra("merchant_address")) {
            this.j = getIntent().getStringExtra("merchant_address");
        }
        this.f71535a = (ImageView) findViewById(R.id.p2p_back_arrow_iv);
        this.f71535a.setOnClickListener(this);
        this.f71536b = (ImageView) findViewById(R.id.p2p_share_iv);
        this.k = (LinearLayout) findViewById(R.id.main_content);
        this.f71537c = (TextView) findViewById(R.id.tv_shop_name);
        this.f71538e = (TextView) findViewById(R.id.tv_shopkeeper_no);
        this.f71539f = (TextView) findViewById(R.id.tv_date);
        this.f71540g = (TextView) findViewById(R.id.tv_shopkeeper_address);
        this.f71536b.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.f71542i)) {
            this.f71537c.setText(this.f71542i);
            if (!TextUtils.isEmpty(this.f71541h)) {
                this.f71538e.setText(this.f71541h);
            }
        } else {
            this.f71537c.setText(this.f71541h);
            this.f71538e.setText("");
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.f71540g.setVisibility(0);
            this.f71540g.setText(this.j);
        } else {
            this.f71540g.setVisibility(8);
        }
        this.f71539f.setText(b.a().getCurrentDateAndTimeFromUpiUtils());
        b.a().sendGTMOpenScreenWithDeviceInfo(this, "/refer-shopkeeper-thankyou", "refer_shopkeeper");
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.p2p_back_arrow_iv) {
            finish();
        } else if (id == R.id.p2p_share_iv) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "refer_shopkeeper_detail");
            hashMap.put("event_action", "share_details_clicked");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
            hashMap.put("VERTICAL_NAME", "refer_shopkeeper");
            b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
            if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                a();
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 48);
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 48) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                com.paytm.utility.b.b((Context) this, "", "Please go to Settings and give Paytm app Storage permission.");
            } else {
                a();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "refer_shopkeeper_detail_fail"
            java.lang.String r3 = "custom_event"
            java.lang.String r4 = "refer_shopkeeper"
            java.lang.String r5 = "VERTICAL_NAME"
            java.lang.String r6 = "/refer-shopkeeper"
            java.lang.String r7 = "screenName"
            java.lang.String r8 = "user_id"
            java.lang.String r9 = "event_action"
            java.lang.String r10 = "refer_shopkeeper_detail"
            java.lang.String r11 = "event_category"
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0100 }
            java.lang.String r12 = "android.intent.action.SEND"
            r0.<init>(r12)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r12 = "image/png"
            r0.setType(r12)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r12 = "android.intent.extra.SUBJECT"
            int r13 = net.one97.paytm.wallet.R.string.post_payment_share_subject     // Catch:{ Exception -> 0x0100 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0100 }
            r0.putExtra(r12, r13)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r12 = ""
            java.lang.String r13 = "android.intent.extra.TEXT"
            r0.putExtra(r13, r12)     // Catch:{ Exception -> 0x0100 }
            android.widget.LinearLayout r12 = r1.k     // Catch:{ Exception -> 0x0100 }
            int r12 = r12.getWidth()     // Catch:{ Exception -> 0x0100 }
            android.widget.LinearLayout r13 = r1.k     // Catch:{ Exception -> 0x0100 }
            int r13 = r13.getHeight()     // Catch:{ Exception -> 0x0100 }
            android.graphics.Bitmap$Config r14 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0100 }
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r12, r13, r14)     // Catch:{ Exception -> 0x0100 }
            android.graphics.Canvas r13 = new android.graphics.Canvas     // Catch:{ Exception -> 0x0100 }
            r13.<init>(r12)     // Catch:{ Exception -> 0x0100 }
            android.widget.LinearLayout r14 = r1.k     // Catch:{ Exception -> 0x0100 }
            r14.draw(r13)     // Catch:{ Exception -> 0x0100 }
            android.content.ContentResolver r13 = r17.getContentResolver()     // Catch:{ Exception -> 0x0100 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
            r14.<init>()     // Catch:{ Exception -> 0x0100 }
            int r15 = net.one97.paytm.wallet.R.string.title     // Catch:{ Exception -> 0x0100 }
            java.lang.String r15 = r1.getString(r15)     // Catch:{ Exception -> 0x0100 }
            r14.append(r15)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r15 = "-"
            r14.append(r15)     // Catch:{ Exception -> 0x0100 }
            r15 = r2
            r16 = r3
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fb }
            r14.append(r2)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r2 = r14.toString()     // Catch:{ Exception -> 0x00fb }
            r3 = 0
            java.lang.String r2 = android.provider.MediaStore.Images.Media.insertImage(r13, r12, r2, r3)     // Catch:{ Exception -> 0x00fb }
            if (r2 != 0) goto L_0x007d
            return
        L_0x007d:
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r3 = "android.intent.extra.STREAM"
            r0.putExtra(r3, r2)     // Catch:{ Exception -> 0x00fb }
            int r2 = net.one97.paytm.wallet.R.string.post_payment_share_title     // Catch:{ Exception -> 0x00fb }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x00fb }
            android.content.Intent r0 = android.content.Intent.createChooser(r0, r2)     // Catch:{ Exception -> 0x00fb }
            android.content.pm.PackageManager r2 = r17.getPackageManager()     // Catch:{ Exception -> 0x00fb }
            android.content.ComponentName r2 = r0.resolveActivity(r2)     // Catch:{ Exception -> 0x00fb }
            if (r2 == 0) goto L_0x00c5
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x00c1 }
            r2.<init>()     // Catch:{ Exception -> 0x00c1 }
            r2.put(r11, r10)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = "refer_shopkeeper_detail_success"
            r2.put(r9, r3)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r17)     // Catch:{ Exception -> 0x00c1 }
            r2.put(r8, r3)     // Catch:{ Exception -> 0x00c1 }
            r2.put(r7, r6)     // Catch:{ Exception -> 0x00c1 }
            r2.put(r5, r4)     // Catch:{ Exception -> 0x00c1 }
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x00c1 }
            r12 = r16
            r3.sendCustomGTMEvent(r1, r12, r2)     // Catch:{ Exception -> 0x00f8 }
            r1.startActivity(r0)     // Catch:{ Exception -> 0x00f8 }
            return
        L_0x00c1:
            r0 = move-exception
            r12 = r16
            goto L_0x00f9
        L_0x00c5:
            r12 = r16
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            r0.put(r11, r10)     // Catch:{ Exception -> 0x00f8 }
            r2 = r15
            r0.put(r9, r2)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r17)     // Catch:{ Exception -> 0x00f6 }
            r0.put(r8, r3)     // Catch:{ Exception -> 0x00f6 }
            r0.put(r7, r6)     // Catch:{ Exception -> 0x00f6 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x00f6 }
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x00f6 }
            r3.sendCustomGTMEvent(r1, r12, r0)     // Catch:{ Exception -> 0x00f6 }
            int r0 = net.one97.paytm.wallet.R.string.no_app_found     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x00f6 }
            r3 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)     // Catch:{ Exception -> 0x00f6 }
            r0.show()     // Catch:{ Exception -> 0x00f6 }
            return
        L_0x00f6:
            r0 = move-exception
            goto L_0x0102
        L_0x00f8:
            r0 = move-exception
        L_0x00f9:
            r2 = r15
            goto L_0x0102
        L_0x00fb:
            r0 = move-exception
            r2 = r15
            r12 = r16
            goto L_0x0102
        L_0x0100:
            r0 = move-exception
            r12 = r3
        L_0x0102:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r3.put(r11, r10)
            r3.put(r9, r2)
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r17)
            r3.put(r8, r2)
            r3.put(r7, r6)
            r3.put(r5, r4)
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            r2.sendCustomGTMEvent(r1, r12, r3)
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x012c
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.p2p.P2PReferShopSuccessActivity.a():void");
    }
}
